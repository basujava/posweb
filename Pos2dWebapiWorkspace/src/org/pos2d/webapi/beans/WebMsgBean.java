package org.pos2d.webapi.beans;

public class WebMsgBean {
	
	private String regno;
	private double longitude;
    private double latitude;
	private double stateofchargekm;
	
    public String getVehicleName() {
		return regno;
	}
	public void setregno(String vehicleName) {
		this.regno = vehicleName;
	}
	public double getregno() {
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
	public double getStateofchargekm() {
		return stateofchargekm;
	}
	public void setStateofchargekm(double stateofchargekm) {
		this.stateofchargekm = stateofchargekm;
	}
	

}
