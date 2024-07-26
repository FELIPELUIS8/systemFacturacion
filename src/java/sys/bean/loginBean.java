package sys.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import sys.dao.usuarioDao;
import sys.imp.UsuarioDaoimp;
import sys.model.Usuario;

@ManagedBean
@SessionScoped
public class loginBean implements Serializable {

    private static final long serialVersionUID = 1L;

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
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta = "";
        usuarioDao uDao = new UsuarioDaoimp();
        this.usuario = uDao.login(this.usuario);

        if (this.usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome@", this.usuario.getUsername());
            ruta = "/systemFacturacion/faces/Views/Bienvenido.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid username or password.");
            this.usuario = new Usuario();
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }

    // Logout action
    public String cerrarSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "/login";
    }

}
