package org.pos2d.webapi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.maplayout;
import org.springframework.transaction.annotation.Transactional;

public class maplayoutDAOImpl implements maplayoutDAO {
	
	SessionFactory sessionFactory;
	
	 public maplayoutDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 
	 
	 @SuppressWarnings("null")
	@Override
	 @Transactional
	public maplayout getlocation(double x,double y) {
		
	
		String hql = "FROM maplayout as mlayout where mlayout.xcordinate = :xcord and mlayout.xcordinate = :xcord and mlayout.ycordinate = :ycord ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("xcord", x);
		query.setParameter("ycord", y);
		maplayout mlayout = (maplayout) query.uniqueResult();
				
		return mlayout;

	}
	

}
