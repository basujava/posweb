package org.pos2d.webapi.entities;

import java.sql.Timestamp;

import com.vividsolutions.jts.geom.Point;

public class fieldtrucklocationgis {
	
	
	private int gid;
	  private String regno;
	  private String fieldmobileno;
	  private Timestamp lastlocationts ;
	  private int  totalalertsnoticed ;
	  private double xcordinate ;
	  private double ycordinate ;
	  private double longitude;
	  private double latitude;
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
	public String getFieldmobileno() {
		return fieldmobileno;
	}
	public void setFieldmobileno(String fieldmobileno) {
		this.fieldmobileno = fieldmobileno;
	}
	
	public Timestamp getLastlocationts() {
		return lastlocationts;
	}
	public void setLastlocationts(Timestamp lastlocationts) {
		this.lastlocationts = lastlocationts;
	}
	public int getTotalalertsnoticed() {
		return totalalertsnoticed;
	}
	public void setTotalalertsnoticed(int totalalertsnoticed) {
		this.totalalertsnoticed = totalalertsnoticed;
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
	public Point getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(Point geolocation) {
		this.geolocation = geolocation;
	}
	  

}
