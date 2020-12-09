package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

/**
*		------------------------------------------------------------------------
*		------------------------ PROYECTO CVDS ------------------------------------------
*		------------------------------------------------------------------------
*
* CLASE:   	
*
* @author : Santiago Buitrago
* @author : Eduard Arias
* @author : Andres Cubillos
* @author : Felipe Marin
*
* @version 1.1 
*
*/
public class Elemento implements Serializable{
	
	private String id;
	private Tipo tipoElemento;
	private String fabricante;
	private Equipo perteneceEquipo;
	private DateTime fechaCreacion;
	private DateTime fechaInicial;
	private DateTime fechaFinal;
	
	public Elemento(String id,Tipo tipoElemento, String fabricante, Equipo perteneceEquipo, DateTime fechaCreacion, DateTime fechaInicial, DateTime fechaFinal) {	
		this.id=id;
		this.tipoElemento=tipoElemento;
		this.fabricante=fabricante;
		this.fechaCreacion=fechaCreacion;
		this.fechaInicial=fechaInicial;
		this.fechaFinal=fechaInicial
	}
	
	public String getId() {
		return id;
	}
	public void setId(String nuevoId) {
		id=nuevoId;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String nuevoFabricante) {
		fabricante = nuevoFabricante;
	}	
	
	public DateTime getFechaInicial() {
		return fechaInicial;
	}	
	public void setFechaInicioActividad(DateTime nuevaFechaInicial) {
		fechaInicial = nuevaFechaInicial;
	}
	public DateTime getFechaFinal() {
		return fechaFinal;
	}	
	public void setFechaFinal(DateTime nuevaFechaFinal) {
		fechaFinal = nuevaFechaFinal;
	}
	public DateTime getFechaCreacion() {
		return fechaCreacion;
	}	
		
	public void setFechaCreacion(DateTime nuavaFechaCreacion) {
		fechaCreacion = nuavaFechaCreacion;
	}	

}