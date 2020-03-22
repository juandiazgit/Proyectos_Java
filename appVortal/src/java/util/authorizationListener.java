
package util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class authorizationListener implements PhaseListener{
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facescontext=event.getFacesContext();
        String currentPage=facescontext.getViewRoot().getViewId();
        boolean isLoginPage=(currentPage.lastIndexOf("loginVortal.xhtml") > -1);
        HttpSession sesion=(HttpSession) facescontext.getExternalContext().getSession(true);
        Object usuario=sesion.getAttribute("usuario");
        if(!isLoginPage && usuario ==null){
            NavigationHandler nh=facescontext.getApplication().getNavigationHandler();
            nh.handleNavigation(facescontext, null, "/loginVortal.xhtml");
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
