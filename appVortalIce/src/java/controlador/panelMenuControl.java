package controlador;

import dao.rolfuncionalidadDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import modelo.Funcionalidad;
import modelo.Rol;
import modelo.Rolfuncionalidad;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
//import org.icefaces.ace.model.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
//import org.icefaces.ace.model.MenuModel;
import org.primefaces.model.menu.Submenu;

@Named(value = "panelMenuControl")
@SessionScoped
public class panelMenuControl implements Serializable {

    @Inject
    private tabsControl tabControl;

    private List<Rolfuncionalidad> listaFuncionalidades;
    private MenuModel menuModel;

    public List<Rolfuncionalidad> getListaFuncionalidades() {
        return listaFuncionalidades;
    }

    public void setListaFuncionalidades(List<Rolfuncionalidad> listaFuncionalidades) {
        this.listaFuncionalidades = listaFuncionalidades;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public tabsControl getTabsControl() {
        return tabControl;
    }

    public void setTabsControl(tabsControl tabsControl) {
        this.tabControl = tabsControl;
    }

    public panelMenuControl() {        
        crearMenu();
    }

    public List<Funcionalidad> sacaFuncRaiz() {
        List<Funcionalidad> listFunRaiz = new ArrayList<>();
        for (Rolfuncionalidad rolfun : listaFuncionalidades) {
            if (rolfun.getFuncionalidad() != null) {
                if (rolfun.getFuncionalidad().getFunPadre() == null) {
                    listFunRaiz.add(rolfun.getFuncionalidad());
                }
            }
        }
        return listFunRaiz;
    }

    public void crearMenu() {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        Rol rol = (Rol) sesion.getAttribute("rolSeleccionado");
        menuModel = new DefaultMenuModel();
        rolfuncionalidadDao rolfuncDao = new rolfuncionalidadDao();
        
//        Rol rol = new Rol(); 
//        rol.setRolId(4);
//        rol.setRolNombre("administrador");
//        rol.setRolActivo(true);
        listaFuncionalidades = rolfuncDao.listarFuncionalidadesDelRol(rol);
        sesion.setAttribute("listaFuncionalidades",listaFuncionalidades);
        System.out.println("listaFuncionalidadesDelRol : " + listaFuncionalidades);
        System.out.println(" .......... crearMenu ");
        MenuModel nuevoMenuModel = new DefaultMenuModel();
        List<Funcionalidad> listFuncRaiz = sacaFuncRaiz();
        System.out.println(" .......... listFuncRaiz --> " + listFuncRaiz);
        for (Funcionalidad funcRaizTemp : listFuncRaiz) {
            if (funcRaizTemp.isFunTerminal()) {
                System.out.println(" .......... if ");
                DefaultMenuItem item = new DefaultMenuItem();
                item.setValue(funcRaizTemp.getFunNombre());
                System.out.println(" .......... funcRaizTemp.getFuncNombre() " + item.getValue());
                menuModel.addElement(item);
            } else {
                System.out.println(" .......... else ");
                DefaultSubMenu submenu = new DefaultSubMenu();
                submenu.setLabel(funcRaizTemp.getFunNombre());
                menuModel.addElement(submenu);
                menuRecursivo(funcRaizTemp, submenu);
            }
        }
    }

    public List<Funcionalidad> sacaFuncHijas(Funcionalidad func) {
        List<Funcionalidad> listaHijas = new ArrayList<>();        
        for (Rolfuncionalidad rolfun : listaFuncionalidades) {
            if (rolfun.getFuncionalidad().getFunPadre() != null) {
                if (func.getFunId().equals(rolfun.getFuncionalidad().getFunPadre())) {
                    listaHijas.add(rolfun.getFuncionalidad());
                }
            }
        }
        System.out.println("Funcionalidad: "+func.getFunNombre());
        System.out.println("Listas de Fun Hijas: " + listaHijas);
        return listaHijas;
    }

    public DefaultSubMenu menuRecursivo(Funcionalidad func, DefaultSubMenu submenu) {
        List<Funcionalidad> listFuncHijas = sacaFuncHijas(func);
        for (Funcionalidad funcHijaTemp : listFuncHijas) {
            if (funcHijaTemp.isFunTerminal()) {
                DefaultMenuItem item = new DefaultMenuItem();
                item.setValue(funcHijaTemp.getFunNombre());
                //item.setUpdate(":formPestanas:tabViewFunc");
                item.setIcon("ui-icon-document");
                item.setStyle("color: limegreen;font-weight: bold");
                String command = String.format("#{tabsControl.agregarNewTab('%s')}", funcHijaTemp.getFunId());
                item.setCommand(command);
                submenu.addElement(item);
            } else {
                DefaultSubMenu nuevoSubmenu = new DefaultSubMenu();
                nuevoSubmenu.setLabel(funcHijaTemp.getFunNombre());
                submenu.addElement(nuevoSubmenu);
                menuRecursivo(funcHijaTemp, nuevoSubmenu);
            }
        }
        return submenu;
    }
}
