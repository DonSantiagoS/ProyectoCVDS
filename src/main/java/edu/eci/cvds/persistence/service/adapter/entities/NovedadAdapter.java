package edu.eci.cvds.persistence.service.adapter.entities;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class NovedadAdapter {

	private String registrable;
	private Timestamp fechaHora;
	private String titulo;
	private String responsable;
	private String detalle;
	
	
}
