package org.pos2d.webapi;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.pos2d.webapi.dao.chargingstationgisDAO;
import org.pos2d.webapi.entities.chargingstationgis;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Path("/chargingStation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class chargingstationgisService {
	
	//@Autowired
	//private chargingstationgisDAO chargingstationgDAO;
	

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

	private chargingstationgisDAO getChargingStationDao(ServletContext servletContext)
	{
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		if(ctx == null)
		{			
			System.out.println("Can not find spring context");
			return null;
		}
		chargingstationgisDAO chargingDao = (chargingstationgisDAO) ctx.getBean("chargingstationgisDAO");
		return chargingDao;
		
	}

	@GET
	@Path("/GetAllAsGeoJson")
    public org.pos2d.webapi.geojson.FeatureCollection getChargingStation(@Context ServletContext servletContext, @QueryParam("city") String cityName, @QueryParam("area") String suburb) {
        ArrayList<chargingstationgis> CsList = getChargingStationDao(servletContext).getChargingStationlist(cityName, suburb);
        org.pos2d.webapi.geojson.FeatureCollection fc = new org.pos2d.webapi.geojson.FeatureCollection();
        for (chargingstationgis cs:CsList){
        	org.pos2d.webapi.geojson.Feature CSFeature = new org.pos2d.webapi.geojson.Feature();
        	CSFeature.addProperty("type", "Charging Station");
        	CSFeature.addProperty("name",cs.getCsname());
        	
        	//String status = xfr.getFielddata().getStatus();
        	//xfrFeature.addProperty("status", status);
        	CSFeature.addProperty("Price:",cs.getLastpricesignal());
        //	if (status.equalsIgnoreCase(TransformerStatus.STATUS_BAD)){
        //		xfrFeature.addProperty("statusData", xfr.getFielddata().getStatus());
        	//}
        	org.pos2d.webapi.geojson.MultiPoint csMpt = new org.pos2d.webapi.geojson.MultiPoint(cs.getGeom());
        	CSFeature.setGeometry(csMpt);
        	fc.addFeature(CSFeature);
        }
        return fc;
    }
	

}
