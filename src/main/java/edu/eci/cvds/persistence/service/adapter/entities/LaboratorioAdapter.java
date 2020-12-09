package edu.eci.cvds.persistence.service.adapter.entities;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class LaboratorioAdapter {

	private String id;
	private boolean disponible;
	private Date creacion;
	private Date cierre;
	
	private List<EquipoAdapter> equipos;
	
	
}
