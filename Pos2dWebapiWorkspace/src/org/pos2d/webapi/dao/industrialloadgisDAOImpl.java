package org.pos2d.webapi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.Transformer;
import org.pos2d.webapi.entities.industrialloadgis;
import org.springframework.transaction.annotation.Transactional;

public class industrialloadgisDAOImpl implements industrialloadgisDAO {
	
	private SessionFactory sessionFactory;
	 
    public industrialloadgisDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	@Override
	 @Transactional
	public void updateindustrialLoad(String companyname,double demand) {
		
	
		industrialloadgis ilgisil=null;
		String hql = "FROM industrialloadgis as ilgis where ilgis.companyname = :name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", companyname);
		ilgisil = (industrialloadgis) query.uniqueResult();
		
		if(ilgisil==null){
			
			System.out.println("Industry Not Found!!!");
		}else{
			
			ilgisil.setCurrentdemandkw(demand);
			
			
			sessionFactory.getCurrentSession().update(ilgisil);
			//sessionFactory.getCurrentSession().save(xfr);
		}
		
		
	}
	
	 @SuppressWarnings("unchecked")
	 @Override
	 @Transactional
	public ArrayList<industrialloadgis> getindustrialloadgislist(String city ,String area){
		
		String hql = "FROM industrialloadgis as load where load.cityname = :cityName and load.areaname = :suburbName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("cityName", city);
		query.setParameter("suburbName", area);
		return (ArrayList<industrialloadgis> ) query.list();
	}
	

}
