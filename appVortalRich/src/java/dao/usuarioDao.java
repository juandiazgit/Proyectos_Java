package dao;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;
import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CIADTI2017
 */
public class usuarioDao {

    private Usuario validaLogin(Usuario usuario) {
        Usuario modelo = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Criteria criteria = sesion.createCriteria(Usuario.class);
            criteria.add(Restrictions.eq("usuUsuario", usuario.getUsuUsuario()));
            criteria.add(Restrictions.eq("usuClave", usuario.getUsuClave()));
            modelo = (Usuario) criteria.uniqueResult();
            sesion.getTransaction().commit();            
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return modelo;
    }

    public Usuario login(Usuario usuario) {
        Usuario modelo = validaLogin(usuario);
        return modelo;
    }

    //Metodo de Listar Usuarios 
    private List<Usuario> listUsuarios() {
        List<Usuario> listUsu = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "FROM Usuario";
        try {
            sesion.beginTransaction();
            listUsu = sesion.createQuery(hql).list();
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return listUsu;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> listUsu = listUsuarios();
        return listUsu;        
    }    

    //Metodo Buscar Usuarios 
    private List<Usuario> buscaUsuarios(String busqueda) {
        List<Usuario> listUsu = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Criteria criteria = sesion.createCriteria(Usuario.class);
            Criterion restriccion1 = Restrictions.like("usuDocumento", "%" + busqueda + "%");
            Criterion restriccion2 = Restrictions.ilike("usuNombre", "%" + busqueda + "%");
            Criterion restriccion3 = Restrictions.ilike("usuUsuario", "%" + busqueda + "%");
            criteria.add(Restrictions.or(restriccion1, restriccion2, restriccion3));
            listUsu = criteria.list();
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return listUsu;
    }

    public List<Usuario> buscarUsuarios(String busqueda) {
        List<Usuario> listUsu = buscaUsuarios(busqueda);
        return listUsu;
    }

    //Metodo para Agregar Usuario
    private boolean agregaUsuario(Usuario usuario) {
        boolean insercion;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(usuario);
            sesion.getTransaction().commit();
            insercion = true;
        } catch (HibernateException e) {
            insercion = false;
            sesion.beginTransaction().rollback();
        }
        return insercion;
    }

    public boolean agregarUsuario(Usuario usuario) {
        return agregaUsuario(usuario);
    }

    //Metodo para Actualizar Usuario
    private boolean actualizaUsuario(Usuario usuario) {
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
        return actualizaUsuario(usuario);
    }

    //Metodo para Eliminar un Usuario
    private boolean eliminaUsuario(BigDecimal id) {
        boolean eliminacion;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Usuario usuario = (Usuario) sesion.load(Usuario.class, id);
            sesion.delete(id);
            sesion.getTransaction().commit();
            eliminacion = true;
        } catch (HibernateException e) {
            eliminacion = false;
            sesion.beginTransaction().rollback();
        }
        return eliminacion;
    }

    public boolean eliminarUsuario(BigDecimal id) {
        return eliminaUsuario(id);
    }
}
