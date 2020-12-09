package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
*		------------------------------------------------------------------------
*		------------------------ PROYECTO CVDS ------------------------------------------
*		------------------------------------------------------------------------
*
* CLASE: Laboratorio  	
*
* @author : Santiago Buitrago
* @author : Eduard Arias
* @author : Andres Cubillos
* @author : Felipe Marin
*
* @version 1.1 
*
*/

public class Laboratorio implements Serializable{

	private String id;
	private DateTime fechaCreacion;
	private DateTime fechaFinal;
	private ArrayList<Equipo> equipos;
	private ArrayList<Registro> registros;
	private Usuario usuario;
	private String nombre;
	private String descripcion;
	private int capacidad;
	
	
	public Laboratorio(String id,DateTime fechaCreacion, DateTime fechaFinal,Usuario usuario, String nombre, String descripcion){
		equipos= new ArrayList<Equipo>();
		registros= new ArrayList<Registro>();
		administradores= new ArrayList<Administrador>();
		this.fechaCreacion=fechaCreacion;
		this.fechaFinal=fechaFinal;
		this.id=id;
		this.usuario= usuario;
		this.nombre= nombre;
		this.descripcion= descripcion;
	}
	
	public int getCapacidad(){
		return capacidad;
	}
	public void setCapacidad(int nuevaCapacidad){
		capacidad= nuevaCapacidad;
	}
	public String getNombre(){
		return nombre;
	}
	public String getDescripcion(){
		return descripcion;
	}
	public Usuario getUsuario(){
		return usuario;
	}
	public void setNombre(String nuevoNombre){
		nombre= nuevoNombre;
	}
	public void setDescripcion(String nuevoDescripcion){
		descripcion= nuevoDescripcion;
	}
	public void setUsuario(Usuario nuevoUsuario){
		usuario= nuevoUsuario;
	}
	public String getId(){
		return id;
	}
	public void setId(String nuevoId){
		id=nuevoId;
	}
	
	public DateTime getFechaCreacion(){
		return fechaCreacion;
	}
	public void setFechaCreacion(DateTime nuevaFechaCreacion){
		fechaCreacion= nuevaFechaCreacion;
	}
	public void setFechaFinal(DateTime nuevaFechaFinal){
		fechaFinal= nuevaFechaDinal;
	}
	public DateTime getFechaFinal(){
		return fechaFinal;
	}
	public void setId(String nuevoId){
		id= nuevoId;
	}
	
	public ArrayList<Equipo> getEquipos(){
		return equipos;
	}
	public void setEquipos(ArrayList<Equipo> nuevosEquipos){
		equipos=nuevosEquipos;
	}
	public ArrayList<Registro> getRegistros(){
		return registros;
	}
	public void setRegistros(ArrayList<Registro> nuevosRegistros){
		registros=nuevosRegistros;
	}
}
