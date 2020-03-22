/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.rolDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import modelo.Rol;

/**
 *
 * @author Ordenador
 */
@Named(value = "rolControl")
@SessionScoped
public class rolControl implements Serializable {

    private List<Rol> listaRoles;
    private Rol rolSeleccionado;
    private String busqueda;

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }
    
    public rolControl() {
        listarRoles();
    }

    public void buscarRoles() {
        rolDao rlDao = new rolDao();
        if (!busqueda.equals("") && !busqueda.equals(" ") && !busqueda.equals("  ")) {
            listaRoles = rlDao.buscarRoles(busqueda);
        }
    }
    
    public void listarRoles(){
        rolDao rlDao = new rolDao();
        listaRoles = rlDao.listarRoles();
    }
}
