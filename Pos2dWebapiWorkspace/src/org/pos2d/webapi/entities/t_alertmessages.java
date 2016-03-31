package org.pos2d.webapi.entities;

import java.sql.Timestamp;

public class t_alertmessages {

	private int gid;
	private Timestamp ts;
	private  String fieldmobileid;
	private  String assetname;
	private String  alertkeyvalue;
	private String alertmessagedesc;
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
	public String getFieldmobileid() {
		return fieldmobileid;
	}
	public void setFieldmobileid(String fieldmobileid) {
		this.fieldmobileid = fieldmobileid;
	}
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
	public String getAlertkeyvalue() {
		return alertkeyvalue;
	}
	public void setAlertkeyvalue(String alertkeyvalue) {
		this.alertkeyvalue = alertkeyvalue;
	}
	public String getAlertmessagedesc() {
		return alertmessagedesc;
	}
	public void setAlertmessagedesc(String alertmessagedesc) {
		this.alertmessagedesc = alertmessagedesc;
	}
	
	  
}
