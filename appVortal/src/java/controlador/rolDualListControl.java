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
import org.primefaces.model.DualListModel;

/**
 *
 * @author CIADTI2017
 */
@Named(value = "rolDualListControl")
@SessionScoped

public class rolDualListControl implements Serializable {

    private List<Rol> roles;
    
    private DualListModel<Rol> dualListA;
    private List<Rol> rolesDisponibles;
    private List<Rol> rolesAsignar;
    
    private DualListModel<Rol> dualListE;
    private List<Rol> rolesAsignados;
    private List<Rol> rolesEliminar;
    
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public DualListModel<Rol> getDualListA() {
        return dualListA;
    }

    public void setDualListA(DualListModel<Rol> dualListA) {
        this.dualListA = dualListA;
    }

    public List<Rol> getRolesDisponibles() {
        return rolesDisponibles;
    }

    public void setRolesDisponibles(List<Rol> rolesDisponibles) {
        this.rolesDisponibles = rolesDisponibles;
    }

    public List<Rol> getRolesAsignar() {
        return rolesAsignar;
    }

    public void setRolesAsignar(List<Rol> rolesAsignar) {
        this.rolesAsignar = rolesAsignar;
    }

    public DualListModel<Rol> getDualListE() {
        return dualListE;
    }

    public void setDualListE(DualListModel<Rol> dualListE) {
        this.dualListE = dualListE;
    }

    public List<Rol> getRolesAsignados() {
        return rolesAsignados;
    }

    public void setRolesAsignados(List<Rol> rolesAsignados) {
        this.rolesAsignados = rolesAsignados;
    }

    public List<Rol> getRolesEliminar() {
        return rolesEliminar;
    }

    public void setRolesEliminar(List<Rol> rolesEliminar) {
        this.rolesEliminar = rolesEliminar;
    }

    public rolDualListControl() {
        rolesDisponibles = new ArrayList();
        rolesAsignar = new ArrayList();
        dualListA = new DualListModel<>(rolesDisponibles, rolesAsignar);
        rolesAsignados = new ArrayList();
        rolesEliminar = new ArrayList();
        dualListE = new DualListModel<>(rolesAsignados, rolesEliminar);
        rolDao rlDao = new rolDao();
        roles = rlDao.listarRoles();
    }

    public void rolesAsignarUsuario(Usuario usuario) {
        if (usuario != null) {
            boolean todosRolesAsignados = false;
            rolesDisponibles = new ArrayList();
            rolesAsignar = new ArrayList();
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
                RequestContext.getCurrentInstance().execute("ocultar()");                
                RequestContext.getCurrentInstance().execute("mostrarNRA()");
            } else {
                FacesContext facesContex = FacesContext.getCurrentInstance();
                HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
                sesion.setAttribute("rolesDisponibles", rolesDisponibles);
                dualListA.setTarget(rolesAsignar);
                dualListA.setSource(rolesDisponibles);
                RequestContext.getCurrentInstance().execute("ocultarNRA()");
                RequestContext.getCurrentInstance().execute("mostrar()");
            }
        } else {
            System.out.println("El Usuario está Llegando Null");
        }
    }

    public void rolesEliminarUsuario(Usuario usuario) {
        if (usuario != null) {
            boolean NingunRolDisponible = false;
            rolesAsignados = new ArrayList();
            rolesEliminar = new ArrayList();
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
                        if (!noEsta) {
                            rolesAsignados.add(rol);
                        }
                    }
                    RequestContext.getCurrentInstance().execute("mostrar_e()");
                } else {
                    rolesAsignados = roles;
                }
            } else {
                NingunRolDisponible = true;
                RequestContext.getCurrentInstance().execute("ocultar_e()");
            }
            if (NingunRolDisponible) {
                RequestContext.getCurrentInstance().execute("ocultar_e()");
                RequestContext.getCurrentInstance().execute("mostrarNRE()");
            } else {
                FacesContext facesContex = FacesContext.getCurrentInstance();
                HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
                sesion.setAttribute("rolesAsignados", rolesAsignados);
                dualListE.setTarget(rolesEliminar);
                dualListE.setSource(rolesAsignados);
                RequestContext.getCurrentInstance().execute("ocultarNRE()");
                RequestContext.getCurrentInstance().execute("mostrar_e()");
            }
        } else {
            System.out.println("El Usuario está Llegando Null");
        }
    }

}
