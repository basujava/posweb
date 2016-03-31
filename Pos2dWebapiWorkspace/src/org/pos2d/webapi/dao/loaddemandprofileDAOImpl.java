package org.pos2d.webapi.dao;

import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.loaddemandprofile;
import org.springframework.transaction.annotation.Transactional;

public class loaddemandprofileDAOImpl implements loaddemandprofileDAO {
	
	private SessionFactory sessionFactory;
	
	public loaddemandprofileDAOImpl(SessionFactory sessionFactory){
		
		this.sessionFactory=sessionFactory;
	}

	@Override
    @Transactional
  public void saveloaddemandprofile(loaddemandprofile data) {
				
		sessionFactory.getCurrentSession().save(data);
	  	
}
	
}
