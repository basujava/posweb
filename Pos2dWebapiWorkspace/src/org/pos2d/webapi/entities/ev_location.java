package org.pos2d.webapi.entities;

import java.sql.Timestamp;

public class ev_location {
	
	private int gid;
	private String regno;
	private double  stateofchargekm;
	private double xcordinate;
	private double ycordinate;
	private double longitude;
	private double latitude;
	private Timestamp lastlocationts;
	
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
	public Timestamp getLastlocationts() {
		return lastlocationts;
	}
	public void setLastlocationts(Timestamp lastlocationts) {
		this.lastlocationts = lastlocationts;
	}
	

}


