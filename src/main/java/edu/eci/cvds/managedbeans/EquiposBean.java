package edu.eci.cvds.managedbeans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.ConeccionEquipo;

@ManagedBean @RequestScoped
public class EquiposBean {

	private String id;  
	private String labID;  


	public ArrayList<EquiposBean>equiposListFromDB;

	public String getId() {
		return id;	
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getlabID() {
		return labID;
	}

	public void setlabId(String labId) {
		this.labID = labId;
	}

	
	
	/* Method Will Avoid Multiple Calls To DB For Fetching The equipos Records. If This Is Not Used & Data Is Fetched From Getter Method, JSF DataTable Will Make Multiple Calls To DB*/
	@PostConstruct
	public void init() {
		equiposListFromDB = ConeccionEquipo.getEquiposListFromDB();
	}

	/* Method Used To Fetch All Records From The Database */
	public ArrayList<EquiposBean> EquiposList() {
		return EquiposListFromDB;
	}
	
	
	public String saveEquipoDetails(EquiposBean newEquipoObj) {
		return ConeccionEquipo.saveEquipoDetailsInDB(newEquipoObj);
	}
	
	public String editEquipoRecord(String EquipoId) {
		return ConeccionEquipo.editEquipoRecordInDB(EquipoId);
	}
	
	public String updateEquipoDetails(EquiposBean updateEquipoObj) {
		return ConeccionEquipo.updateEquipoDetailsInDB(updateEquipoObj);
	}
	
	public String deleteEquipoRecord(String EquipoId) {
		return ConeccionEquipo.deleteEquipoRecordInDB(EquipoId);
	}
}
