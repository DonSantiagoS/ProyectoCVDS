package edu.eci.cvds.persistence.dao;

import java.util.List;

import edu.eci.cvds.entities.abstractEntities.ElementoEquipo;
import edu.eci.cvds.entities.concreteEntities.Equipo;
import edu.eci.cvds.persistence.service.adapter.entities.EquipoAdapter;

public interface EquipoDAO {
	
	/**
	 * Inserta un obejto de tipo Equipo a la base de datos.
	 * 
	 * @param equipo objeto de tipo Equipo con la informaci�n a guardar.
	 */
	void save(Equipo equipo);
	
	/**
	 * Obtiene un elemento de tipo Equipo de la base de datos por su ID.
	 * 
	 * @param id identificador del elemento.
	 * @return objeto de tipo Equipo.
	 */
	EquipoAdapter get(String id);
	
	/**
	 * Obtiene todos los objetos de tipo Equipo de la base de datos.
	 * 
	 * @return Lista con los elementos obtenidos. Si no hay elementos, retorna una lista vac�a.
	 */
	List<EquipoAdapter> getAll();
	
	/**
	 * Asocia un elemento de equipo a un equipo espec�fico en la base de datos.
	 * 
	 * @param equipo equipo due�o de la asociaci�n. Si no hay relaci�n, asocia una nueva.
	 * @param elem elemento de equipo.
	 */
	void asociar(Equipo equipo, ElementoEquipo elem);
	
	/**
	 * Cambia el estado de un objeto Equipo a "inhabilitado" o "Dado de baja".
	 * 
	 * @param eq objeto que contiene la informaci�n respectiva de la relaci�n en la base de datos.
	 */
	void inhabilitar(Equipo eq);

}
