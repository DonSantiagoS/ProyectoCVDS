package edu.eci.cvds.persistence.service.impl;

import edu.eci.cvds.persistence.service.PersistenceManager;
import edu.eci.cvds.persistence.service.adapter.Adapter;
import edu.eci.cvds.persistence.service.adapter.entities.ElementoEquipoAdapter;
import edu.eci.cvds.persistence.service.adapter.entities.EquipoAdapter;
import edu.eci.cvds.persistence.service.adapter.entities.LaboratorioAdapter;
import edu.eci.cvds.entities.abstractEntities.ElementoEquipo;
import edu.eci.cvds.entities.concreteEntities.Equipo;
import edu.eci.cvds.entities.concreteEntities.Laboratorio;
import edu.eci.cvds.exception.PersistenceException;
import edu.eci.cvds.persistence.dao.*;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

public class PersistenceManagerDAO implements PersistenceManager {
	
	private ElementoEquipoDAO elemDAO;
	
	private EquipoDAO equipoDAO;
	 
	private LaboratorioDAO labDAO;
	 
	private NovedadDAO novDAO;

	@Inject
	public PersistenceManagerDAO(ElementoEquipoDAO elemDAO, EquipoDAO equipoDAO, LaboratorioDAO labDAO, NovedadDAO novDAO) {
		this.elemDAO = elemDAO;
		this.equipoDAO = equipoDAO;
		this.labDAO = labDAO;
		this.novDAO = novDAO;
	}

	public void registrarEquipo(Equipo equipo) throws PersistenceException {
		equipoDAO.save(equipo);
		
	}

	public void registrarNuevoEquipo(Equipo equipo, List<ElementoEquipo> elems) throws PersistenceException {
		registrarEquipo(equipo);
		
		//adiciona los elementos faltantes
		for (ElementoEquipo elem: elems) {
			registrarElemento(elem);
		}
		asociarElementos(equipo, elems);
		
	}

	public void registrarElemento(ElementoEquipo elem) throws PersistenceException {
		elemDAO.save(elem);
	}

	public void registrarNovedad(String identificador, String titulo, String responsable, String detalle) throws PersistenceException {
		novDAO.save(identificador, titulo, responsable, detalle);
		
	}

	public void crearLaboratorio(Laboratorio lab) throws PersistenceException {
		labDAO.save(lab);
		
	}

	public void crearNuevoLaboratorio(Laboratorio lab, List<Equipo> equipos) throws PersistenceException {
		crearLaboratorio(lab);
		
		//adiciona los equipos faltantes
		for (Equipo eq: equipos) {
			registrarEquipo(eq);
		}
		asociarEquipos(lab, equipos);
		
	}

	public void asociarEquipo(Laboratorio lab, Equipo equipo) throws PersistenceException {
		labDAO.asociar(lab, equipo);
		
	}

	public void asociarEquipos(Laboratorio lab, List<Equipo> equipos) throws PersistenceException {
		for (Equipo eq: equipos) {
			asociarEquipo(lab, eq);
		}
		
	}

	public void asociarElemento(Equipo equipo, ElementoEquipo elem) throws PersistenceException {
		equipoDAO.asociar(equipo, elem);
		
	}

	public void asociarElementos(Equipo equipo, List<ElementoEquipo> elems) throws PersistenceException {
		for (ElementoEquipo elem: elems) {
			asociarElemento(equipo, elem);
		}
		
	}

	public void cerrarLaboratorio(Laboratorio laboratorio) throws PersistenceException {
		labDAO.cerrar(laboratorio);
		
	}

	public void inhabilitarEquipo(Equipo equipo) throws PersistenceException {
		equipoDAO.inhabilitar(equipo);
		
	}

	public void inhabilitarElemento(ElementoEquipo elem) throws PersistenceException {
		elemDAO.inhabilitar(elem);
		
	}

	public List<Equipo> reporteEquipos() {
		List<Equipo> equipos = new ArrayList<Equipo>();
		for (EquipoAdapter eqAd: equipoDAO.getAll()) {
			equipos.add(Adapter.convert(eqAd));
		}
		return equipos;
	}

	public List<ElementoEquipo> reporteElementos() {
		List<ElementoEquipo> elems = new ArrayList<ElementoEquipo>();
		for (ElementoEquipoAdapter elemAd: elemDAO.getAll()) {
			elems.add(Adapter.convert(elemAd));
		}
		return elems;
	}

	public List<Laboratorio> reporteLaboratorios() {
		List<Laboratorio> labs = new ArrayList<Laboratorio>();
		for (LaboratorioAdapter labAd: labDAO.getAll()) {
			labs.add(Adapter.convert(labAd));
		}
		return labs;
	}
	
	
}
