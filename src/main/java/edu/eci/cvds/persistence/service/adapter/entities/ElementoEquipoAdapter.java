package edu.eci.cvds.persistence.service.adapter.entities;

import java.util.List;

import lombok.Data;

@Data
public class ElementoEquipoAdapter {

	private String id;
	private String descripcion;
	private boolean disponible;
	private char condicion;
	private String nombre;
	private char tipo;
	
	private List<NovedadAdapter> novedades;
	
	
}
