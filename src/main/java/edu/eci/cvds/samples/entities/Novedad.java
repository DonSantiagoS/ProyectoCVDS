package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.DateTime;
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


public class Novedad implements Serializable{

	private String id;
	private DateTime fecha;
	private String descripcion;
	private Equipo equipo;
	private Elemento elemento;
	private Usuario usuario;
	private Laboratorio laboratorio;	
	public Novedad(String id, DateTime fecha, String descripcion, Equipo equipo, Elemento elemento, Usuario usuario, Laboratorio laboratorio){		
		this.id=id;
		this.fecha=fecha;
		this.descripcion=descripcion;
		this.equipo=Equipo;
		this.laboratorio=Laboratorio;
		this.usuario=Usuario;
	}
	public String getId() {
		return id;
	}
	public void setId(int nuevoId) {
		id=nuevoId;
	}
	public DateTime getFechaNovedad() {
		return fechaNovedad;
	}
	public void setFecha(DateTime nuevaFecha) {
		fecha = nuevaFecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	
	
	public String getJustificacion() {
		return justificacion;
	}
	
	public int getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(int laboratorio) {
		this.laboratorio = laboratorio;
	}
	public int getEquipo() {
		return equipo;
	}
	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getElemento() {
		return elemento;
	}
	public void setElemento(int elemento) {
		this.elemento = elemento;
	}