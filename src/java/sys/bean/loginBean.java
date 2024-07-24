package sys.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import sys.dao.usuarioDao;
import sys.imp.UsuarioDaoimp;
import sys.model.Usuario;

@ManagedBean
@SessionScoped
public class loginBean {

    private Usuario usuario;
    private String username;
    private String password;

    public loginBean() {
        this.usuario = new Usuario();
    }

    // Getters and setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Login action
    // Login action
    public void login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedln = false;
        String ruta = "";
        usuarioDao uDao = new UsuarioDaoimp();
        this.usuario = uDao.login(this.usuario);

        if (this.usuario != null) {
            loggedln = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success welcome", this.usuario.getUsername());
            ruta = "/systemFacturacion/faces/Views/Bienvenido.xhtml";
        } else {
            // Failed login logic
            message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Acesso", "Username o Password son incorrecto.");
            this.usuario = new Usuario();
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedln", loggedln);
        context.addCallbackParam("ruta", ruta);
    }

    // metodo para cerrar la session

    public String cerrarSession() {
        this.username = null;
        this.password = null;

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();// para borrar la session
        return "login";
    }

}
