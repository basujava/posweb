package org.pos2d.webapi.dao;

import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.cs_statusparams;
import org.springframework.transaction.annotation.Transactional;

public class cs_statusparamsDAOImpl implements cs_statusparamsDAO {
	
	private SessionFactory sessionFactory;
	 
    public cs_statusparamsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    @Override
    @Transactional
  public void updateCSParams(cs_statusparams csparamsdata) {
				
		sessionFactory.getCurrentSession().save(csparamsdata);
	  	
}
}
