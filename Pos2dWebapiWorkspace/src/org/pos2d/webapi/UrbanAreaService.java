/**
 * 
 */
package org.pos2d.webapi;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.pos2d.webapi.dao.CityDAO;
import org.pos2d.webapi.dao.UrbanAreaDAO;
import org.pos2d.webapi.entities.area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author soumik
 *
 */
@Path("/suburb")
@Produces(MediaType.APPLICATION_JSON)
public class UrbanAreaService {
	//@Autowired
    //private UrbanAreaDAO urbanAreaDAO;
	
	private UrbanAreaDAO getUrbanDAO(ServletContext servletContext)
	{
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		if(ctx == null)
		{			
			System.out.println("Can not find spring context");
			return null;
		}
		UrbanAreaDAO urbanAreaDAO = (UrbanAreaDAO) ctx.getBean("urbanAreaDAO");
		return urbanAreaDAO;
	}
	
	@GET
    @Path("/{cityName}")
    public List<area> getSubUrbsOfCity(@Context ServletContext servletContext, @PathParam("cityName") String cityName) {
    	UrbanAreaDAO urbanAreaDAO = getUrbanDAO(servletContext);
        List<area> subUrb =urbanAreaDAO.getAllForCity(cityName);
        //CityBean
		return subUrb;
    }
	
	@GET
	@Path("/GetGeoJson")
    public org.pos2d.webapi.geojson.FeatureCollection getGeoJson(@Context ServletContext servletContext,@QueryParam("city") String cityName, @QueryParam("area") String areaName) {
    	UrbanAreaDAO urbanAreaDAO = getUrbanDAO(servletContext);
        area subUrb = urbanAreaDAO.getByName(areaName, cityName);
        org.pos2d.webapi.geojson.FeatureCollection retVal = new org.pos2d.webapi.geojson.FeatureCollection();
		org.pos2d.webapi.geojson.Feature urbanAreaFeature = new org.pos2d.webapi.geojson.Feature();
		org.pos2d.webapi.geojson.Polygon subUrbPolygon = new org.pos2d.webapi.geojson.Polygon(subUrb.getGeom());
		urbanAreaFeature.setGeometry(subUrbPolygon);
		urbanAreaFeature.addProperty("type", "urban-area");
		retVal.addFeature(urbanAreaFeature);
        return retVal;
    }
}
