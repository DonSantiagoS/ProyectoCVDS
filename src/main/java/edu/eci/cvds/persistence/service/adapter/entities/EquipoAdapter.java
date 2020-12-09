package edu.eci.cvds.persistence.service.adapter.entities;

import java.util.List;

import lombok.Data;

@Data
public class EquipoAdapter {
	
	private String id;
	private String descripcion;
	private boolean disponible;
	private char condicion;
	private String nombre;
	
	private List<ElementoEquipoAdapter> elems;
	private List<NovedadAdapter> novedades;
	
	
}
