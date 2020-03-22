package controlador;

import dao.rolDao;
import dao.usuarioDao;
import dao.usuariorolDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Rol;
import modelo.Usuario;
import modelo.Usuariorol;
import org.primefaces.context.RequestContext;
//import org.icefaces.ace.context.RequestContext;
import org.primefaces.model.DualListModel;
//import org.icefaces.ace.model.SimpleEntry;

/**
 *
 * @author CIADTI2017
 */
@Named(value = "rolDualListControl")
@SessionScoped

public class rolDualListControl implements Serializable {

    private List<Rol> roles;

    private DualListModel<Rol> dualListAE;
    private List<Rol> rolesDisponibles;
    private List<Rol> rolesAsignados;
    private List<String> rolesDisponiblesStr;
    private List<String> rolesAsignadosStr;

    public List<String> getRolesDisponiblesStr() {
        return rolesDisponiblesStr;
    }

    public void setRolesDisponiblesStr(List<String> rolesDisponiblesStr) {
        this.rolesDisponiblesStr = rolesDisponiblesStr;
    }

    public List<String> getRolesAsignadosStr() {
        return rolesAsignadosStr;
    }

    public void setRolesAsignadosStr(List<String> rolesAsignadosStr) {
        this.rolesAsignadosStr = rolesAsignadosStr;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public DualListModel<Rol> getDualListAE() {
        return dualListAE;
    }

    public void setDualListAE(DualListModel<Rol> dualListAE) {
        this.dualListAE = dualListAE;
    }

    public List<Rol> getRolesDisponibles() {
        return rolesDisponibles;
    }

    public void setRolesDisponibles(List<Rol> rolesDisponibles) {
        this.rolesDisponibles = rolesDisponibles;
    }

    public List<Rol> getRolesAsignados() {
        return rolesAsignados;
    }

    public void setRolesAsignados(List<Rol> rolesAsignados) {
        this.rolesAsignados = rolesAsignados;
    }

    public rolDualListControl() {
        rolesAsignadosStr = new ArrayList();
        rolesDisponiblesStr = new ArrayList();
        
        rolesAsignadosStr.add("estudiante");
        rolesAsignadosStr.add("docente");        
        
        rolesDisponiblesStr.add("administrativo");
        rolesDisponiblesStr.add("administrador");        
        
        rolesDisponibles = new ArrayList();
        rolesAsignados = new ArrayList();
        dualListAE = new DualListModel<>(rolesDisponibles, rolesAsignados);
        rolDao rlDao = new rolDao();
        roles = rlDao.listarRoles();
    }

    public void rolesAsignarEliminarUsuario(Usuario usuario) {
        if (usuario != null) {
            boolean todosRolesAsignados = false;
            rolesDisponibles = new ArrayList();
            rolesAsignados = new ArrayList();
            System.out.println("Usuario: " + usuario.getUsuNombre());
            usuariorolDao usurolDao = new usuariorolDao();
            List<Usuariorol> listusuroles = usurolDao.listarRolesDelUsuario(usuario);

            if (!listusuroles.isEmpty()) {
                if (listusuroles.size() < roles.size()) {
                    for (Rol rol : roles) {
                        boolean noEsta = true;
                        for (Usuariorol usurol : listusuroles) {
                            if (usurol.getRol().getRolId() == rol.getRolId()) {
                                noEsta = false;
                            }
                        }
                        if (noEsta) {
                            rolesDisponibles.add(rol);
                        } else {
                            rolesAsignados.add(rol);
                        }
                    }
                    RequestContext.getCurrentInstance().execute("mostrar()");
                } else if (listusuroles.size() == roles.size()) {
                    todosRolesAsignados = true;
                } else {
                    System.out.println("La Lista de Roles Asignados No puede ser más grande que la Lista de Roles");
                }
            } else {
                rolesDisponibles = roles;
            }
            if (todosRolesAsignados) {
                rolesAsignados = roles;
                System.out.println("todos asignados" + rolesAsignados.size() + " tolres bd" + roles.size());
                RequestContext.getCurrentInstance().execute("mostrar()");
            }
            FacesContext facesContex = FacesContext.getCurrentInstance();
            HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
            sesion.setAttribute("rolesDisponibles", rolesDisponibles);
            sesion.setAttribute("rolesAsignados", rolesAsignados);
            dualListAE.setTarget(rolesAsignados);
            dualListAE.setSource(rolesDisponibles);
            RequestContext.getCurrentInstance().execute("mostrar()");
        } else {
            System.out.println("El Usuario está Llegando Null");
        }
    }

}
