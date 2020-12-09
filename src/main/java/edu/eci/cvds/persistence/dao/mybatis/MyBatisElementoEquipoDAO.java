package edu.eci.cvds.persistence.dao.mybatis;

import edu.eci.cvds.entities.abstractEntities.ElementoEquipo;
import edu.eci.cvds.persistence.dao.ElementoEquipoDAO;
import edu.eci.cvds.persistence.dao.mybatis.mappers.ElementoEquipoMapper;
import edu.eci.cvds.persistence.service.adapter.entities.ElementoEquipoAdapter;
import edu.eci.cvds.utils.connection.SqlConnection;

import java.util.List;

import com.google.inject.Inject;

public class MyBatisElementoEquipoDAO implements ElementoEquipoDAO {

	private ElementoEquipoMapper elementoMap;

	public MyBatisElementoEquipoDAO() {
		elementoMap = SqlConnection.getMapper(ElementoEquipoMapper.class);
	}

	public void save(ElementoEquipo elem) {
		elementoMap.save(elem);
	}

	public ElementoEquipoAdapter get(String id) {
		return elementoMap.get(id);
	}

	public List<ElementoEquipoAdapter> getAll() {
		return elementoMap.getAll();
	}

	public void inhabilitar(ElementoEquipo elem) {
		elementoMap.inhabilitar(elem);		
	}
	
	
}
