package edu.eci.cvds.persistence.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.abstractEntities.ElementoEquipo;
import edu.eci.cvds.persistence.service.adapter.entities.ElementoEquipoAdapter;

public interface ElementoEquipoMapper {
	
	void save(@Param("elem") ElementoEquipo elem);

	ElementoEquipoAdapter get(@Param("elemID") String id);

	List<ElementoEquipoAdapter> getAll();

	void inhabilitar(@Param("elem") ElementoEquipo elem);

}
