
package dao;

import java.util.List;
import modelo.Funcionalidad;
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
public class funcionalidadDao {
    
    private List<Funcionalidad> listFuncionalidades() {
        List<Funcionalidad> listFuncionalidades = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Criteria criteria=sesion.createCriteria(Funcionalidad.class);
            listFuncionalidades=criteria.list();
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return listFuncionalidades;
    }

    public List<Funcionalidad> listarFuncionalidades() {
        List<Funcionalidad> listaRolfuncionalidades = listFuncionalidades();
        return listaRolfuncionalidades;
    }
    
    //Metodo Buscar Funcionalidades 
    private List<Funcionalidad> buscaFuncionalidades(String busqueda) {
        List<Funcionalidad> listFn = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Criteria criteria = sesion.createCriteria(Funcionalidad.class);
            Criterion restriccion1 = Restrictions.like("funId", "%" + busqueda + "%");
            Criterion restriccion2 = Restrictions.ilike("funNombre", "%" + busqueda + "%");
            Criterion restriccion3 = Restrictions.ilike("funDescripcion", "%" + busqueda + "%");
            criteria.add(Restrictions.or(restriccion1, restriccion2, restriccion3));
            listFn = criteria.list();
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return listFn;
    }

    public List<Funcionalidad> buscarFuncionalidades(String busqueda) {
        List<Funcionalidad> listFn = buscaFuncionalidades(busqueda);
        return listFn;
    }
}
