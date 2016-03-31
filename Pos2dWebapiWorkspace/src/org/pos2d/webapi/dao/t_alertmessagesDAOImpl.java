package org.pos2d.webapi.dao;

import java.sql.Timestamp;

import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.t_alertmessages;
import org.springframework.transaction.annotation.Transactional;

public class t_alertmessagesDAOImpl implements t_alertmessagesDAO {

	private SessionFactory sessionFactory;
	
	 public t_alertmessagesDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	
	
	 @Transactional
	    public void Savealertmessages(String assetname,String fielddata){
	    	java.util.Date date= new java.util.Date();
			
	    	t_alertmessages msg =new t_alertmessages();
	    	msg.setTs(new Timestamp(date.getTime()));
	    	msg.setAlertkeyvalue(fielddata);
	    	msg.setAssetname(assetname);
	    	msg.setFieldmobileid("8952457896");
	    	String[] parts = assetname.split("-");
	    	String part1 = parts[0]; // 004
	    	String part2 = parts[1];
	    	    	
	    	String MsgDesc="Please inform the depot "+part1+"-"+part2+" for an emergency "
	    			+ "inspection of the asset :"+assetname+"for alert "+fielddata+"";
	    	
	    	msg.setAlertmessagedesc(MsgDesc);
	    	
			sessionFactory.getCurrentSession().save(msg);

		}
}
