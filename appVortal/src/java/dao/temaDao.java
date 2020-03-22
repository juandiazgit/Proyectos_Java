package dao;

import modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Usuario
 */
public class temaDao {
    
    private boolean actualizaTemaUsuario(Usuario usuario) {
        boolean actualizacion;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(usuario);
            sesion.getTransaction().commit();
            actualizacion = true;
        } catch (HibernateException e) {
            actualizacion = false;
            sesion.beginTransaction().rollback();
        }
        return actualizacion;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        return actualizaTemaUsuario(usuario);
    }
    
}
