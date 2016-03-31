package org.pos2d.webapi.dao;

import java.util.ArrayList;

import org.pos2d.webapi.entities.industrialload;


public interface industrialloadDAO {
	void updateindustrialLoad(String companyname,double demand);
	public ArrayList<industrialload> getindustrialloads(String Companyname);
}
