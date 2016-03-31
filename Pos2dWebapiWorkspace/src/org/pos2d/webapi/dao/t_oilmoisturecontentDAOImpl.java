package org.pos2d.webapi.dao;

import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.t_oilmoisturecontent;

public class t_oilmoisturecontentDAOImpl implements t_oilmoisturecontentDAO {
	
	private SessionFactory sessionFactory;
	public t_oilmoisturecontentDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
		
		
      public void saveoilmoisturecontent(t_oilmoisturecontent data) {
			
			sessionFactory.getCurrentSession().save(data);
		  	
    } 
	 
}
