/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import modelo.Theme;
import controlador.ThemeService;
import dao.temaDao;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.Usuariorol;

/**
 *
 * @author Usuario
 */
//@Named(value = "themeSwitcherView")
//@SessionScoped
@ManagedBean

public class ThemeSwitcherControl implements Serializable {

    private List<Theme> themes;

    @ManagedProperty("#{themeService}")
    private ThemeService service;

    public ThemeSwitcherControl() {
    }

    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setService(ThemeService service) {
        this.service = service;
    }

    public void actualizaTema(String tema) {        
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        System.out.println("TEMA: "+tema+" del Usuario: "+usuario.getUsuNombre());
        temaDao temdao = new temaDao();
        if (usuario != null) {
            usuario.setUsuTema(tema);
            temdao.actualizarUsuario(usuario);
        }
    }
}
