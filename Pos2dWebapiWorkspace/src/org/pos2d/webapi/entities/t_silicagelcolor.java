package org.pos2d.webapi.entities;

import java.sql.Timestamp;

public class t_silicagelcolor {
		
	private int gid;
	private String  assetname;
	private boolean silicageldiscolored;
	private Timestamp ts;
	
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
	public boolean isSilicageldiscolored() {
		return silicageldiscolored;
	}
	public void setSilicageldiscolored(boolean silicageldiscolored) {
		this.silicageldiscolored = silicageldiscolored;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	

}
