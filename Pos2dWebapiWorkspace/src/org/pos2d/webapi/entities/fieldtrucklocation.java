/**
 * 
 */
package org.pos2d.webapi.entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @author soumik
 *
 */
public class fieldtrucklocation {

	private int gid;
	private String regno;
	private String fieldmobileid;
	private Timestamp ts;
	private int totalalertsnoticed;
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
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getFieldmobileid() {
		return fieldmobileid;
	}
	public void setFieldmobileid(String fieldmobileid) {
		this.fieldmobileid = fieldmobileid;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
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
	
      
    
	
}
