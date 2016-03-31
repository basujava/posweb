/**
 * 
 */
package org.pos2d.webapi.dao;

import java.util.List;

import org.pos2d.webapi.entities.cities;

/**
 * @author soumik
 *
 */
public interface CityDAO {
	public List<cities> getAll();
	public cities getByName(String name);
}
