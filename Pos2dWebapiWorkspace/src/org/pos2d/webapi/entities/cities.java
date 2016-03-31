/**
 * 
 */
package org.pos2d.webapi.entities;



//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.vividsolutions.jts.geom.Point;

/**
 * @author soumik
 *
 */
//@JsonIgnoreProperties(value={"geom"})
public class cities {
	
	private long gid;
	private String cityname;
	private Point geom;
	/**
	 * @return the gid
	 */
	public long getGid() {
		return gid;
	}
	/**
	 * @param gid the gid to set
	 */
	public void setGid(long gid) {
		this.gid = gid;
	}
	/**
	 * @return the name
	 */
	public String getcityname() {
		return cityname;
	}
	/**
	 * @param name the name to set
	 */
	public void setcityname(String name) {
		this.cityname = name;
	}
	/**
	 * @return the geom
	 */
	public Point getGeom() {
		return geom;
	}
	/**
	 * @param geom the geom to set
	 */
	public void setGeom(Point geom) {
		this.geom = geom;
	}
	
	public double getLongitude(){
		return this.geom.getX();
	}
	
	public double getLatitude(){
		return this.geom.getY();
	}

}
