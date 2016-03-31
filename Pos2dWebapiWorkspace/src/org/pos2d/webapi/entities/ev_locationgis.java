package org.pos2d.webapi.entities;


import com.vividsolutions.jts.geom.Point;

public class ev_locationgis {
	private int gid;
	private String regno;
	private double stateofchargekm ;
	private double xcordinate;
	private double ycordinate;
	private double longitude;
	private double latitude;
	private java.sql.Timestamp lastlocationts;
	private Point geolocation;
	
	
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public double getStateofchargekm() {
		return stateofchargekm;
	}
	public void setStateofchargekm(double stateofchargekm) {
		this.stateofchargekm = stateofchargekm;
	}
	public double getXcordinate() {
		return xcordinate;
	}
	public void setXcordinate(double xcordinate) {
		this.xcordinate = xcordinate;
	}
	public double getYcordinate() {
		return ycordinate;
	}
	public void setYcordinate(double ycordinate) {
		this.ycordinate = ycordinate;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public java.sql.Timestamp getLastlocationts() {
		return lastlocationts;
	}
	public void setLastlocationts(java.sql.Timestamp lastlocationts) {
		this.lastlocationts = lastlocationts;
	}
	public Point getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(Point geolocation) {
		this.geolocation = geolocation;
	}
	
	
	
	
	

}


