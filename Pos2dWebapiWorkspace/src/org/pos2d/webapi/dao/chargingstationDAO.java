package org.pos2d.webapi.dao;

import java.util.ArrayList;
import org.pos2d.webapi.entities.chargingstation;
public interface chargingstationDAO {
	
	public ArrayList<chargingstation> getChargingStations();
	public void updateprice(String csname,double price,int carqueue);
}
