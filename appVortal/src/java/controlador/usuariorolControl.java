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

/**
 *
 * @author CIADTI2017
 */
@Named(value = "usuariorolControl")
@SessionScoped

public class usuariorolControl implements Serializable {

    private String nombreRolSeleccionado;
    private Rol rolSeleccionado;
    private List<Usuariorol> rolesDelUsuario;

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
                    if (usurol.getRol().getRolNombre().equals(nombreRolSeleccionado)) {
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

    public void verificarRolesUsuario(List<Rol> roles, Usuario usuario,int n) {
        if (roles != null) {
            if (!roles.isEmpty()) {
                if (usuario != null) {
                    if(n == 1){
                        RequestContext.getCurrentInstance().execute("PF('cdwvAsignarRolesUsuario').show()");
                    }else{
                        RequestContext.getCurrentInstance().execute("PF('cdwvEliminarRolesUsuario').show()");
                    }                    
                } else {
                    System.out.println("El Usuario Llega Null al Metodo verificarRolesUsuario ");
                }
            } else {
                if (n == 1) {
                    RequestContext.getCurrentInstance().execute("PF('cdwvSeleccioneRolesUsuario').show()");
                } else {
                    RequestContext.getCurrentInstance().execute("PF('cdwvSeleccioneRolesUsuario_e').show()");
                }                
            }
        } else {
            System.out.println("La Lista Roles Llega Null al Metodo verificarRolesUsuario ");
        }
    }

    public void asignarRolesUsuario(List<String> rolesSeleccionados, Usuario usuario) {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        RequestContext.getCurrentInstance().execute("PF('cdwvAsignarRolesUsuario').hide()");
        if (rolesSeleccionados != null) {
            if (!rolesSeleccionados.isEmpty()) {
                if (usuario != null) {
                    usuariorolDao usurolDao = new usuariorolDao();
                    List<Rol> rolesDisponibles = (List<Rol>) sesion.getAttribute("rolesDisponibles");
                    if (rolesDisponibles != null) {
                        for (Rol rol : rolesDisponibles) {
                            for (String rolsel : rolesSeleccionados) {
                                if (rol.getRolNombre().equals(rolsel)) {
                                    if (usurolDao.asignarRolUsuario(rol, usuario)) {
                                        System.out.println("El Rol " + rol.getRolNombre() + " "
                                                + "fue Asignado al Usuario " + usuario.getUsuNombre());
                                        RequestContext.getCurrentInstance().execute("PF('cdwvExitoAsignarRolesUsuario').show()");                                        
                                    } else {
                                        System.out.println("No se pudo Asignar el Rol " + rol.getRolNombre() + " "
                                                + "al Usuario " + usuario.getUsuNombre());
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Lista de Roles Disponibles está Llegando Null al Metodo asignarRolesUsuario ");
                    }
                } else {
                    System.out.println("El Usuario Llega Null al Metodo AsignarRolesUsuario ");
                }
            } else {
                System.out.println("La Lista Roles Llega Vacia al Metodo AsignarRolesUsuario ");
            }
        } else {
            System.out.println("La Lista Roles Seleccionados Llega Null al Metodo AsignarRolesUsuario ");
        }
    }
    
    public void eliminarRolesUsuario(List<String> rolesSeleccionados, Usuario usuario) {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        RequestContext.getCurrentInstance().execute("PF('cdwvEliminarRolesUsuario').hide()");
        if (rolesSeleccionados != null) {
            if (!rolesSeleccionados.isEmpty()) {
                if (usuario != null) {
                    usuariorolDao usurolDao = new usuariorolDao();
                    List<Rol> rolesAsignados = (List<Rol>) sesion.getAttribute("rolesAsignados");                    
                    if (rolesAsignados != null) {
                        for (Rol rolasig : rolesAsignados) {
                            for (String rolsel : rolesSeleccionados) {
                                if (rolasig.getRolNombre().equals(rolsel)) {
                                    if (usurolDao.eliminarRolUsuario(rolasig, usuario)) {
                                        System.out.println("El Rol " + rolasig.getRolNombre() + " "
                                                + "fue Eliminado al Usuario " + usuario.getUsuNombre());
                                        RequestContext.getCurrentInstance().execute("PF('cdwvExitoEliminarRolesUsuario').show()");                                        
                                    } else {
                                        System.out.println("No se pudo Eliminar el Rol " + rolasig.getRolNombre() + " "
                                                + "al Usuario " + usuario.getUsuNombre());
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Lista de Roles Asignados está Llegando Null al Metodo eliminarRolesUsuario ");
                    }
                } else {
                    System.out.println("El Usuario Llega Null al Metodo eliminarRolesUsuario ");
                }
            } else {
                System.out.println("La Lista Roles Llega Vacia al Metodo eliminarRolesUsuario ");
            }
        } else {
            System.out.println("La Lista Roles Seleccionados Llega Null al Metodo eliminarRolesUsuario ");
        }
    }
}
