package org.pos2d.webapi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.Transformer;
import org.pos2d.webapi.entities.chargingstation;
import org.pos2d.webapi.entities.industrialload;
import org.springframework.transaction.annotation.Transactional;

public class industrialloadDAOImpl implements industrialloadDAO {
	
	
	private SessionFactory sessionFactory;
	 
    public industrialloadDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	@Override
	 @Transactional
	public void updateindustrialLoad(String companyname,double demand) {
		 industrialload il=null;
		String hql = "FROM industrialload as il where il.companyname = :name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", companyname);
		il = (industrialload) query.uniqueResult();
			if(il==null){
						System.out.println("Industry Not Found!!!");
		}else{
						il.setCurrentdemandkw(demand);
					
			sessionFactory.getCurrentSession().update(il);
			//sessionFactory.getCurrentSession().save(xfr);
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ArrayList<industrialload> getindustrialloads(String companyname) {
		String hql = "FROM industrialload as ind where ind.companyname = :cName";
				
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("cName", companyname);
			return (ArrayList<industrialload> ) query.list();
		
	}
	
	
	}
