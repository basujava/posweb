package org.pos2d.webapi.entities;


import java.sql.Timestamp;


public class t_fieldstatus {
	private String assetname;
	private String alertstatus;
	private Timestamp ts;
	private int gid;
	private String fielddata;
	
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
	public String getAlertstatus() {
		return alertstatus;
	}
	public void setAlertstatus(String alertstatus) {
		this.alertstatus = alertstatus;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getFielddata() {
		return fielddata;
	}
	public void setFielddata(String fielddata) {
		this.fielddata = fielddata;
	}	
	

}
