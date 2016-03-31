package org.pos2d.webapi.dao;

import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.ev_locationgis;
import org.springframework.transaction.annotation.Transactional;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

public class EVlocationgisDAOImpl implements EVlocationgisDAO{

	private SessionFactory sessionFactory;
	public EVlocationgisDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
    @Transactional
  public void updateEVlocationgis(ev_locationgis data) {
		
		Coordinate pntCoord = new Coordinate();
		pntCoord.x = data.getLongitude();
		pntCoord.y = data.getLatitude();
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);
		Point pnt = factory.createPoint(pntCoord);
		data.setGeolocation(pnt);
		sessionFactory.getCurrentSession().save(data);
	  	
}

}


