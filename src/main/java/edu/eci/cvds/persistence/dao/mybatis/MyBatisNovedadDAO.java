package edu.eci.cvds.persistence.dao.mybatis;

import edu.eci.cvds.persistence.dao.NovedadDAO;
import edu.eci.cvds.persistence.dao.mybatis.mappers.NovedadMapper;
import edu.eci.cvds.persistence.service.adapter.entities.NovedadAdapter;
import edu.eci.cvds.utils.connection.SqlConnection;

import java.util.List;

import com.google.inject.Inject;

public class MyBatisNovedadDAO implements NovedadDAO {
	
	private NovedadMapper novedadMap;
	
	public MyBatisNovedadDAO() {
		novedadMap = SqlConnection.getMapper(NovedadMapper.class);
	}

	public void save(String identificador, String titulo, String responsable, String detalle) {
		novedadMap.save(identificador, titulo, responsable, detalle);
	}

	public List<NovedadAdapter> get(String id) {
		return novedadMap.get(id);
	}

	public List<NovedadAdapter> getAll() {
		return novedadMap.getAll();
	}
	

}
