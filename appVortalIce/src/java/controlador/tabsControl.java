package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
import modelo.Funcionalidad;
import modelo.Rolfuncionalidad;

/**
 *
 * @author CIADTI2017
 */
@Named(value = "tabsControl")
@SessionScoped

public class tabsControl implements Serializable {

    private List<Funcionalidad> tabs;
    private int activeIndex;

    public int getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }

    public List<Funcionalidad> getTabs() {
        return tabs;
    }

    public void setTabs(List<Funcionalidad> tabs) {
        this.tabs = tabs;
    }
    
     public tabsControl() {
        System.out.print("Construyendo Bean tabsControl... -> Constructor");
        tabs = new ArrayList<>();
        activeIndex = 0;
    }

    public Funcionalidad busFunc(String funid) {
        FacesContext facesContex = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContex.getExternalContext().getSession(false);
        List<Rolfuncionalidad> listrolfun = (List<Rolfuncionalidad>) sesion.getAttribute("listaFuncionalidades");
        Funcionalidad func = null;
        for (Rolfuncionalidad lisrf : listrolfun) {
            if (lisrf.getFuncionalidad().getFunId().equals(funid)) {
                return lisrf.getFuncionalidad();
            }
        }
        return func;
    }

    public void agregarNewTab(String funid) {
        System.out.println("agregarNewTab Id Fun: " + funid);
        Funcionalidad func = busFunc(funid);
        if (func != null) {
            System.out.println("Funcionalidad: " + func.getFunId());
            boolean titRep = false;
            if (!tabs.isEmpty()) {
                for (Funcionalidad tabTemp : tabs) {
                    if (tabTemp.getFunId().equals(func.getFunId())) {
                        titRep = true;
                        activeIndex = tabs.indexOf(tabTemp) + 1;
                    }
                }
            }
            if (!titRep) {
                tabs.add(func);
                activeIndex = tabs.size();
            } else {
                System.out.print("Repetido...  " + func.getFunId());
            }
        }else{
            System.out.print("No encontró funcionalidad " + funid);
        }
        
    }

    public void onTabCloseAction(TabCloseEvent event) {
        int index = 0;
        int indexBorrar = 0;
        String titulo = event.getTab().getTitle();
        for (Funcionalidad tabFun : tabs) {
            if (tabFun.getFunNombre().equals(titulo)) {
                tabs.remove(tabFun);
                if (indexBorrar < activeIndex) {
                    activeIndex--;
                }
                if (indexBorrar == activeIndex && activeIndex < tabs.size()) {
                    activeIndex++;
                }
            }
            index++;
        }
    }

    public void onTabChangeAction(TabChangeEvent event) {

        String titulo = event.getTab().getTitle();
        for (Funcionalidad tabTemp : tabs) {
            if (tabTemp.getFunNombre().equals(titulo)) {
                activeIndex = tabs.indexOf(tabTemp);
            }
        }
    }

    public void cargaPestana(String titulo) {
        for (Funcionalidad tabTemp : tabs) {
            if (tabTemp.getFunNombre().equals(titulo)) {
                activeIndex = tabs.indexOf(tabTemp);
            }
        }
    }

    public void limpiarTabs() {
        tabs.clear();
        activeIndex = 0;
    }
   
}
