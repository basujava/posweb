/**
 * 
 */
package org.pos2d.webapi.dao;

import java.util.List;

import org.pos2d.webapi.beans.TransformerStatusBean;
import org.pos2d.webapi.entities.Transformer;
import org.pos2d.webapi.entities.t_fieldstatus;

/**
 * @author soumik
 *
 */
public interface TransformerDAO {
	public List<Transformer> getBySuburbAndStatus(String city, String suburb, String status);
	public List<Transformer> getBySuburb(String city, String suburb);
	void update_utilitygis_transformer(String assetname,String alert,String fielddata);
	//void Savealertmessages(String assetname,String fielddata, )
	//public void SaveFieldStatus(t_fieldstatus inputdata);
	//public void createXfrStatus(TransformerStatusBean bean, String data);
	}
