package edu.eci.cvds.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
//import edu.eci.cvds.samples.entities.Novedad;
//import edu.eci.cvds.services.ServicesException;
//import edu.eci.cvds.samples.services.NovedadServices;



@ManagedBean(name = "NovedadBean")
@SessionScoped 
public class NovedadBean extends BasePageBean  {

/*	@Inject
    private NovedadServices novedadS;
	
    private Novedad novedadEquipo;
	private Novedad novedadElemento;


    public AgregarNovedadEquipo(){
    	novedadEquipo= new Novedad();
    }

    public Novedad getNovedadEquipo() {
        return novedadEquipo;
    }

    public void setNovedadEquipo(Novedad novedadEquipo) {
        this.novedadEquipo = novedadEquipo;
    }

    public void registrarNovedadEquipo() {
        
            novedadS.registrarNovedadEquipo(novedadEquipo);
       
    }
	public AgregarNovedadElemento(){
    	novedadElemento= new Novedad();
    }

    public Novedad getNovedadElemento() {
        return novedadElemento;
    }

    public void setNovedadElemento(Novedad novedadElemento) {
        this.novedadElemento = novedadElemento;
    }

    public void registrarNovedadElemento() {
        
            novedadS.registrarNovedadElemento(novedadElemento);
       
    }
*/
}