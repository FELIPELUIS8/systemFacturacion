/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.claseAuxiliares;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class filtroUrl implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
           FacesContext facesContext = event.getFacesContext();
        //camputamos el nombre de la pagina actual
        String currentPage = facesContext.getViewRoot().getViewId();
        //creamos una variable booleana para comprovar si es la pagina login la que se campuro
        boolean isPageLogin = currentPage.lastIndexOf("login.xhtml") > -1 ? true : false;

        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        /*
         recuperamos un objeto del string que se guardo, para ello se toma de la sesion del usuario
         que se definio en el loginBean
         */
        Object usuario = session.getAttribute("usuario");
        
        if (!isPageLogin && usuario==null) {//si no es la pagina de logueo el el usuario es null, lo redigigimos a la pagina.
            NavigationHandler nHandler = facesContext.getApplication().getNavigationHandler();
            nHandler.handleNavigation(facesContext, null, "/login.xhtml");
    }
        }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
