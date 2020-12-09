package edu.eci.cvds.test;

import static org.junit.jupiter.api.Assertions.*;

import edu.eci.cvds.managedbeans.NovedadServices;
import edu.eci.cvds.managedbeans.registrarElemento;
import edu.eci.cvds.managedbeans.registrarEquipo;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;

import org.junit.jupiter.api.Test;

public class Tests {
    
	private registrarElemento elementoS;
	private registrarEquipo equipoS;
	private NovedadServices novedadS;
	private UsuarioServices usuarioS;
	
	@Test
	public void deberiaRegistrarUnNuevoUsuario(){
		Usuario user=new Usuario("Alfonso","Pumarejo","alfonsomejo@gmail.com");
		try {
			usuarioS.registrarUsuario(user);
		}
		catch(Exception ex) {
			System.out.println("No se pudó registar");
		}
	@Test	
	public void elUsuariodeberiaEstarRegistrado(){
		Usuario user = usuarioS.consultarUsuario("alfonsomejo@gmail.com");
		try {
			assertNotNull(user);
		}
		catch(Exception ex) {
			System.out.println("El usuario no se registro");
		}
			
		}
	@Test	
	public void deberiaRegistarEquipo(){
		qt().forAll(Generators.equipo()).check(equipo->
		{
		try {
			equipoS.registrarEquipo(equipo);
		}
		catch(Exception ex) {
			System.out.println("El equipo no se pudo registrar");
		}
			
		});
	
	}
	
	@Test	
	public void deberiaRegistarElemento(){
		qt().forAll(Generators.elemento()).check(elemento->
		{
		try {
			elementoS.registrarElemento(elemento);
		}
		catch(Exception ex) {
			System.out.println("El elemento no se pudo registrar");
		}
			
		});
	
	}
	

}
