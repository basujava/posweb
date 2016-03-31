/**
 * 
 */
package org.pos2d.webapi.mq;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.pos2d.webapi.beans.WebMsgBean;
import org.pos2d.webapi.dao.EVlocationgisDAO;
import org.pos2d.webapi.dao.TransformerDAO;
import org.pos2d.webapi.dao.VehicleDAO;
import org.pos2d.webapi.dao.chargingstationDAO;
import org.pos2d.webapi.dao.chargingstationgisDAO;
import org.pos2d.webapi.dao.cs_statusparamsDAO;
import org.pos2d.webapi.dao.discomtransformerDAO;
import org.pos2d.webapi.dao.ev_locationDAO;
import org.pos2d.webapi.dao.fieldtrucklocationgisDAO;
import org.pos2d.webapi.dao.industrialloadDAO;
import org.pos2d.webapi.dao.industrialloadgisDAO;
import org.pos2d.webapi.dao.loaddemandprofileDAO;
import org.pos2d.webapi.dao.maplayoutDAO;
import org.pos2d.webapi.dao.t_alertmessagesDAO;
import org.pos2d.webapi.dao.t_fieldstatusDAO;
import org.pos2d.webapi.dao.t_oilmoisturecontentDAO;
import org.pos2d.webapi.dao.t_silicagelcolorDAO;
import org.pos2d.webapi.entities.chargingstation;
import org.pos2d.webapi.entities.cs_statusparams;
import org.pos2d.webapi.entities.ev_location;
import org.pos2d.webapi.entities.ev_locationgis;
import org.pos2d.webapi.entities.fieldtrucklocation;
import org.pos2d.webapi.entities.fieldtrucklocationgis;
import org.pos2d.webapi.entities.industrialload;
import org.pos2d.webapi.entities.loaddemandprofile;
import org.pos2d.webapi.entities.maplayout;
import org.pos2d.webapi.entities.t_fieldstatus;
import org.pos2d.webapi.entities.t_oilmoisturecontent;
import org.pos2d.webapi.util.WebApiConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author soumik
 *
 */
public class DbLoggerListener {
	
	@Autowired
	private t_silicagelcolorDAO silicaDAO;
	
	@Autowired
	private fieldtrucklocationgisDAO fieldtruckDAO;
	
	@Autowired
	private discomtransformerDAO dxfrDAO;
	
	@Autowired
	private cs_statusparamsDAO csparamDAO;
	
	@Autowired
	private maplayoutDAO mlayoutDAO;
	
	@Autowired
	private industrialloadDAO industrialDAO;
	
	@Autowired
	private chargingstationDAO ChargingStationDAO;
	
	@Autowired
	private chargingstationgisDAO ChargingStationgisDAO;
	
	@Autowired
	private industrialloadgisDAO industrialgisDAO;
	
	@Autowired
	private EVlocationgisDAO EDAO;
	
	@Autowired
	private loaddemandprofileDAO loadDAO;
	
	@Autowired
	private t_alertmessagesDAO ADAO;
	
	@Autowired
	private ev_locationDAO ElocDAO;
	
	@Autowired
     private TransformerDAO xfrDAO;
	
	@Autowired
    private t_oilmoisturecontentDAO moistureDAO;
	 @Autowired
	 private t_fieldstatusDAO tfldDAO;

	@Autowired
    private VehicleDAO vehicleDAO;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/*@Transactional
	public void saveLocation(String data) throws JsonParseException, JsonMappingException, IOException {
	    //System.out.println("Error Location"+data);
		System.out.println("In DbLoggerListener#saveLocation:");
		ObjectMapper mapper = new ObjectMapper();
		VehicleLocationBean bean = mapper.readValue(data, VehicleLocationBean.class);
		vehicleDAO.createVehicleLocation(bean);
		rabbitTemplate.convertAndSend("location.changed", data);
	}*/
	
	/*@Transactional
	public void saveXfrStatus(String data) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("In DbLoggerListener#saveXfrStatus:");
		//System.out.println(foo);
		ObjectMapper mapper = new ObjectMapper();
		TransformerStatusBean bean = mapper.readValue(data, TransformerStatusBean.class);
		String statusData = mapper.writeValueAsString(bean.getStatusData());
	//	xfrDAO.createXfrStatus(bean, statusData);
		rabbitTemplate.convertAndSend("xfr.status.changed", data);
    }*/
	
	@Transactional
	public void savet_fieldstatus(String data) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("In DbLoggerListener#saveXfrStatus:");
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			t_fieldstatus bean = mapper.readValue(data, t_fieldstatus.class);
			 t_oilmoisturecontent oilmoisturecontent = new t_oilmoisturecontent();
			 oilmoisturecontent.setAssetname(bean.getAssetname());
			 
	         String fdata= bean.getFielddata();
			 String[] parts = fdata.split(",");
			 String part1 = parts[0]; // 004
			 String[] oilmoisture = part1.split("=");
			 oilmoisturecontent.setOiltemperaturec(40);
			 oilmoisturecontent.setOilmoistureppm(Double.parseDouble(oilmoisture[1]));
			 java.util.Date date= new java.util.Date();
			 oilmoisturecontent.setTs(new Timestamp(date.getTime()));
			 silicaDAO.updateSilicaGelColor(bean.getFielddata(), bean.getAssetname());
			 dxfrDAO.updatediscomtransformer(bean.getAssetname(), bean.getAlertstatus(), bean.getFielddata());
			 if("BAD".equalsIgnoreCase(bean.getAlertstatus()))
			 {
				 List<fieldtrucklocationgis> fieldtrucklist = fieldtruckDAO.getAllfieldtruck();	
				 String regno=null;
				 double dempdistance=50;
				 for(int i=0;i<fieldtrucklist.size();i++){
					
					double distance= distance(22.6240798,88.4565103, fieldtrucklist.get(i).getLatitude(),fieldtrucklist.get(i).getLongitude());
					if(distance<=dempdistance) {
					dempdistance=distance;
					regno=fieldtrucklist.get(i).getRegno();
					}
					
				 }
				 ADAO.Savealertmessages(bean.getAssetname(),bean.getFielddata());				 
			 }
			 moistureDAO.saveoilmoisturecontent(oilmoisturecontent);
		     tfldDAO.savet_fieldstatus(bean);
		     xfrDAO.update_utilitygis_transformer(bean.getAssetname(),bean.getAlertstatus(),bean.getFielddata());
			 rabbitTemplate.convertAndSend("xfr.status.changed", data);
			
		}
		catch(Exception eX)
		{
			System.out.println("In DbLogger.savet_fieldstatus " + eX.getMessage() + " type: " + eX.getClass().getName());
		}
    }
	
	
	public double splitter(String input){
		
		return 0;
	}
	
	
	@Transactional
	public void saveProximityEvent(String data) {
		System.out.println("In DbLoggerListener#saveProximityEvent:");
		System.out.println(data);
    }

	@Transactional
	public void SaveEVlocation (String data) throws JsonParseException, JsonMappingException, IOException {
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			ev_locationgis bean = mapper.readValue(data, ev_locationgis.class);
			ev_location bean_ev_location = mapper.readValue(data, ev_location.class);
			double xCord = bean.getXcordinate();
			double yCord = bean.getYcordinate();
			if(xCord >= 1 && xCord <= WebApiConstants.MAX_X && yCord >=1 && yCord <= WebApiConstants.MAX_Y)
			{
				maplayout loc=mlayoutDAO.getlocation(bean.getXcordinate(),bean.getYcordinate());		
				java.util.Date date= new java.util.Date();
				bean.setLatitude(loc.getLatitude());
				bean.setLongitude(loc.getLongitude());
				bean_ev_location.setLatitude(loc.getLatitude());
				bean_ev_location.setLongitude(loc.getLongitude());
				bean.setLastlocationts(new Timestamp(date.getTime()));
				bean_ev_location.setLastlocationts(new Timestamp(date.getTime()));
				String message="{\"regno\":\""+bean.getRegno()+"\",\"longitude\":\""+loc.getLongitude()+"\",\"latitude\":\""+loc.getLatitude()+"\",\"stateofchargekm\":\""+bean.getStateofchargekm()+"\"}";
				ElocDAO.updateEVlocationcis(bean_ev_location);
				EDAO.updateEVlocationgis(bean);
				rabbitTemplate.convertAndSend("evlocation.changed", message);			
			}
			
			
		}
		catch(Exception eX)
		{
			System.out.println("In Dblogger.SaveEVlocation " + eX.getMessage() + " type: " + eX.getClass().getName());
			
		}
	}
	
	@Transactional
public void SaveLoadprofile (String data) throws JsonParseException, JsonMappingException, IOException {
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			loaddemandprofile Loadbean = mapper.readValue(data, loaddemandprofile.class);
	        		
			java.util.Date date= new java.util.Date();
			Loadbean.setTs((new Timestamp(date.getTime())));
			industrialDAO.updateindustrialLoad(Loadbean.getCompanyname(), Loadbean.getCurrentdemandkw());
			industrialgisDAO.updateindustrialLoad(Loadbean.getCompanyname(), Loadbean.getCurrentdemandkw());
			loadDAO.saveloaddemandprofile(Loadbean);	
				
			
			ArrayList<chargingstation> csDetailslist=ChargingStationDAO.getChargingStations();
			ArrayList<industrialload> inddetails=industrialDAO.getindustrialloads(Loadbean.getCompanyname());
			for(int i=0;i<csDetailslist.size();i++){
				chargingstation cs=csDetailslist.get(i);
				industrialload indus = inddetails.get(0);
				    double cslatpos=cs.getLatitude();
					double cslongpost=cs.getLongitude();
					int carqueue=Randomnumbergen();
					
								
					String csname=cs.getCsname();
					double indlatpos=indus.getLatitude();
					double indlongpos=indus.getLongitude();
					double inddemand=indus.getCurrentdemandkw();
					double distance=distance(cslatpos,cslongpost,indlatpos,indlongpos);
	                System.out.println();
					double price=15+( 0.001*inddemand / (2*distance) );
					double roundprice = RoundTo2Decimals(price);
					
					ChargingStationDAO.updateprice(csname, roundprice, carqueue); 
					ChargingStationgisDAO.updateprice(csname, roundprice, carqueue);
									
					 cs_statusparams csp= new cs_statusparams();
					 csp.setCsname(csname);
					 csp.setCurrentcarqueue(carqueue);
					 csp.setEnergypricesignal(roundprice);
					// java.util.Date date= new java.util.Date();
					 csp.setTs(new Timestamp(date.getTime()));
					
					csparamDAO.updateCSParams(csp);
			}
			rabbitTemplate.convertAndSend("load.changed", data);
			
		}
		catch(Exception eX)
		{
			System.out.println("In Dblogger.SaveLoadprofile " + eX.getMessage() + " type: " + eX.getClass().getName());
			
		}
		
	}
	
	
	@Transactional
	public void saveTrkLocation(String data) throws JsonParseException, JsonMappingException, IOException{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			fieldtrucklocationgis Vehiclebeangis = mapper.readValue(data, fieldtrucklocationgis.class);
			fieldtrucklocation Vehiclebean = mapper.readValue(data, fieldtrucklocation.class);
			
			double xCord = Vehiclebean.getXcordinate();
			double yCord = Vehiclebean.getYcordinate();
			if(xCord >= 1 && xCord <= WebApiConstants.MAX_X && yCord >=1 && yCord <= WebApiConstants.MAX_Y)
			{
				maplayout loc=mlayoutDAO.getlocation(Vehiclebean.getXcordinate(),Vehiclebean.getYcordinate());		
				java.util.Date date= new java.util.Date();
				Vehiclebean.setFieldmobileid(Vehiclebean.getRegno());
				Vehiclebeangis.setFieldmobileno(Vehiclebeangis.getRegno());
				Vehiclebeangis.setLastlocationts((new Timestamp(date.getTime())));
				Vehiclebean.setLatitude(loc.getLatitude());
				Vehiclebean.setLongitude(loc.getLongitude());
				Vehiclebean.setTs((new Timestamp(date.getTime())));
				Vehiclebeangis.setLatitude(loc.getLatitude());
				Vehiclebeangis.setLongitude(loc.getLongitude());
				
				fieldtruckDAO.savefieldtruck(Vehiclebeangis);
				vehicleDAO.createActiveVehicle(Vehiclebean);
				rabbitTemplate.convertAndSend("trklocation.changed", data);
			}
			
		}
		catch(Exception eX)
		{
			System.out.println("In Dblogger.saveTrkLocation " + eX.getMessage() + " type: " + eX.getClass().getName());
			
		}
	}
	
	
	
	private double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;
		
		return (dist);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	
	public int Randomnumbergen(){	
     Random r = new Random();
    
    // Random.nextInt(int) returns a value from 0 (inclusive)
    // up to but excluding the int passed into the method.
    // (6 is excluded)
    int number = r.nextInt(6) + 1;

    System.out.println("You rolled a " + number);
    
    return number;
    
	}
	
	double RoundTo2Decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.##");
    return Double.valueOf(df2.format(val));
}

	
}
