package controlador;

import dao.rolDao;
import dao.rolfuncionalidadDao;
import dao.usuariorolDao;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import modelo.Funcionalidad;
import modelo.Rol;
import modelo.Rolfuncionalidad;
import modelo.Usuario;
import modelo.Usuariorol;
import org.hibernate.Session;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;
import util.HibernateUtil;

/**
 *
 * @author CIADTI2017
 */
@Named(value = "rolfuncionalidadControl")
@SessionScoped

public class rolfuncionalidadControl implements Serializable {

    @Inject
    private funcionalidadDualListControl funControl;

    private String nombreFuncionalidadSeleccionada;
    private Funcionalidad funcionalidadSeleccionada;
    private List<Rolfuncionalidad> funcionalidadesDelRol;

    public String getNombreFuncionalidadSeleccionada() {
        return nombreFuncionalidadSeleccionada;
    }

    public void setNombreFuncionalidadSeleccionada(String nombreFuncionalidadSeleccionada) {
        this.nombreFuncionalidadSeleccionada = nombreFuncionalidadSeleccionada;
    }

    public Funcionalidad getFuncionalidadSeleccionada() {
        return funcionalidadSeleccionada;
    }

    public void setFuncionalidadSeleccionada(Funcionalidad FuncionalidadSeleccionada) {
        this.funcionalidadSeleccionada = FuncionalidadSeleccionada;
    }

    public List<Rolfuncionalidad> getFuncionalidadesDelRol() {
        return funcionalidadesDelRol;
    }

    public void setFuncionalidadesDelRol(List<Rolfuncionalidad> funcionalidadesDelRol) {
        this.funcionalidadesDelRol = funcionalidadesDelRol;
    }

    @PostConstruct
    public void rolfuncionalidadControl() {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        funcionalidadesDelRol = (List<Rolfuncionalidad>) sesion.getAttribute("listfunxRolAsignadas");
        if (funcionalidadesDelRol != null) {
            if (funcionalidadesDelRol.size() == 1) {
                funcionalidadSeleccionada = funcionalidadesDelRol.get(0).getFuncionalidad();
                sesion.setAttribute("funcionalidadSeleccionada", funcionalidadSeleccionada);
            }
        } else {
            System.out.println("Lo que trae: " + funcionalidadesDelRol);
            System.out.print("La Lista de Funcionalidad del Rol Llega Null /rolfuncionalidadControl2/rolfuncionalidadControl");
        }
    }

    public void actualizaFuncionalidadSeleccionada() {
        if (nombreFuncionalidadSeleccionada != null) {
            if (funcionalidadesDelRol != null) {
                for (Rolfuncionalidad rolfun : funcionalidadesDelRol) {
                    if (rolfun.getFuncionalidad().getFunNombre().equals(nombreFuncionalidadSeleccionada)) {
                        FacesContext facesContex = FacesContext.getCurrentInstance();
                        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
                        funcionalidadSeleccionada = rolfun.getFuncionalidad();
                        sesion.setAttribute("funcionalidadSeleccionada", funcionalidadSeleccionada);
                    }
                }
            } else {
                System.out.print("La Lista de Funcionalidades del Rol Llega Null /rolfuncionalidadControl2/actualizaFuncionalidadSeleccionada");
            }
        } else {
            System.out.print("El nombre de funcionalidadseleccionada Null ...");
        }
    }

    public void cargarInicio() throws IOException {
        ExternalContext externalContex = FacesContext.getCurrentInstance().getExternalContext();
        externalContex.redirect(externalContex.getRequestContextPath() + "/vistas/adminVortal.xhtml");
    }

    public void verificarFuncionalidadesRol(List<Funcionalidad> funcionalidades, Rol rol, int n, List<String> funcionalidadesSeleccionadas) {
        if (funcionalidades != null) {
            if (!funcionalidades.isEmpty()) {
                if (rol != null) {
                    if (n == 1) {
                        System.out.println("FUNC_SELECCIONADAS: " + funcionalidadesSeleccionadas);
                        FacesContext facesContex = FacesContext.getCurrentInstance();
                        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
                        RequestContext.getCurrentInstance().execute("PF('cdwvAsignarFuncionalidadesRol').hide()");
                        if (funcionalidadesSeleccionadas != null) {
                            if (!funcionalidadesSeleccionadas.isEmpty()) {
                                List<Funcionalidad> funcionalidadesDisponibles = (List<Funcionalidad>) sesion.getAttribute("funcionalidadesDisponibles");
                                if (funcionalidadesDisponibles != null) {
                                    List<Funcionalidad> listFuncSel = buscarFunc(funcionalidadesDisponibles, funcionalidadesSeleccionadas); 
                                    boolean sepuedeinsertar = true;
                                    for (Funcionalidad funcionalidad : listFuncSel) {
                                        System.out.println("FunPadre  de FUN a insertar: " + funcionalidad.getFunPadre());
                                        for (Funcionalidad listfunDisp : funcionalidadesDisponibles) {                                            
                                            System.out.println("FunId de FUN insertadas: " + listfunDisp.getFunId());
                                            if (funcionalidad.getFunPadre() != null && (listfunDisp.getFunId() != null)) {
                                                if (funcionalidad.getFunPadre().equals(listfunDisp.getFunId())) {
                                                    sepuedeinsertar = false;
                                                }
                                            }
                                        }
                                    }
                                    if (sepuedeinsertar) {
                                        RequestContext.getCurrentInstance().execute("PF('cdwvAsignarFuncionalidadesRol').show()");
                                    } else {
                                        RequestContext.getCurrentInstance().execute("PF('cdwvcdNoPuedeAsignarFuncionalidadesRol').show()");
                                    }
                                } else {
                                    System.out.println("Lista de Funcionalidades Disponibles está Llegando Null al Metodo verificarFuncionalidadesRol ");
                                }
                            } else {
                                System.out.println("La Lista Funcionalidades Llega Vacia al Metodo verificarFuncionalidadesRol ");
                            }
                        } else {
                            System.out.println("La Lista Funcionalidades Seleccionados Llega Null al Metodo verificarFuncionalidadesRol ");
                        }

                    } else {
                        System.out.println("FUNC_SELECCIONADAS: " + funcionalidadesSeleccionadas);
                        FacesContext facesContex = FacesContext.getCurrentInstance();
                        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
                        RequestContext.getCurrentInstance().execute("PF('cdwvEliminarFuncionalidadesRol').hide()");
                        if (funcionalidadesSeleccionadas != null) {
                            if (!funcionalidadesSeleccionadas.isEmpty()) {
                                List<Funcionalidad> funcionalidadesAsignadas = (List<Funcionalidad>) sesion.getAttribute("funcionalidadesAsignadas");
                                if (funcionalidadesAsignadas != null) {
                                    List<Funcionalidad> listFuncSel = buscarFunc(funcionalidadesAsignadas, funcionalidadesSeleccionadas);
                                    boolean sepuedeeliminar = false;
                                    for (Funcionalidad funcionalidad : listFuncSel) {
                                        System.out.println("FunPadre  de FUN a eliminar: " + funcionalidad.getFunPadre());
                                        for (Funcionalidad listfunAsig : funcionalidadesAsignadas) {                                            
                                            System.out.println("FunId de FUN insertadas: " + listfunAsig.getFunId());
                                            if (funcionalidad.getFunPadre() != null && (listfunAsig.getFunId() != null)) {
                                                if (funcionalidad.getFunPadre().equals(listfunAsig.getFunId()) || funcionalidad.getFunPadre() == null) {
                                                    sepuedeeliminar = true;
                                                }
                                            } else if(listfunAsig.getFunPadre() == null){
                                                sepuedeeliminar = true;
                                            }
                                        }
                                    }
                                    if (sepuedeeliminar) {
                                        RequestContext.getCurrentInstance().execute("PF('cdwvEliminarFuncionalidadesRol').show()");
                                    } else {
                                        RequestContext.getCurrentInstance().execute("PF('cdwvcdNoPuedeEliminarFuncionalidadesRol').show()");
                                    }
                                } else {
                                    System.out.println("Lista de Funcionalidades Asignados está Llegando Null al Metodo verificarFuncionalidadesRol ");
                                }
                            } else {
                                System.out.println("La Lista Funcionalidades Llega Vacia al Metodo verificarFuncionalidadesRol ");
                            }
                        } else {
                            System.out.println("La Lista Funcionalidades Seleccionados Llega Null al Metodo verificarFuncionalidadesRol ");
                        }                        
                    }
                } else {
                    System.out.println("El Rol Llega Null al Metodo verificarFuncionalidadesRol ");
                }
            } else {
                if (n == 1) {
                    RequestContext.getCurrentInstance().execute("PF('cdwvSeleccioneFuncionalidadesRol').show()");
                } else {
                    RequestContext.getCurrentInstance().execute("PF('cdwvSeleccioneFuncionalidadesRol_e').show()");
                }
            }
        } else {
            System.out.println("La Lista Funcionalidades Llega Null al Metodo verificarFuncionalidadesRol ");
        }
    }

    public void asignarFuncionalidadesRol(List<String> funcionalidadesSeleccionadas, Rol rol) {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        List<Funcionalidad> funcionalidadesDisponibles = (List<Funcionalidad>) sesion.getAttribute("funcionalidadesDisponibles");
        List<Funcionalidad> listFuncSel = buscarFunc(funcionalidadesDisponibles, funcionalidadesSeleccionadas);
        asignarFuncionalidadRolBloque(listFuncSel, rol);
        funControl.reconstruirDualList();
        RequestContext.getCurrentInstance().update("formPestanas:tabViewFunc:plAsignarFuncionalidades");
    }

    public void eliminarFuncionalidadesRol(List<String> funcionalidadesSeleccionadas, Rol rol) {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        List<Funcionalidad> funcionalidadesAsignadas = (List<Funcionalidad>) sesion.getAttribute("funcionalidadesAsignadas");
        List<Funcionalidad> listFuncSel = buscarFunc(funcionalidadesAsignadas, funcionalidadesSeleccionadas);
        eliminarFuncionalidadRolBloque(listFuncSel, rol);
        funControl.reconstruirDualList();
        RequestContext.getCurrentInstance().update("formPestanas:tabViewFunc:plEliminarFuncionalidades");
    }

    public List<Funcionalidad> buscarFunc(List<Funcionalidad> listFunc, List<String> listFuncString) {
        List<Funcionalidad> listFuncRes = new ArrayList<>();
        for (Funcionalidad funcionalidad : listFunc) {
            for (String funsel : listFuncString) {
                if (funcionalidad.getFunNombre().equals(funsel)) {
                    listFuncRes.add(funcionalidad);
                }
            }
        }
        return listFuncRes;
    }

    public void asignarFuncionalidadRolBloque(List<Funcionalidad> listFuncSel, Rol rol) {
        rolfuncionalidadDao rolfunDao = new rolfuncionalidadDao();
        boolean todoBien = true;
        for (Funcionalidad funcionalidad : listFuncSel) {
            if (!rolfunDao.asignarFuncionalidadRol(funcionalidad, rol)) {
                todoBien = false;
            }
        }
        if (todoBien) {
            System.out.println("La Funcionalidad "
                    + "fue Asignada al Rol " + rol.getRolNombre());
            RequestContext.getCurrentInstance().execute("PF('cdwvAsignarFuncionalidadesRol').hide()");
            RequestContext.getCurrentInstance().execute("PF('cdwvExitoAsignarFuncionalidadesRol').show()");
        } else {
            System.out.println("No se pudo Asignar la Funcionalidad "
                    + "al Rol " + rol.getRolNombre());
        }
    }

    public void eliminarFuncionalidadRolBloque(List<Funcionalidad> listFuncSel, Rol rol) {
        rolfuncionalidadDao rolfunDao = new rolfuncionalidadDao();
        boolean todoBien = true;
        for (Funcionalidad funcionalidad : listFuncSel) {
            if (!rolfunDao.eliminarFuncionalidadRol(funcionalidad, rol)) {
                todoBien = false;
            }
        }
        if (todoBien) {
            System.out.println("La Funcionalidad "
                    + "fue Eliminada al Rol " + rol.getRolNombre());
            RequestContext.getCurrentInstance().execute("PF('cdwvEliminarFuncionalidadesRol').hide()");
            RequestContext.getCurrentInstance().execute("PF('cdwvExitoEliminarFuncionalidadesRol').show()");
        } else {
            System.out.println("No se pudo Eliminar la Funcionalidad "
                    + "al Rol " + rol.getRolNombre());
        }
    }
}
