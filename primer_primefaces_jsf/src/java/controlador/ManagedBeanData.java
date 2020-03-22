package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "data")
@RequestScoped

public class ManagedBeanData {
    private String nombre;   
    public ManagedBeanData() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
}
