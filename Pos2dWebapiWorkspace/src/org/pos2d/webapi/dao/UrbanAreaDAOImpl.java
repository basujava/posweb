/**
 * 
 */
package org.pos2d.webapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.cities;
import org.pos2d.webapi.entities.area;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author soumik
 *
 */
public class UrbanAreaDAOImpl implements UrbanAreaDAO {
	
	private SessionFactory sessionFactory;
	 
    public UrbanAreaDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	@Transactional
	public area getByName(String name, String city) {
		String hql = "FROM area as ua where ua.areaname =:subUrbName and ua.cityname =:cityName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("subUrbName", name);
		query.setParameter("cityName", city);
		return (area) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<area> getAllForCity(String city) {
		String hql ="select ua.areaname FROM area as ua where ua.cityname =:city";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("city", city);
		return (List<area>) query.list();
	}

}
