package edu.eci.cvds.persistence.dao;

import java.util.List;

import edu.eci.cvds.entities.concreteEntities.Equipo;
import edu.eci.cvds.entities.concreteEntities.Laboratorio;
import edu.eci.cvds.persistence.service.adapter.entities.LaboratorioAdapter;

public interface LaboratorioDAO {

	/**
	 * Inserta un obejto de tipo Laboratorio a la base de datos.
	 * 
	 * @param lab objeto de tipo Laboratorio con la información a guardar.
	 */
	void save(Laboratorio lab);
	
	/**
	 * Obtiene un elemento de tipo Laboratorio de la base de datos por su ID.
	 * 
	 * @param id identificador del elemento.
	 * @return objeto de tipo Laboratorio.
	 */
	LaboratorioAdapter get(String id);
	
	/**
	 * Obtiene todos los objetos de tipo Laboratorio de la base de datos.
	 * 
	 * @return Lista con los elementos obtenidos. Si no hay elementos, retorna una lista vacía.
	 */
	List<LaboratorioAdapter> getAll();
	
	/**
	 * Asocia un qeuipo a un laboratorio específico en la base de datos.
	 * 
	 * @param lab laboratorio dueño de la asociación. Si no hay relación, asocia una nueva.
	 * @param equipo equipo relacionado.
	 */
	void asociar(Laboratorio lab, Equipo equipo);
	
	/**
	 * Cambia el estado de un objeto Laboratorio a "inhabilitado", "Cerrado" o "Dado de baja".
	 * 
	 * @param lab objeto que contiene la información respectiva de la relación en la base de datos.
	 */
	void cerrar(Laboratorio lab);
	
}
