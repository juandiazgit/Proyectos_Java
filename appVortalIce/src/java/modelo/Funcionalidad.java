package modelo;
// Generated 8/11/2017 03:24:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Funcionalidad generated by hbm2java
 */
@Entity
@Table(name="funcionalidad"
    ,schema="vortal"
)
public class Funcionalidad  implements java.io.Serializable {


     private String funId;
     private String funNombre;
     private String funDescripcion;
     private boolean funActiva;
     private String funUrl;
     private String funPadre;
     private boolean funTerminal;
     private Set rolfuncionalidads = new HashSet(0);

    public Funcionalidad() {
    }

	
    public Funcionalidad(String funId, String funNombre, String funDescripcion, boolean funActiva, boolean funTerminal) {
        this.funId = funId;
        this.funNombre = funNombre;
        this.funDescripcion = funDescripcion;
        this.funActiva = funActiva;
        this.funTerminal = funTerminal;
    }
    public Funcionalidad(String funId, String funNombre, String funDescripcion, boolean funActiva, String funUrl, String funPadre, boolean funTerminal, Set rolfuncionalidads) {
       this.funId = funId;
       this.funNombre = funNombre;
       this.funDescripcion = funDescripcion;
       this.funActiva = funActiva;
       this.funUrl = funUrl;
       this.funPadre = funPadre;
       this.funTerminal = funTerminal;
       this.rolfuncionalidads = rolfuncionalidads;
    }
   
     @Id 

    
    @Column(name="fun_id", unique=true, nullable=false, length=24)
    public String getFunId() {
        return this.funId;
    }
    
    public void setFunId(String funId) {
        this.funId = funId;
    }

    
    @Column(name="fun_nombre", nullable=false, length=124)
    public String getFunNombre() {
        return this.funNombre;
    }
    
    public void setFunNombre(String funNombre) {
        this.funNombre = funNombre;
    }

    
    @Column(name="fun_descripcion", nullable=false, length=224)
    public String getFunDescripcion() {
        return this.funDescripcion;
    }
    
    public void setFunDescripcion(String funDescripcion) {
        this.funDescripcion = funDescripcion;
    }

    
    @Column(name="fun_activa", nullable=false)
    public boolean isFunActiva() {
        return this.funActiva;
    }
    
    public void setFunActiva(boolean funActiva) {
        this.funActiva = funActiva;
    }

    
    @Column(name="fun_url", length=224)
    public String getFunUrl() {
        return this.funUrl;
    }
    
    public void setFunUrl(String funUrl) {
        this.funUrl = funUrl;
    }

    
    @Column(name="fun_padre", length=24)
    public String getFunPadre() {
        return this.funPadre;
    }
    
    public void setFunPadre(String funPadre) {
        this.funPadre = funPadre;
    }

    
    @Column(name="fun_terminal", nullable=false)
    public boolean isFunTerminal() {
        return this.funTerminal;
    }
    
    public void setFunTerminal(boolean funTerminal) {
        this.funTerminal = funTerminal;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="funcionalidad")
    public Set getRolfuncionalidads() {
        return this.rolfuncionalidads;
    }
    
    public void setRolfuncionalidads(Set rolfuncionalidads) {
        this.rolfuncionalidads = rolfuncionalidads;
    }




}


