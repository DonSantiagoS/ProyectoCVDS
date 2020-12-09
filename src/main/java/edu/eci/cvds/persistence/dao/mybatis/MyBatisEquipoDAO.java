package edu.eci.cvds.persistence.dao.mybatis;

import edu.eci.cvds.entities.abstractEntities.ElementoEquipo;
import edu.eci.cvds.entities.concreteEntities.Equipo;
import edu.eci.cvds.persistence.dao.EquipoDAO;
import edu.eci.cvds.persistence.dao.mybatis.mappers.EquipoMapper;
import edu.eci.cvds.persistence.service.adapter.entities.EquipoAdapter;
import edu.eci.cvds.utils.connection.SqlConnection;

import java.util.List;

import com.google.inject.Inject;

public class MyBatisEquipoDAO implements EquipoDAO {
	
	private EquipoMapper equipoMap;
	
	public MyBatisEquipoDAO() {
		equipoMap = SqlConnection.getMapper(EquipoMapper.class);
	}

	public void save(Equipo equipo) {
		equipoMap.save(equipo);
	}

	public EquipoAdapter get(String id) {
		return equipoMap.get(id);
	}

	public List<EquipoAdapter> getAll() {
		return equipoMap.getAll();
	}

	public void asociar(Equipo equipo, ElementoEquipo elem) {
		equipoMap.asociar(equipo, elem);		
	}

	public void inhabilitar(Equipo eq) {
		equipoMap.inhabilitar(eq);
	}
	

}
