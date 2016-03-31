/**
 * 
 */
package org.pos2d.webapi.dao;

import org.pos2d.webapi.entities.fieldtrucklocation;

/**
 * @author soumik
 *
 */
public interface VehicleDAO {
	void createActiveVehicle(fieldtrucklocation veh);
	//void createVehicleLocation(VehicleLocationBean location);
}
