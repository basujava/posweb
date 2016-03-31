package org.pos2d.webapi.entities;

import java.sql.Timestamp;

public class t_oilmoisturecontent {
	
	private String assetname;
	private double oilmoistureppm;
	private double oiltemperaturec;
	private Timestamp ts;

	private int gid;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
	public double getOilmoistureppm() {
		return oilmoistureppm;
	}
	public void setOilmoistureppm(double oilmoistureppm) {
		this.oilmoistureppm = oilmoistureppm;
	}
	public double getOiltemperaturec() {
		return oiltemperaturec;
	}
	public void setOiltemperaturec(double oiltemperaturec) {
		this.oiltemperaturec = oiltemperaturec;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	
	
	
}
