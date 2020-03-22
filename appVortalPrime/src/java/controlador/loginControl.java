package controlador;

import dao.usuarioDao;
import dao.usuariorolDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import modelo.Usuario;

/**
 *
 * @author CIADTI2017
 */
@Named(value = "loginControl")
@SessionScoped
public class loginControl implements Serializable {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public loginControl() {
        usuario = new Usuario();
        //usuario.setUsuUsuario("admin");
        //usuario.setUsuClave("admin");
    }

    public void autenticar() {
        RequestContext context = RequestContext.getCurrentInstance();
        try {

            usuarioDao usuDao = new usuarioDao();
            usuario = usuDao.login(usuario);
            if (usuario != null) {
                usuariorolDao usurolDao = new usuariorolDao();
                List usuroles = usurolDao.listarRolesDelUsuario(usuario);
                if (!usuroles.isEmpty()) {                    
                    ExternalContext externalContex = FacesContext.getCurrentInstance().getExternalContext();
                    externalContex.getSessionMap().put("usuario", usuario);
                    HttpSession sesion = (HttpSession) externalContex.getSession(false);
                    sesion.setAttribute("listaRolesDeUsuario", usuroles);
                    if (usuroles.size() == 1) {
                        externalContex.redirect(externalContex.getRequestContextPath() + "/vistas/adminVortal.xhtml");
                    } else {
                        externalContex.redirect(externalContex.getRequestContextPath() + "/vistas/seleccionarRol.xhtml");
                    }
                } else {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR",
                            "No puede Iniciar Sesión, su Usuario No tiene Roles Asignados");
                    FacesContext.getCurrentInstance().addMessage(null, msg);

                    usuario = new Usuario();
                }
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Usuario y/o Contraseña Incorrectos");
                FacesContext.getCurrentInstance().addMessage(null, msg);          

                usuario = new Usuario();
            }
        } catch (Exception e) {

        }
    }

    public void cerrarSesion() {
        try {
            ExternalContext externalContex = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession sesion = (HttpSession) externalContex.getSession(false);
            externalContex.getSessionMap().clear();
            sesion.invalidate();
            externalContex.invalidateSession();
            externalContex.redirect(externalContex.getRequestContextPath() + "/loginVortal.xhtml");
        } catch (Exception e) {

        }
    }
}
