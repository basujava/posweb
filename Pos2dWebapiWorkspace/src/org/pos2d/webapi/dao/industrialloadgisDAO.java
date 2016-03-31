package org.pos2d.webapi.dao;

import java.util.ArrayList;

import org.pos2d.webapi.entities.industrialloadgis;


public interface industrialloadgisDAO {
	void updateindustrialLoad(String companyname,double demand);
	public ArrayList<industrialloadgis> getindustrialloadgislist(String city ,String area);
}
