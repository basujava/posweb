/**
 * 
 */
package org.pos2d.webapi.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.cities;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author soumik
 *
 */
public class CityDAOImpl implements CityDAO {

	private SessionFactory sessionFactory;
	 
    public CityDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	/* (non-Javadoc)
	 * @see org.pos2d.webapi.dao.CityDAO#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<cities> getAll() {
		String hql = "FROM cities";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (List<cities>) query.list();
	}

	@Override
	@Transactional
	public cities getByName(String name) {
		String hql = "FROM cities as city where city.cityname = :cityName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("cityName", name);
		return (cities) query.list().get(0);
	}

}
