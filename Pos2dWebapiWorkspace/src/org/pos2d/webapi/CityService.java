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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.pos2d.webapi.dao.CityDAO;
import org.pos2d.webapi.entities.cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author soumik
 *
 */
@Path("/city")
@Produces(MediaType.APPLICATION_JSON)
public class CityService {
	
	/*@Autowired
    private CityDAO cityDao;*/
	
	private CityDAO getCityDAO(ServletContext servletContext)
	{
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		if(ctx == null)
		{			
			System.out.println("Can not find spring context");
			return null;
		}
		CityDAO cityDao = (CityDAO) ctx.getBean("cityDAO");
		return cityDao;
	}
	
	
	@GET
    @Path("/{name}")
    public cities getCity(@Context ServletContext servletContext,@PathParam("name") String name) {
		CityDAO cityDao = getCityDAO(servletContext);
		if(cityDao == null)
		{			
			System.out.println("Citydao can not be instantiated");
			return null;
		}
		cities city = cityDao.getByName(name);
        //CityBean
		return city;
    }
	
	@SuppressWarnings("rawtypes")
	@GET
    @Path("/getall")
    public List getAllCities(@Context ServletContext servletContext) {
		CityDAO cityDao = getCityDAO(servletContext);
		if(cityDao == null)
		{			
			System.out.println("Citydao can not be instantiated");
			return null;
		}
		List<cities> cities = cityDao.getAll();
		/*List<CityBean> cityNames = new ArrayList<CityBean>();
		for(City city: cities){
			//cityNames.add(city.getName());
			CityBean bean = new CityBean();
			bean.setName(city.getName());
			cityNames.add(bean);
		}
		return cityNames;*/
		return cities;
	}

}
