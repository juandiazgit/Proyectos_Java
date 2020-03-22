package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import modelo.Rol;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import modelo.Usuario;
import modelo.Usuariorol;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

/**
 *
 * @author CIADTI2017
 */
public class usuariorolDao {

    private List<Usuariorol> listRolesDelUsuario(Usuario usuario) {
        List<Usuariorol> listUsuarioroles = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Criteria criteria = sesion.createCriteria(Usuariorol.class);
            Criteria rolCriteria = criteria.createCriteria("rol");
            Criteria usuarioCriteria = criteria.createCriteria("usuario");
            rolCriteria.add(Restrictions.eq("rolActivo", true));
            usuarioCriteria.add(Restrictions.eq("usuDocumento", usuario.getUsuDocumento()));
            listUsuarioroles = criteria.list();
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return listUsuarioroles;
    }

    public List<Usuariorol> listarRolesDelUsuario(Usuario usuario) {
        List<Usuariorol> listaUsuarioroles = listRolesDelUsuario(usuario);
        return listaUsuarioroles;
    }

    private Boolean asignaRolUsuario(Rol rol, Usuario usuario) {
        boolean insercion;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();        
        try {
            sesion.beginTransaction();
            Date fecharegistro = new Date();
            int maxid=0;
            String hql="SELECT MAX(usurolId) FROM Usuariorol";
            Query query = sesion.createQuery(hql);
            maxid = (int) query.uniqueResult();
            int id=maxid+1;
            if (maxid > 0) {
                Usuariorol usurol = new Usuariorol(id, rol, usuario, fecharegistro);
                sesion.save(usurol);
                sesion.getTransaction().commit();
                insercion = true;
            } else {
                insercion = false;
                System.out.println("El usurol para sacar el ID está Llegando Null en Metodo asignaRolUsuario ");
            }
        } catch (HibernateException e) {
            insercion = false;
            sesion.beginTransaction().rollback();
        }
        return insercion;
    }

    public boolean asignarRolUsuario(Rol rol, Usuario usuario) {
        return asignaRolUsuario(rol, usuario);
    }
    
    private boolean eliminaRolUsuario(Rol rol, Usuario usuario) {
        Usuariorol usurol = null;
        boolean eliminacion;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();        
        try {
            sesion.beginTransaction();
            Criteria criteria = sesion.createCriteria(Usuariorol.class);
            criteria.add(Restrictions.eq("rol.rolId", rol.getRolId()));
            criteria.add(Restrictions.eq("usuario.usuDocumento", usuario.getUsuDocumento()));
            usurol = (Usuariorol) criteria.uniqueResult();                        
            sesion.delete(usurol);
            sesion.getTransaction().commit();
            eliminacion = true;
        } catch (HibernateException e) {
            eliminacion = false;
            sesion.beginTransaction().rollback();
        }
        return eliminacion;
    }
    
    public boolean eliminarRolUsuario(Rol rol, Usuario usuario) {
        return eliminaRolUsuario(rol, usuario);
    }
}
