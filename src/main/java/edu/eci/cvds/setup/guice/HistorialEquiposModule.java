package edu.eci.cvds.setup.guice;

import com.google.inject.AbstractModule;

import edu.eci.cvds.persistence.dao.ElementoEquipoDAO;
import edu.eci.cvds.persistence.dao.EquipoDAO;
import edu.eci.cvds.persistence.dao.LaboratorioDAO;
import edu.eci.cvds.persistence.dao.NovedadDAO;
import edu.eci.cvds.persistence.dao.mybatis.MyBatisElementoEquipoDAO;
import edu.eci.cvds.persistence.dao.mybatis.MyBatisEquipoDAO;
import edu.eci.cvds.persistence.dao.mybatis.MyBatisLaboratorioDAO;
import edu.eci.cvds.persistence.dao.mybatis.MyBatisNovedadDAO;
import edu.eci.cvds.persistence.service.PersistenceManager;
import edu.eci.cvds.persistence.service.impl.PersistenceManagerDAO;

public class HistorialEquiposModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bindPersistence();
	}
	
	private void bindPersistence() {
		bind(PersistenceManager.class).to(PersistenceManagerDAO.class);
		
		bind(ElementoEquipoDAO.class).to(MyBatisElementoEquipoDAO.class);
		bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
		bind(LaboratorioDAO.class).to(MyBatisLaboratorioDAO.class);
		bind(NovedadDAO.class).to(MyBatisNovedadDAO.class);

	}

}
