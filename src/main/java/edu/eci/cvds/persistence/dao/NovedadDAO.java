package edu.eci.cvds.persistence.dao;

import java.util.List;

import edu.eci.cvds.persistence.service.adapter.entities.NovedadAdapter;

public interface NovedadDAO {

	/**
	 * Guarda una nueva novedad en la base de datos.
	 * 
	 * @param identificador id del equipo o elemento al que se le va a registrar la novedad.
	 * @param titulo Encabezado o asunto principal de la novedad.
	 * @param responsable nombre del que realizó la notificación.
	 * @param detalle cuerpo de la notificación. Puede estar vacío meintras que el titulo no lo esté.
	 */
	void save(String identificador, String titulo, String responsable, String detalle);
	
	/**
	 * Retorna todas las novedaddes de un elemento específico, basado en su ID.
	 * 
	 * @param id identificador del elemento.
	 * @return Lista con todas las novedades de ese elemento.
	 */
	List<NovedadAdapter> get(String id);
	
	/**
	 * Retorna el historial de todas las novedades registradas en la base de datos.
	 * 
	 * @return Lista con todas las novedades.
	 */
	List<NovedadAdapter> getAll();
	
}
