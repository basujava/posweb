package org.pos2d.webapi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.discomtransformer;

public class discomtransformerDAOImpl implements discomtransformerDAO {
	
	
	private SessionFactory sessionFactory;
	 
    public discomtransformerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void updatediscomtransformer(String assetname,String AlertStatus,String Fielddata){
		
			
			  System.out.println("Updating UtilityDiscom !!!");
			  discomtransformer dxfr=null;
				String hql = "FROM discomtransformer as dxfr where dxfr.assetname = :name";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				query.setParameter("name", assetname);
				dxfr = (discomtransformer) query.uniqueResult();
				
				if(dxfr==null){
					
					System.out.println("Transformer Not Found!!!");
				}else{
					
					dxfr.setAlertstatus(AlertStatus);
					dxfr.setFielddata(Fielddata);
					
					
					sessionFactory.getCurrentSession().update(dxfr);
					//sessionFactory.getCurrentSession().save(xfr);
				}
				
				
			}
		
	}


