package org.pos2d.webapi.dao;

import java.sql.Timestamp;

import org.hibernate.SessionFactory;
import org.pos2d.webapi.entities.t_silicagelcolor;
import org.springframework.transaction.annotation.Transactional;

public class t_silicagelcolorDAOImpl implements t_silicagelcolorDAO {
	
	private SessionFactory sessionFactory;
	public t_silicagelcolorDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
    @Transactional
	public void updateSilicaGelColor(String fileddata,String assetname){
		java.util.Date date= new java.util.Date();
		t_silicagelcolor color = new t_silicagelcolor();
		
		color.setAssetname(assetname);
		color.setTs(new Timestamp(date.getTime()));
		
		
		 String[] parts = fileddata.split(",");
		 String part2 = parts[1]; // Sil-gel-col=W"
		 String[] oilmoisture = part2.split("=");
		if(oilmoisture[1].equalsIgnoreCase("W")){
			color.setSilicageldiscolored(false);
		} else{
			color.setSilicageldiscolored(true);

		}
				
		sessionFactory.getCurrentSession().save(color);
	  
		
	}

}
