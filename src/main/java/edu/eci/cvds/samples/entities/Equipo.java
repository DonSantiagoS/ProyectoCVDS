package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

/**
*		------------------------------------------------------------------------
*		------------------------ PROYECTO CVDS ------------------------------------------
*		------------------------------------------------------------------------
*
* CLASE: Equipo  	
*
* @author : Santiago Buitrago
* @author : Eduard Arias
* @author : Andres Cubillos
* @author : Felipe Marin
*
* @version 1.1 
*
*/
public class Equipo implements Serializable{

	private String id;
	private DateTime fechaInicial;
	private DateTime fechaFinal;
	private DateTime fechaCreacion;
	private Laboratorio laboratorio;
	private ArrayList<Elemento> elementos;	
	
	public Equipo(String id, DateTime fechaInicial, DateTime fechaFinal, DateTime fechaCreacion, Laboratorio laboratorio){
		this.id=id;
		this.fechaInicial=fechaInicial;
		this.fechaFinal=fechaFinal;
		this.fechaCreacion=fechaCreacion;
		this.laboratorio=laboratorio
		elementos= new ArrayList<Elemento>();
	}
	
	public String getId() {
		return id;
	}	
	public void setId(int nuevoId) {
		id = nuevoId;
	}	
	public Date getFechaInicial() {
		return fechaInicial;
	}	
	public void setFechaInicial(Date nuevaFechaInicial) {
		this.fechaInicial = nuevaFechaInicial;
	}	
	public Date getFechaFinal() {
		return fechaFinal;
	}	
	public void setFechaFinal(Date nuevaFechaFinal) {
		this.fechaFinal = nuevaFechaFinal;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}	
	public void setfechaCreacion(Date nuevaFechaCreacion) {
		fechaCreacion = nuevaFechaCreacion;
	}
	public ArrayList<Elemento> getElementos(){
		return elementos;
	}	
	public void setElementos(ArrayList<Elemento> elementos){
		this.elementos = elementos;
	}	
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio nuevoLaboratorio) {
		laboratorio = nuevoLaboratorio;
	}	
}