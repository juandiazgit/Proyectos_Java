package controlador;

import dao.rolDao;
import dao.usuariorolDao;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Rol;
import modelo.Usuario;
import modelo.Usuariorol;
import org.primefaces.context.RequestContext;
//import org.icefaces.ace.context.RequestContext;

/**
 *
 * @author CIADTI2017
 */
@Named(value = "usuariorolControl")
@SessionScoped

public class usuariorolControl implements Serializable {

    private List<Usuariorol> rolesasig;
    private String nombreRolSeleccionado;
    private Rol rolSeleccionado;
    private List<Usuariorol> rolesDelUsuario;
    private int asignados;
    private int eliminados;

    public List<Usuariorol> getRolesDelUsuario() {
        return rolesDelUsuario;
    }

    public void setRolesDelUsuario(List<Usuariorol> rolesDelUsuario) {
        this.rolesDelUsuario = rolesDelUsuario;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public String getNombreRolSeleccionado() {
        return nombreRolSeleccionado;
    }

    public void setNombreRolSeleccionado(String nombreRolSeleccionado) {
        this.nombreRolSeleccionado = nombreRolSeleccionado;
    }

    public List<Usuariorol> getRolesasig() {
        return rolesasig;
    }

    public void setRolesasig(List<Usuariorol> rolesasig) {
        this.rolesasig = rolesasig;
    }

    public int getAsignados() {
        return asignados;
    }

    public void setAsignados(int asignados) {
        this.asignados = asignados;
    }

    public int getEliminados() {
        return eliminados;
    }

    public void setEliminados(int eliminados) {
        this.eliminados = eliminados;
    }
        

    @PostConstruct
    public void usuariorolControl() {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        rolesDelUsuario = (List<Usuariorol>) sesion.getAttribute("listaRolesDeUsuario");
        if (rolesDelUsuario != null) {
            if (rolesDelUsuario.size() == 1) {
                rolSeleccionado = rolesDelUsuario.get(0).getRol();
                sesion.setAttribute("rolSeleccionado", rolSeleccionado);
            }
        } else {
            System.out.print("La Lista de Rol del Usuario llega Null ...");
        }
    }

    public void actualizaRolSeleccionado() {
        if (nombreRolSeleccionado != null) {
            if (rolesDelUsuario != null) {
                for (Usuariorol usurol : rolesDelUsuario) {
                    if (usurol.getRol().getRolNombre().equals("administrador")) {
                        FacesContext facesContex = FacesContext.getCurrentInstance();
                        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
                        rolSeleccionado = usurol.getRol();
                        sesion.setAttribute("rolSeleccionado", rolSeleccionado);
                    }
                }
            } else {
                System.out.print("La Lista de Roles del Usuario llega Null ...");
            }
        } else {
            System.out.print("rolseleccionado Null ...");
        }
    }

    public void cargarInicio() throws IOException {
        ExternalContext externalContex = FacesContext.getCurrentInstance().getExternalContext();
        externalContex.redirect(externalContex.getRequestContextPath() + "/vistas/adminVortal.xhtml");
    }

    public void verificarRolesUsuario(List<Rol> source, List<Rol> target, Usuario usuario) {
        if (source != null && target != null) {
                if (usuario != null) {
                        RequestContext.getCurrentInstance().execute("PF('cdwvAsignarRolesUsuario').show()");
                } else {
                    System.out.println("El Usuario Llega Null al Metodo verificarRolesUsuario ");
                }
            } else {
                    RequestContext.getCurrentInstance().execute("PF('cdwvSeleccioneRolesUsuario').show()");
            }
    }

    public void asignarEliminarRolesUsuario(List<String> sourceString, List<String> targetString, Usuario usuario) {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        RequestContext.getCurrentInstance().execute("PF('cdwvAsignarRolesUsuario').hide()");
        
        if (sourceString != null && targetString != null) {
                if (usuario != null) {
                    usuariorolDao usurolDao = new usuariorolDao();
                    List<Rol> rolesDisponibles = (List<Rol>) sesion.getAttribute("rolesDisponibles");
                    List<Rol> rolesAsignados = (List<Rol>) sesion.getAttribute("rolesAsignados");
                    if (rolesDisponibles != null) {
                        asignados=0;
                        eliminados=0;
                        for (Rol rol : rolesDisponibles) {
                            for (String rolsel : targetString) {
                                if (rol.getRolNombre().equals(rolsel)) {
                                    if (usurolDao.asignarRolUsuario(rol, usuario)) {
                                        asignados++;
                                        System.out.println("El Rol " + rol.getRolNombre() + " "
                                                + "fue Asignado al Usuario " + usuario.getUsuNombre());
                                    } else {
                                        System.out.println("No se pudo Asignar el Rol " + rol.getRolNombre() + " "
                                                + "al Usuario " + usuario.getUsuNombre());
                                    }
                                }
                            }
                        }
                        for (Rol rol : rolesAsignados) {
                            for (String rolsel : sourceString) {
                                if ( rol.getRolNombre().equals(rolsel)) {
                                    if (usurolDao.eliminarRolUsuario(rol, usuario)) {
                                        eliminados++;
                                        System.out.println("El Rol " + rol.getRolNombre() + " "
                                                + "fue eliminado al Usuario " + usuario.getUsuNombre());                                                                               
                                    } else {
                                        System.out.println("No se pudo eliminar el Rol " + rol.getRolNombre() + " "
                                                + "al Usuario " + usuario.getUsuNombre());
                                    }
                                }
                            }
                        }
                        RequestContext.getCurrentInstance().update("formPestanas:tabViewFunc:cdExitoAsignarEliminarRolesUsuario");
                        RequestContext.getCurrentInstance().execute("PF('cdwvExitoAsignarEliminarRolesUsuario').show()");
                    } else {
                        System.out.println("Lista de Roles Disponibles está Llegando Null al Metodo asignarRolesUsuario ");
                    }
                } else {
                    System.out.println("El Usuario Llega Null al Metodo AsignarRolesUsuario ");
                }
            } else {
                System.out.println("La Lista Roles Llega Vacia al Metodo AsignarRolesUsuario ");
            }

    }

}
