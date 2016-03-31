package org.pos2d.webapi.dao;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.pos2d.webapi.entities.chargingstation;
import org.springframework.transaction.annotation.Transactional;

public class chargingstationDAOImpl implements chargingstationDAO {
	
	SessionFactory sessionFactory;
	
	 public chargingstationDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 @SuppressWarnings("unchecked")
		@Override
		@Transactional
		public ArrayList<chargingstation> getChargingStations() {
			String hql = "FROM chargingstation";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return (ArrayList<chargingstation>) query.list();
		}
		
		@Override
		public void updateprice(String csname,double price,int carqueue) {
					 
			chargingstation cs=null;
			String hql = "FROM chargingstation as cs where cs.csname = :name";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("name", csname);
			cs = (chargingstation) query.uniqueResult();
			
			if(cs==null){
				
				System.out.println("chargingstation Not Found!!!");
			}else{
				
				cs.setLastpricesignal(price);
				cs.setCurrentcarqueue(carqueue);
				sessionFactory.getCurrentSession().update(cs);
				//sessionFactory.getCurrentSession().save(xfr);
			}
			
			
		}
		
  
}
