
package dao;

import java.util.List;
import modelo.Rol;
import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author CIADTI2017
 */
public class rolDao {
    
    private List<Rol> listRoles() {
        List<Rol> listRoles = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Criteria criteria=sesion.createCriteria(Rol.class);
            listRoles=criteria.list();
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return listRoles;
    }

    public List<Rol> listarRoles() {
        List<Rol> listaUsuarioroles = listRoles();
        return listaUsuarioroles;
    }
    
    //Metodo Buscar Roles 
    private List<Rol> buscaRoles(String busqueda) {
        List<Rol> listRl = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Criteria criteria = sesion.createCriteria(Rol.class);
            Criterion restriccion1 = Restrictions.ilike("rolNombre", "%" + busqueda + "%");
            Criterion restriccion2 = Restrictions.ilike("rolDescripcion", "%" + busqueda + "%");
            criteria.add(Restrictions.or(restriccion1, restriccion2));
            listRl = criteria.list();
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return listRl;
    }

    public List<Rol> buscarRoles(String busqueda) {
        List<Rol> listRl = buscaRoles(busqueda);
        return listRl;
    }
}
