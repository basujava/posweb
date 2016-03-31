package org.pos2d.webapi;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.pos2d.webapi.dao.industrialloadgisDAO;
import org.pos2d.webapi.dao.loaddemandprofileDAO;
import org.pos2d.webapi.entities.industrialloadgis;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Path("/loaddemand")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class loaddemandprofileService {
	
	//@Autowired
	//private loaddemandprofileDAO loadDAO;
	
	private loaddemandprofileDAO getLoadProfileDao(ServletContext servletContext)
	{
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		if(ctx == null)
		{			
			System.out.println("Can not find spring context");
			return null;
		}
		loaddemandprofileDAO loadProfileDao = (loaddemandprofileDAO) ctx.getBean("loaddemandprofileDAO");
		return loadProfileDao;
				
	}
	//@Autowired
	//private industrialloadgisDAO indDAO;
	
	private industrialloadgisDAO getIndustrialDao(ServletContext servletContext)
	{
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		if(ctx == null)
		{			
			System.out.println("Can not find spring context");
			return null;
		}
		industrialloadgisDAO industryDao = (industrialloadgisDAO) ctx.getBean("industrialloadgisDAO");
		return industryDao;
		
	}
	
	//@Autowired
	//private RabbitTemplate rabbitTemplate;
	
	private RabbitTemplate getRabbitTemplate(ServletContext servletContext)
	{
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		if(ctx == null)
		{			
			System.out.println("Can not find spring context");
			return null;
		}
		RabbitTemplate rabbitTemplate = (RabbitTemplate) ctx.getBean("rabbitTemplate");
		return rabbitTemplate;
		
	}
	@POST
	@Path("/update")
	public void updateLoad(@Context ServletContext servletContext, String data){
		/*
		 * Message schema is 
		 * {
			    "companyname":"Unitech Infospace IT/ITES SEZ",
			    "currentdemandkw":"3050"
			}
		 *
		 */
		getRabbitTemplate(servletContext).convertAndSend("load.onchange", data);
	}
	
	@GET
	@Path("/GetAllAsGeoJson")
    public org.pos2d.webapi.geojson.FeatureCollection getTransformers(@Context ServletContext servletContext,@QueryParam("city") String cityName, @QueryParam("area") String suburb) {
        ArrayList<industrialloadgis> loads = getIndustrialDao(servletContext).getindustrialloadgislist(cityName, suburb);
        org.pos2d.webapi.geojson.FeatureCollection fc = new org.pos2d.webapi.geojson.FeatureCollection();
        for (industrialloadgis load:loads){
        	org.pos2d.webapi.geojson.Feature loadFeature = new org.pos2d.webapi.geojson.Feature();
        	loadFeature.addProperty("type", "Industrial Load");
        	loadFeature.addProperty("name", load.getCompanyname());
        	
        	//String status = xfr.getFielddata().getStatus();
        	//xfrFeature.addProperty("status", status);
        	loadFeature.addProperty("CurrentLOad",load.getCurrentdemandkw());
        //	if (status.equalsIgnoreCase(TransformerStatus.STATUS_BAD)){
        //		xfrFeature.addProperty("statusData", xfr.getFielddata().getStatus());
        	//}
        	org.pos2d.webapi.geojson.MultiPoint loadMpt = new org.pos2d.webapi.geojson.MultiPoint(load.getGeom());
        	loadFeature.setGeometry(loadMpt);
        	fc.addFeature(loadFeature);
        }
        return fc;
    }
	
	
	

}
