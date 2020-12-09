package edu.eci.cvds.persistence.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.concreteEntities.Novedad;
import edu.eci.cvds.persistence.service.adapter.entities.NovedadAdapter;

public interface NovedadMapper {

	void save(@Param("elementoID") String identificador, 
			@Param("titulo") String titulo, 
			@Param("responsable") String responsable, 
			@Param("detalle") String detalle);

	List<NovedadAdapter> get(@Param("elementoID") String id);

	List<NovedadAdapter> getAll();

}
