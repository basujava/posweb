/**
 * 
 */
package org.pos2d.webapi.entities;

import com.vividsolutions.jts.geom.MultiPoint;


/**
 * @author soumik
 *
 */
public class Transformer {
	private long gid;
	public long getGid() {
		return gid;
	}
	public void setGid(long gid) {
		this.gid = gid;
	}
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
	public MultiPoint getGeom() {
		return geom;
	}
	public void setGeom(MultiPoint geom) {
		this.geom = geom;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getAlertstatus() {
		return alertstatus;
	}
	public void setAlertstatus(String alertstatus) {
		this.alertstatus = alertstatus;
	}
	public String getFielddata() {
		return fielddata;
	}
	public void setFielddata(String fielddata) {
		this.fielddata = fielddata;
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
	public double getXcordinate() {
		return xcordinate;
	}
	public void setXcordinate(double xcordinate) {
		this.xcordinate = xcordinate;
	}
	private String assetname;
	private MultiPoint geom;
	private String cityname;
	private String areaname;
	private String alertstatus;
	private String fielddata;
	private double ycordinate;
	private double longitude;
	private double latitude;
	private double xcordinate;

	
	
	
	
	
}
