package org.pos2d.webapi.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.chargingstationgis;
import org.springframework.transaction.annotation.Transactional;

public class chargingstationgisDAOImpl implements chargingstationgisDAO {
	
	
	SessionFactory sessionFactory;
	
	 public chargingstationgisDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	
	
	
	@Override
	public void updateprice(String csname,double price,int carqueue) {
				 
		chargingstationgis cs = null;
		String hql = "FROM chargingstationgis as cs where cs.csname = :name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", csname);
		 cs = (chargingstationgis) query.uniqueResult();
		
		if(cs==null){
			
			System.out.println("chargingstation Not Found!!!");
		}else{
			
			cs.setLastpricesignal(price);
			cs.setCurrentcarqueue(carqueue);
			sessionFactory.getCurrentSession().update(cs);
			//sessionFactory.getCurrentSession().save(xfr);
		}		
		
	}
	
	 @SuppressWarnings("unchecked")
	 @Override
	 @Transactional
	public ArrayList<chargingstationgis> getChargingStationlist(String city ,String area){
		
		String hql = "FROM chargingstationgis as css where css.cityname = :cityName and css.areaname = :suburbName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("cityName", city);
		query.setParameter("suburbName", area);
		return (ArrayList<chargingstationgis> ) query.list();
		
		
	}
	
	

}
