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
    
    private DualListModel<Rol> dualListAE;
    private List<Rol> rolesDisponibles;
    private List<Rol> rolesAsignados;    
    
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
        rolesDisponibles = new ArrayList();
        rolesAsignados = new ArrayList();
        Rol rol1 =new Rol();
        rol1.setRolId(1);
        rol1.setRolNombre("estudiante");
        rolesAsignados.add(rol1);
//        rolesDisponibles.add(rol);
        Rol rol2 =new Rol();
        rol2.setRolId(2);
        rol2.setRolNombre("docente");
        rolesAsignados.add(rol2);
        Rol rol3 =new Rol();
        rol3.setRolId(3);
        rol3.setRolNombre("administrativo");
        rolesAsignados.add(rol3);
        Rol rol4 =new Rol();
        rol4.setRolId(4);
        rol4.setRolNombre("administrador");
        rolesAsignados.add(rol4);
//        rolesDisponibles.add(rol2);
        System.out.println("::> rolesAsignados ::> "+rolesAsignados);
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
                        }else{
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
                System.out.println("todos asignados"+rolesAsignados.size()+" tolres bd"+roles.size());
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
