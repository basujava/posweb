package org.pos2d.webapi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.pos2d.webapi.entities.fieldtrucklocationgis;
import org.springframework.transaction.annotation.Transactional;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;


public class fieldtrucklocationgisDAOImpl implements fieldtrucklocationgisDAO  {
	
	private SessionFactory sessionFactory;
	public fieldtrucklocationgisDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	
	@Transactional
    public void savefieldtruck(fieldtrucklocationgis ftruck){
		
		
		
		Coordinate pntCoord = new Coordinate();
		pntCoord.x = ftruck.getLongitude();
		pntCoord.y = ftruck.getLatitude();
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);
		Point pnt = factory.createPoint(pntCoord);
		ftruck.setGeolocation(pnt);
		
		
		
		sessionFactory.getCurrentSession().save(ftruck);

	}
	 
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<fieldtrucklocationgis> getAllfieldtruck() {
		String hql = "FROM fieldtrucklocationgis";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (List<fieldtrucklocationgis>) query.list();
	}
	
	
	

}
