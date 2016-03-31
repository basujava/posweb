package org.pos2d.webapi.dao;
import java.sql.Timestamp;

import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.t_fieldstatus;
import org.springframework.transaction.annotation.Transactional;
 
public class t_fieldstatusDAOImpl implements t_fieldstatusDAO {
	private SessionFactory sessionFactory;
	public t_fieldstatusDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
		
		@Override
	    @Transactional
      public void savet_fieldstatus(t_fieldstatus data) {
			
			java.util.Date date= new java.util.Date();
			data.setTs(new Timestamp(date.getTime()));
			sessionFactory.getCurrentSession().save(data);
		  	
    }
}

