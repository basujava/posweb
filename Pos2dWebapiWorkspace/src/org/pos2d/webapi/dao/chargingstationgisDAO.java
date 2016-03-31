package org.pos2d.webapi.dao;

import java.util.ArrayList;

import org.pos2d.webapi.entities.chargingstationgis;

public interface chargingstationgisDAO {
	public void updateprice(String csname,double price,int carqueue);
	public ArrayList<chargingstationgis> getChargingStationlist(String city ,String area);
}
