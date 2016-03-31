package org.pos2d.webapi.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.pos2d.webapi.entities.ev_location;

public class ev_locationDAOImpl implements ev_locationDAO {
	private SessionFactory sessionFactory;
	public ev_locationDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	
	@Override
    @Transactional
    public void updateEVlocationcis(ev_location EVlocationg){
		sessionFactory.getCurrentSession().save(EVlocationg);

	}
}
