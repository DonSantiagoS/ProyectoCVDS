package edu.eci.cvds.main;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.entities.abstractEntities.ElementoEquipo;
import edu.eci.cvds.entities.concreteEntities.Teclado;
import edu.eci.cvds.exception.PersistenceException;
import edu.eci.cvds.persistence.service.PersistenceManager;
import edu.eci.cvds.setup.guice.HistorialEquiposModule;

public class PersistenceTest {
	
	private static PersistenceManager pm;
	
	public static void main(String[] args){
		Injector injector = Guice.createInjector(new HistorialEquiposModule());
		pm = injector.getInstance(PersistenceManager.class);
		System.out.println(pm.toString());
		
		ElementoEquipo elem1 = new Teclado();
		
		try {
			pm.registrarElemento(elem1);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception ocurried");
		}
		
	}

}
