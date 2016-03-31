/**
 * 
 */
package org.pos2d.webapi.dao;

import java.util.List;

import org.pos2d.webapi.entities.area;

/**
 * @author soumik
 *
 */
public interface UrbanAreaDAO {
	
	public area getByName(String name, String city);
	public List<area> getAllForCity(String city);

}
