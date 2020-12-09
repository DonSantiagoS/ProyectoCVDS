package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

/**
*		------------------------------------------------------------------------
*		------------------------ PROYECTO CVDS ------------------------------------------
*		------------------------------------------------------------------------
*
* CLASE: Usuario  	
*
* @author : Santiago Buitrago
* @author : Eduard Arias
* @author : Andres Cubillos
* @author : Felipe Marin
*
* @version 1.1 
*
*/
public class Usuario implements Serializable{
	private String id;
	private String nombreCompleto;
	private String correo;
	private String rol;
	private String contra;
	
	public Usuario(){		
	}
		public int getId() {
		return id;
	}
	public void setId(String nuevoId) {
		this.id=nuevoId;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nuevoNombreCompleto) {
		this.nombreCompleto = nuevoNombreCompleto;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	//revisar
	public void setRol(String rol) {
		this.rol = rol;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public String getRol() {
		return rol;
	}
	public String getContra() {
		return contra;
	}

}