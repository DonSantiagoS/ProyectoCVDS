package edu.eci.cvds.persistence.dao.mybatis;

import edu.eci.cvds.entities.concreteEntities.Equipo;
import edu.eci.cvds.entities.concreteEntities.Laboratorio;
import edu.eci.cvds.persistence.dao.LaboratorioDAO;
import edu.eci.cvds.persistence.dao.mybatis.mappers.LaboratorioMapper;
import edu.eci.cvds.persistence.service.adapter.entities.LaboratorioAdapter;
import edu.eci.cvds.utils.connection.SqlConnection;

import java.util.List;

import com.google.inject.Inject;

public class MyBatisLaboratorioDAO implements LaboratorioDAO {

	private LaboratorioMapper labMap;
	
	public MyBatisLaboratorioDAO() {
		labMap = SqlConnection.getMapper(LaboratorioMapper.class);
	}

	public void save(Laboratorio lab) {
		labMap.save(lab);
	}

	public LaboratorioAdapter get(String id) {
		return labMap.get(id);
	}

	public List<LaboratorioAdapter> getAll() {
		return labMap.getAll();
	}

	public void asociar(Laboratorio lab, Equipo equipo) {
		labMap.asociar(lab, equipo);
	}

	public void cerrar(Laboratorio lab) {
		labMap.cerrar(lab);
	}
	
	
}
