/**
 * 
 */
package org.pos2d.webapi.dao;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.fieldtrucklocation;
import org.springframework.transaction.annotation.Transactional;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

/**
 * @author soumik
 *
 */
public class VehicleDAOImpl implements VehicleDAO {

	private SessionFactory sessionFactory;
	
	public VehicleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	/* (non-Javadoc)
	 * @see org.pos2d.webapi.dao.VehicleDAO#createActiveVehicle(java.lang.String)
	 */
	@Override
	@Transactional
	public void createActiveVehicle(fieldtrucklocation vehicleName) {
		fieldtrucklocation veh = null;
		
			veh = new fieldtrucklocation();
			veh.setFieldmobileid(vehicleName.getFieldmobileid());
			veh.setLatitude(vehicleName.getLatitude());
			veh.setLongitude(vehicleName.getLongitude());
			veh.setRegno(vehicleName.getRegno());
			veh.setTs(vehicleName.getTs());
			veh.setTotalalertsnoticed(vehicleName.getTotalalertsnoticed());
			veh.setXcordinate(vehicleName.getXcordinate());
			veh.setYcordinate(vehicleName.getYcordinate());
       
		
		//sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(veh);
		//sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
	/*// No transaction indicator as client of this method is required to handle transaction
	@Override
	public void createVehicleLocation(VehicleLocationBean location) {
		Vehicle veh = null;
		String hql = "FROM vehicleregistration as veh where veh.regno = :name and veh.active='Y'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", location.getVehicleName());
		veh = (Vehicle) query.uniqueResult();
		if (veh == null){
			System.out.println("Vehicle not registered to submit location updates. Ignoring update");
			return;
		}
		VehicleLocation vLoc = new VehicleLocation();
		Coordinate pntCoord = new Coordinate();
		pntCoord.x = location.getLongitude();
		pntCoord.y = location.getLatitude();
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);
		Point pnt = factory.createPoint(pntCoord);
		vLoc.setLocation(pnt);
		vLoc.setUpdatedOn(Calendar.getInstance());
		vLoc.setVehicle(veh);
		sessionFactory.getCurrentSession().save(vLoc);
	}*/
}
