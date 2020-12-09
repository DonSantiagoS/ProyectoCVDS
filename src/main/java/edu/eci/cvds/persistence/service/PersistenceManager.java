package edu.eci.cvds.persistence.service;

import edu.eci.cvds.entities.abstractEntities.ElementoEquipo;
import edu.eci.cvds.entities.concreteEntities.Equipo;
import edu.eci.cvds.entities.concreteEntities.Laboratorio;
import edu.eci.cvds.exception.PersistenceException;

import java.util.List;

public interface PersistenceManager {
	
	/**
	 * Registra un equipo en la base de datos
	 * 
	 * @param equipo el equipo que se va a persistir. Debe tener todos sus atributos accesibles.
	 * @throws PersistenceException si hay errores con los datos del equipo o no tiene los elementos necesarios.
	 */
	void registrarEquipo(Equipo equipo) throws PersistenceException;
	
	/**
	 * Registra un equipo en la base de datos junto con los elementos que requiere. En caso de que no se pueda registrar el equipo,
	 * si se podr�n registrar los elementos.
	 * 
	 * @param equipo el equipo que se va a persistir. Debe tener todos sus atributos accesibles.
	 * @param elems lista de los elementos necesarios para el equipo. Debe ser uno de cada tipo: Torre, Pantalla, Mouse y Teclado.
	 * @throws PersistenceException si hay errores con los datos del equipo o no tiene los elementos necesarios
	 **/
	void registrarNuevoEquipo(Equipo equipo, List<ElementoEquipo> elems) throws PersistenceException; 
	
	/**
	 * Registra un elemento en la base de datos. 
	 * 
	 * @param elem elemento de equipo que se va a persistir.
	 * @throws PersistenceException si hay error con los datos del equipo.
	 */
	void registrarElemento(ElementoEquipo elem) throws PersistenceException;
	
	/**
	 * Registra una novedad en la base de datos. Las novedaddes toman la fecha de manera autom�tica.
	 * 
	 * @param identificador id del equipo o elemento al que se le va a registrar la novedad.
	 * @param titulo Encabezado o asunto principal de la novedad.
	 * @param responsable nombre del que realiz� la notificaci�n.
	 * @param detalle cuerpo de la notificaci�n. Puede estar vac�o meintras que el titulo no lo est�.
	 * @throws PersistenceException si hay error en los datos proporcionados.
	 */
	void registrarNovedad(String identificador, String titulo, String responsable, String detalle) throws PersistenceException;
	
	/**
	 * Registra un nuevo laboratorio en la base de datos.
	 * 
	 * @param lab el laboratorio con la informaci�n necesaria. 
	 * @throws PersistenceException si hay un error en los datos proporcionados.
	 */
	void crearLaboratorio(Laboratorio lab) throws PersistenceException;
	
	/**
	 * Registra un nuevo laboratorio en la base de datos junto con los equipos necesarios para su funcionamiento. Si hay un error con 
	 * alguno de los equipos, no se registra ese equipo.
	 * 
	 * @param lab el laboratorio con la informaci�n necesaria. 
	 * @param equipos los equipos pertenecientes al laboratorio. 
	 * @throws PersistenceException si hay error con los datos del laboratorio.
	 */
	void crearNuevoLaboratorio(Laboratorio lab, List<Equipo> equipos) throws PersistenceException;
	
	/**
	 * Agrega un equipo a un laboratorio. El laboratorio debe estar habilitado para que el proceso sea correcto.
	 * 
	 * @param lab el laboratorio que va a ser el due�o del equipo.
	 * @param equipo equipo a asociar.
	 * @throws PersistenceException si hay error en los datos proporcionados o si el laboratorio no est� habilitado para asociaciones.
	 */
	void asociarEquipo(Laboratorio lab, Equipo equipo) throws PersistenceException;
	
	/**
	 * Agrega un conjunto de equipos a un laboratorio. El laboratorio debe estar habilitado para que el proceso sea correcto.
	 * 
	 * @param lab el laboratorio que va a ser el due�o del equipo.
	 * @param equipos lista de los equipos a asociar.
	 * @throws PersistenceException si hay error en los datos proporcionados o si el laboratorio no est� habilitado para asociaciones.
	 */
	void asociarEquipos(Laboratorio lab, List<Equipo> equipos) throws PersistenceException;
	
	/**
	 * A�ade un elemento a un equipo espec�fico. Si el equipo ya tiene un elemento asociado de ese tipo, se relaciona con el nuevo.
	 * 
	 * @param equipo equipo objetivo de la asociaci�n.
	 * @param elem elemento a asociar.
	 * @throws PersistenceException si hay error en los datos proporcionados o si el equipo no est� habilitado para asociaciones.
	 */
	void asociarElemento(Equipo equipo, ElementoEquipo elem) throws PersistenceException;
	
	/**
	 * A�ade un conjunto de elementos a un equipo espec�fico. Si el equipo ya tiene un elemento asociado de ese tipo, 
	 * se relaciona con el nuevo.
	 * 
	 * @param equipo equipo objetivo de la asociaci�n.
	 * @param elems lista de elementos a asociar.
	 * @throws PersistenceException si hay error en los datos proporcionados o si el equipo no est� habilitado para asociaciones.
	 */
	void asociarElementos(Equipo equipo, List<ElementoEquipo> elems) throws PersistenceException;
	
	/**
	 * Inhabilita un laboratorio. Los equipos asociados al laboratorio ser�n desligados.
	 * 
	 * @param laboratorio laboratorio a inhabilitar.
	 * @throws PersistenceException si hay error en los datos proporcionados.
	 */
	void cerrarLaboratorio(Laboratorio laboratorio) throws PersistenceException;
	
	/**
	 * Inhabilita un equipo. Los elementos asociados a el pueden ser dados de baja o simplemente desligados.
	 * 
	 * @param equipo equipo a inhabilitar.
	 * @throws PersistenceException si hay error en los datos proporcionados.
	 */
	void inhabilitarEquipo(Equipo equipo) throws PersistenceException;
	
	/**
	 * Inhabilita un elemento de equipo. Los elementos no pueden ser inhabilitados si est�n asociados a un equipo.
	 * 
	 * @param elem elemento de equipo a inhabilitar.
	 * @throws PersistenceException si hay error en los datos o si el elemento no se puede inhabilitar.
	 */
	void inhabilitarElemento(ElementoEquipo elem) throws PersistenceException;
	
	/**
	 * Realiza el reporte de base de datos de los equipos.
	 * 
	 * @return Lista con los equipos que hay registrados.
	 */
	List<Equipo> reporteEquipos();
	
	/**
	 * Realiza el reporte en base de datos de los elementos de equipo.
	 * 
	 * @return Lista con los elementos de equipo que hay registrados.
	 */
	List<ElementoEquipo> reporteElementos();
	
	/**
	 * Realiza el reporte en base de datos de los laboratorios.
	 * 
	 * @return Lista con los laboratorios que hay registrados.
	 */
	List<Laboratorio> reporteLaboratorios();	

}
