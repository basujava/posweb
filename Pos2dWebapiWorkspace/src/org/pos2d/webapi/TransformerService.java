/**
 * 
 */
package org.pos2d.webapi;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.pos2d.webapi.beans.TransformerStatusBean;
import org.pos2d.webapi.dao.CityDAO;
import org.pos2d.webapi.dao.TransformerDAO;
import org.pos2d.webapi.entities.Transformer;
//import org.pos2d.webapi.entities.TransformerStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author soumik
 *
 */
@Path("/xfr")
@Produces(MediaType.APPLICATION_JSON)
public class TransformerService {
	
	//@Autowired
	//private RabbitTemplate rabbitTemplate;
	
	//@Autowired
	//private ApplicationContext appContext;
	
	//@Autowired
    //private TransformerDAO xfrDAO;
	
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
	private TransformerDAO getTransformerDAO(ServletContext servletContext)
	{
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		if(ctx == null)
		{			
			System.out.println("Can not find spring context");
			return null;
		}
		TransformerDAO xfrDAO = (TransformerDAO) ctx.getBean("xfrDAO");
		return xfrDAO;
	}
	
	@GET
	@Path("/GetByStatusAsGeoJson")
    public org.pos2d.webapi.geojson.FeatureCollection getTransformers(@Context ServletContext servletContext,@QueryParam("city") String cityName, @QueryParam("area") String suburb, @QueryParam("status") String status) {
		TransformerDAO xfrDAO = getTransformerDAO(servletContext);
		List<Transformer> xfrs = xfrDAO.getBySuburbAndStatus(cityName, suburb, status);
        org.pos2d.webapi.geojson.FeatureCollection fc = new org.pos2d.webapi.geojson.FeatureCollection();
        for (Transformer xfr:xfrs){
        	org.pos2d.webapi.geojson.Feature xfrFeature = new org.pos2d.webapi.geojson.Feature();
        	xfrFeature.addProperty("name", xfr.getAssetname());
        	org.pos2d.webapi.geojson.MultiPoint xfrMpt = new org.pos2d.webapi.geojson.MultiPoint(xfr.getGeom());
        	xfrFeature.setGeometry(xfrMpt);
        	fc.addFeature(xfrFeature);
        }
        return fc;
    }
	
	@GET
	@Path("/GetAllAsGeoJson")
    public org.pos2d.webapi.geojson.FeatureCollection getTransformers(@Context ServletContext servletContext,@QueryParam("city") String cityName, @QueryParam("area") String suburb) {
		TransformerDAO xfrDAO = getTransformerDAO(servletContext);
        List<Transformer> xfrs = xfrDAO.getBySuburb(cityName, suburb);
        org.pos2d.webapi.geojson.FeatureCollection fc = new org.pos2d.webapi.geojson.FeatureCollection();
        for (Transformer xfr:xfrs){
        	org.pos2d.webapi.geojson.Feature xfrFeature = new org.pos2d.webapi.geojson.Feature();
        	xfrFeature.addProperty("type", "transformer");
        	xfrFeature.addProperty("name", xfr.getAssetname());
        	
        	//String status = xfr.getFielddata().getStatus();
        	//xfrFeature.addProperty("status", status);
        	xfrFeature.addProperty("status",xfr.getAlertstatus());
        //	if (status.equalsIgnoreCase(TransformerStatus.STATUS_BAD)){
        //		xfrFeature.addProperty("statusData", xfr.getFielddata().getStatus());
        	//}
        	org.pos2d.webapi.geojson.MultiPoint xfrMpt = new org.pos2d.webapi.geojson.MultiPoint(xfr.getGeom());
        	xfrFeature.setGeometry(xfrMpt);
        	fc.addFeature(xfrFeature);
        }
        return fc;
    }
	
	@POST
	@Path("/status")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateTransformerStatus(@Context ServletContext servletContext, String data){
		/*
		 * Message schema is 
		 * {
			    "name":"DTR/SM/01",
			    "status":"BAD"|"OK",
			    "statusData":{
			        "oil-level-pct":"100",
			        "oxidizer-health-pct":"15"
		    	}
		    }
		 *
		 */
		//appContext.getBean("transformerStatus",RabbitTemplate.class).convertAndSend(data);
		getRabbitTemplate(servletContext).convertAndSend("xfr.status.onchange", data);
	}
}
