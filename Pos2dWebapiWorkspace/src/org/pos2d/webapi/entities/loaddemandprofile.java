package org.pos2d.webapi.entities;

import java.sql.Timestamp;

public class loaddemandprofile {
	
	private int gid;
	private Timestamp ts;
	private String  companyname;
	private double  currentdemandkw;
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
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public double getCurrentdemandkw() {
		return currentdemandkw;
	}
	public void setCurrentdemandkw(double currentdemandkw) {
		this.currentdemandkw = currentdemandkw;
	}
	
	

}
