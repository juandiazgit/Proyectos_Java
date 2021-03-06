package modelo;
// Generated 8/11/2017 03:24:52 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rol generated by hbm2java
 */
@Entity
@Table(name="rol"
    ,schema="vortal"
)
public class Rol  implements java.io.Serializable {


     private int rolId;
     private String rolNombre;
     private String rolDescripcion;
     private boolean rolActivo;
     private Date rolFecharegistro;
     private Set rolfuncionalidads = new HashSet(0);
     private Set usuariorols = new HashSet(0);

    public Rol() {
    }

	
    public Rol(int rolId, String rolNombre, String rolDescripcion, boolean rolActivo, Date rolFecharegistro) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.rolDescripcion = rolDescripcion;
        this.rolActivo = rolActivo;
        this.rolFecharegistro = rolFecharegistro;
    }
    public Rol(int rolId, String rolNombre, String rolDescripcion, boolean rolActivo, Date rolFecharegistro, Set rolfuncionalidads, Set usuariorols) {
       this.rolId = rolId;
       this.rolNombre = rolNombre;
       this.rolDescripcion = rolDescripcion;
       this.rolActivo = rolActivo;
       this.rolFecharegistro = rolFecharegistro;
       this.rolfuncionalidads = rolfuncionalidads;
       this.usuariorols = usuariorols;
    }
   
     @Id 

    
    @Column(name="rol_id", unique=true, nullable=false)
    public int getRolId() {
        return this.rolId;
    }
    
    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    
    @Column(name="rol_nombre", nullable=false, length=124)
    public String getRolNombre() {
        return this.rolNombre;
    }
    
    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    
    @Column(name="rol_descripcion", nullable=false, length=224)
    public String getRolDescripcion() {
        return this.rolDescripcion;
    }
    
    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    
    @Column(name="rol_activo", nullable=false)
    public boolean isRolActivo() {
        return this.rolActivo;
    }
    
    public void setRolActivo(boolean rolActivo) {
        this.rolActivo = rolActivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="rol_fecharegistro", nullable=false, length=22)
    public Date getRolFecharegistro() {
        return this.rolFecharegistro;
    }
    
    public void setRolFecharegistro(Date rolFecharegistro) {
        this.rolFecharegistro = rolFecharegistro;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rol")
    public Set getRolfuncionalidads() {
        return this.rolfuncionalidads;
    }
    
    public void setRolfuncionalidads(Set rolfuncionalidads) {
        this.rolfuncionalidads = rolfuncionalidads;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rol")
    public Set getUsuariorols() {
        return this.usuariorols;
    }
    
    public void setUsuariorols(Set usuariorols) {
        this.usuariorols = usuariorols;
    }




}


