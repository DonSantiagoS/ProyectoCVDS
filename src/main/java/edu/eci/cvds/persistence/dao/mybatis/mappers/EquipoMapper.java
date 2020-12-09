package edu.eci.cvds.persistence.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.abstractEntities.ElementoEquipo;
import edu.eci.cvds.entities.concreteEntities.Equipo;
import edu.eci.cvds.persistence.service.adapter.entities.EquipoAdapter;

public interface EquipoMapper {

	void save(@Param("equipo") Equipo equipo);

	EquipoAdapter get(@Param("equipoID") String id);

	List<EquipoAdapter> getAll();

	void asociar(@Param("equipo") Equipo equipo, 
			@Param("elem") ElementoEquipo elem);

	void inhabilitar(@Param("equipo") Equipo eq);

}
