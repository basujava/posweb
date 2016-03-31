package org.pos2d.webapi.entities;

public class industrialload {
	
	
	private int gid;
	private String companyname;
	private String areaname;
	private String cityname;
	private String premiseaddress;
	private  double currentdemandkw;
	private double xcordinate;
	private double ycordinate;
	private double longitude;
	private double latitude;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getPremiseaddress() {
		return premiseaddress;
	}
	public void setPremiseaddress(String premiseaddress) {
		this.premiseaddress = premiseaddress;
	}
	public double getCurrentdemandkw() {
		return currentdemandkw;
	}
	public void setCurrentdemandkw(double currentdemandkw) {
		this.currentdemandkw = currentdemandkw;
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
	
	
	
}
