package org.pos2d.webapi.dao;

import java.util.List;

import org.pos2d.webapi.entities.fieldtrucklocationgis;

public interface fieldtrucklocationgisDAO {
	
	public void savefieldtruck(fieldtrucklocationgis ftruck);
	 public List<fieldtrucklocationgis> getAllfieldtruck();
}
