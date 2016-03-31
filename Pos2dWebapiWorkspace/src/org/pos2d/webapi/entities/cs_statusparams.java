package org.pos2d.webapi.entities;

import java.sql.Timestamp;

public class cs_statusparams {
	
	private int gid;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public double getEnergypricesignal() {
		return energypricesignal;
	}
	public void setEnergypricesignal(double energypricesignal) {
		this.energypricesignal = energypricesignal;
	}
	public int getCurrentcarqueue() {
		return currentcarqueue;
	}
	public void setCurrentcarqueue(int currentcarqueue) {
		this.currentcarqueue = currentcarqueue;
	}
	private Timestamp ts;
	private String csname;
	private double energypricesignal;
	private int currentcarqueue;
	  

}
