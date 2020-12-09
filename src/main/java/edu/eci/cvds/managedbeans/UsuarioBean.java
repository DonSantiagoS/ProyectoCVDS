package edu.eci.cvds.managedbeans;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.mgt.SecurityManager;
import javax.faces.application.FacesMessage;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;





@ManagedBean(name = "iniciar sesion bean")
@SessionScoped
public class UsuarioBean extends BasePageBean implements Serializable {
    private String usuario,clave;
	
	public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    } 

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public void iniciarSesion(){
       
//        Subject usuarioactual = SecurityUtils.getSubject();              
//        UsernamePasswordToken token = new UsernamePasswordToken(usuario, clave);             
//        try{            
//            usuarioactual.login(token);    
//            FacesContext.getCurrentInstance().getExternalContext().redirect("Login and Registrer/index.xhtml");
//        }catch(AuthenticationException ax){
//           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos Incorrectos", ""));
//        } catch (IOException ex) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fallo", ""));
//        }
        
        
    }
     
}