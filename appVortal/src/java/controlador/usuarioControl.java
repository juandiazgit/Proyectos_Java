package controlador;

import dao.usuarioDao;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Usuario;

/**
 *
 * @author CIADTI2017
 */
@Named(value = "usuarioControl")
@SessionScoped

public class usuarioControl implements Serializable {

    private List<Usuario> listaUsuarios;
    private Usuario usuarioSeleccionado;
    private String busqueda;

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public usuarioControl() {
        listarUsuarios();
    }

    public void buscarUsuarios() {
        usuarioDao usuDao = new usuarioDao();
        if (!busqueda.equals("") && !busqueda.equals(" ") && !busqueda.equals("  ")) {
            listaUsuarios = usuDao.buscarUsuarios(busqueda);
        }
    }
    
    public void listarUsuarios(){
        usuarioDao usuDao = new usuarioDao();
        listaUsuarios = usuDao.listarUsuarios();
    }       
}
