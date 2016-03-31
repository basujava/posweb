/**
 * 
 */
package org.pos2d.webapi.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.pos2d.webapi.entities.Transformer;
//import org.pos2d.webapi.entities.TransformerStatus;

import org.springframework.transaction.annotation.Transactional;



/**
 * @author soumik
 *
 */
public class TransformerDAOImpl implements TransformerDAO {

	private SessionFactory sessionFactory;
	 
    public TransformerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	/* (non-Javadoc)
	 * @see org.pos2d.webapi.dao.TransformerDAO#getAllSuburb(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Transformer> getBySuburbAndStatus(String city, String suburb, String status) {
		String hql = "FROM Transformer as xfr where xfr.cityname = :cityName and xfr.areaname = :suburbName and xfr.alertstatus = :statusCode";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("cityName", city);
		query.setParameter("suburbName", suburb);
		query.setParameter("statusCode", status);
		return (List<Transformer> ) query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Transformer> getBySuburb(String city, String suburb) {
		String hql = "FROM Transformer as xfr where xfr.cityname = :cityName and xfr.areaname = :suburbName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("cityName", city);
		query.setParameter("suburbName", suburb);
		return (List<Transformer> ) query.list();
	}
	
	@Override
	public void update_utilitygis_transformer(String assetname,String alertstatus,String fielddata) {
		
	  System.out.println("Updating Utilitygis !!!");
		Transformer xfr=null;
		String hql = "FROM Transformer as xfr where xfr.assetname = :name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", assetname);
		xfr = (Transformer) query.uniqueResult();
		
		if(xfr==null){
			
			System.out.println("Transformer Not Found!!!");
		}else{
			
			xfr.setAlertstatus(alertstatus);
			xfr.setFielddata(fielddata);
			
			
			sessionFactory.getCurrentSession().update(xfr);
			//sessionFactory.getCurrentSession().save(xfr);
		}
		
		
	}
	

}
