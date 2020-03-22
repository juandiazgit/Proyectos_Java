package controlador;

import dao.funcionalidadDao;
import dao.rolDao;
import dao.rolfuncionalidadDao;
import dao.usuarioDao;
import dao.usuariorolDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Funcionalidad;
import modelo.Rol;
import modelo.Rolfuncionalidad;
import modelo.Usuario;
import modelo.Usuariorol;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;

/**
 *
 * @author CIADTI2017
 */
@Named(value = "funcionalidadDualListControl")
@SessionScoped

public class funcionalidadDualListControl implements Serializable {

    private List<Funcionalidad> funcionalidades;

    private DualListModel<Funcionalidad> dualListA;
    private List<Funcionalidad> funcionalidadesDisponibles;
    private List<Funcionalidad> funcionalidadesAsignar;

    private DualListModel<Funcionalidad> dualListE;
    private List<Funcionalidad> funcionalidadesAsignadas;
    private List<Funcionalidad> funcionalidadesEliminar;

    public List<Funcionalidad> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(List<Funcionalidad> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

    public DualListModel<Funcionalidad> getDualListA() {
        return dualListA;
    }

    public void setDualListA(DualListModel<Funcionalidad> dualListA) {
        this.dualListA = dualListA;
    }

    public List<Funcionalidad> getFuncionalidadesDisponibles() {
        return funcionalidadesDisponibles;
    }

    public void setFuncionalidadesDisponibles(List<Funcionalidad> funcionalidadesDisponibles) {
        this.funcionalidadesDisponibles = funcionalidadesDisponibles;
    }

    public List<Funcionalidad> getFuncionalidadesAsignar() {
        return funcionalidadesAsignar;
    }

    public void setFuncionalidadesAsignar(List<Funcionalidad> funcionalidadesAsignar) {
        this.funcionalidadesAsignar = funcionalidadesAsignar;
    }

    public DualListModel<Funcionalidad> getDualListE() {
        return dualListE;
    }

    public void setDualListE(DualListModel<Funcionalidad> dualListE) {
        this.dualListE = dualListE;
    }

    public List<Funcionalidad> getFuncionalidadesAsignadas() {
        return funcionalidadesAsignadas;
    }

    public void setFuncionalidadesAsignadas(List<Funcionalidad> funcionalidadesAsignadas) {
        this.funcionalidadesAsignadas = funcionalidadesAsignadas;
    }

    public List<Funcionalidad> getFuncionalidadesEliminar() {
        return funcionalidadesEliminar;
    }

    public void setFuncionalidadesEliminar(List<Funcionalidad> funcionalidadesEliminar) {
        this.funcionalidadesEliminar = funcionalidadesEliminar;
    }

    public funcionalidadDualListControl() {
        funcionalidadesDisponibles = new ArrayList();
        funcionalidadesAsignar = new ArrayList();
        dualListA = new DualListModel<>(funcionalidadesDisponibles, funcionalidadesAsignar);
        funcionalidadesAsignadas = new ArrayList();
        funcionalidadesEliminar = new ArrayList();
        dualListE = new DualListModel<>(funcionalidadesAsignadas, funcionalidadesEliminar);
        funcionalidadDao funDao = new funcionalidadDao();
        funcionalidades = funDao.listarFuncionalidades();
    }

    public void funcionalidadesAsignarRol(Rol rol) {
        if (rol != null) {
            boolean todasFuncionalidadesAsignadas = false;
            funcionalidadesDisponibles = new ArrayList();
            funcionalidadesAsignar = new ArrayList();
            System.out.println("Rol: " + rol.getRolNombre());
            rolfuncionalidadDao rolfunDao = new rolfuncionalidadDao();
            List<Rolfuncionalidad> listrolfun = rolfunDao.listarFuncionalidadesDelRol(rol);
            
            FacesContext facesContex = FacesContext.getCurrentInstance();
            HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
            sesion.setAttribute("listfunxRolAsignadas", listrolfun);
            
            System.out.println("Lista de Funcionalidades del Rol: " + listrolfun);
            if (!listrolfun.isEmpty()) {                                       //funcionalidades -> lista de funcionalidades de BD
                if (listrolfun.size() < funcionalidades.size()) {              //listrolfun -> lista de funcionalidades del rol
                    for (Funcionalidad funcionalidad : funcionalidades) {
                        boolean noEsta = true;
                        for (Rolfuncionalidad rolfun : listrolfun) {
                            if (rolfun.getFuncionalidad().getFunId().equals(funcionalidad.getFunId())) {
                                noEsta = false;
                            }
                        }
                        if (noEsta) {
                            funcionalidadesDisponibles.add(funcionalidad);
                        }
                    }
                    RequestContext.getCurrentInstance().execute("mostrar()");                    
                } else if (listrolfun.size() == funcionalidades.size()) {
                    todasFuncionalidadesAsignadas = true;
                } else {
                    System.out.println("La Lista de Funcionalidades Asignadas No puede ser más grande que la Lista de Funcionalidades");
                }
            } else {
                funcionalidadesDisponibles = funcionalidades;
            }
            if (todasFuncionalidadesAsignadas) {
                RequestContext.getCurrentInstance().execute("ocultar()");
                RequestContext.getCurrentInstance().execute("mostrarNFA()");
            } else {
                sesion.setAttribute("funcionalidadesDisponibles", funcionalidadesDisponibles);
                dualListA.setTarget(funcionalidadesAsignar);
                dualListA.setSource(funcionalidadesDisponibles);
                RequestContext.getCurrentInstance().execute("ocultarNFA()");
                RequestContext.getCurrentInstance().execute("mostrar()");
            }
        } else {
            System.out.println("El Rol está Llegando Null");
        }
    }

    public void funcionalidadesEliminarRol(Rol rol) {
        if (rol != null) {
            boolean NingunaFuncionalidadDisponible = false;
            funcionalidadesAsignadas = new ArrayList();
            funcionalidadesEliminar = new ArrayList();
            System.out.println("Rol: " + rol.getRolNombre());
            rolfuncionalidadDao rolfunDao = new rolfuncionalidadDao();
            List<Rolfuncionalidad> listrolfun = rolfunDao.listarFuncionalidadesDelRol(rol);

            if (!listrolfun.isEmpty()) {
                if (listrolfun.size() < funcionalidades.size()) {               //listrolfun -> Lista las Funcionalidades del Rol
                    for (Funcionalidad funcionalidad : funcionalidades) {       //funcionalidades -> Lista las funcionalidades de BD
                        boolean Esta = false;
                        for (Rolfuncionalidad rolfun : listrolfun) {
                            if (rolfun.getFuncionalidad().getFunId().equals(funcionalidad.getFunId())) {
                                Esta = true;
                            }
                        }
                        if (Esta) {
                            funcionalidadesAsignadas.add(funcionalidad);
                        }
                    }
                    RequestContext.getCurrentInstance().execute("mostrar_e()");
                } else {
                    funcionalidadesAsignadas = funcionalidades;
                }
            } else {
                NingunaFuncionalidadDisponible = true;
                RequestContext.getCurrentInstance().execute("ocultar_e()");             
            }
            if (NingunaFuncionalidadDisponible) {
                RequestContext.getCurrentInstance().execute("ocultar_e()");
                RequestContext.getCurrentInstance().execute("mostrarNFE()");
            } else {
                FacesContext facesContex = FacesContext.getCurrentInstance();
                HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
                sesion.setAttribute("funcionalidadesAsignadas", funcionalidadesAsignadas);
                dualListE.setTarget(funcionalidadesEliminar);
                dualListE.setSource(funcionalidadesAsignadas);
                RequestContext.getCurrentInstance().execute("ocultarNFE()");
                RequestContext.getCurrentInstance().execute("mostrar_e()");
            }
        } else {
            System.out.println("El Rol está Llegando Null");
        }
    }
    
    public void reconstruirDualList(){
        funcionalidadesDisponibles = new ArrayList();
        funcionalidadesAsignar = new ArrayList();
        dualListA = new DualListModel<>(funcionalidadesDisponibles, funcionalidadesAsignar);
        funcionalidadesAsignadas = new ArrayList();
        funcionalidadesEliminar = new ArrayList();
        dualListE = new DualListModel<>(funcionalidadesAsignadas, funcionalidadesEliminar);
        funcionalidadDao funDao = new funcionalidadDao();
        funcionalidades = funDao.listarFuncionalidades();
    }
}
