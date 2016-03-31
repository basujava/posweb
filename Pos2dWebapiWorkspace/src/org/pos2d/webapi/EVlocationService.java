package org.pos2d.webapi;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.pos2d.webapi.dao.EVlocationgisDAO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Path("/ev")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EVlocationService {
	
	//@Autowired
	//private EVlocationgisDAO EvDAO;
	
	
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

	private EVlocationgisDAO getEvLocationDao(ServletContext servletContext)
	{
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		if(ctx == null)
		{			
			System.out.println("Can not find spring context");
			return null;
		}
		EVlocationgisDAO evLocationDao = (EVlocationgisDAO) ctx.getBean("EVlocationgisDAO");
		return evLocationDao;
		
		
	}
	@POST
	@Path("/location")
	public void updateLocation(@Context ServletContext servletContext, String data){
		/*
		 * Message schema is 
		 * {
			    "vehicleName":"TRUCK/91-01",
			    "longitude":"88.67",
			    "latitude":"27.35"
			}
		 *
		 */
		getRabbitTemplate(servletContext).convertAndSend("evlocation.onchange", data);
	}

}
