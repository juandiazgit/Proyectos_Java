package dao;

import java.util.Date;
import java.util.List;
import modelo.Funcionalidad;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import modelo.Rol;
import modelo.Rolfuncionalidad;
import modelo.Usuario;
import modelo.Usuariorol;
import org.hibernate.Query;

/**
 *
 * @author CIADTI2017
 */
public class rolfuncionalidadDao {

    private List<Rolfuncionalidad> listaFuncionalidadesDelRol(Rol rol){
        List<Rolfuncionalidad> listFuncionalidadesPorRol = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Criteria criteria=sesion.createCriteria(Rolfuncionalidad.class);
            Criteria funcCriteria=criteria.createCriteria("funcionalidad");
            Criteria rolCriteria=criteria.createCriteria("rol");
            System.out.println("Id del Rol ----> "+rol.getRolId());
            rolCriteria.add(Restrictions.eq("rolId", rol.getRolId()));
            listFuncionalidadesPorRol=criteria.list();
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return listFuncionalidadesPorRol;
    }
    
    public List<Rolfuncionalidad> listarFuncionalidadesDelRol(Rol rol){
        List<Rolfuncionalidad> listFuncionalidadesPorRol=listaFuncionalidadesDelRol(rol);
                return listFuncionalidadesPorRol;
    }

    private boolean asignaFuncionalidadRol(Funcionalidad funcionalidad,Rol rol) {
        boolean insercion;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Date fecharegistro = new Date();
            int maxid = 0;
            String hql = "SELECT MAX(rolfunId) FROM Rolfuncionalidad";
            Query query = sesion.createQuery(hql);
            maxid = (int) query.uniqueResult();
            int id = maxid + 1;
            if (maxid > 0) {
                Rolfuncionalidad rolfun = new Rolfuncionalidad(id, funcionalidad, rol, fecharegistro);
                sesion.save(rolfun);
                sesion.getTransaction().commit();
                insercion = true;
            } else {
                insercion = false;
                System.out.println("El rolfun para sacar el ID está Llegando Null en Metodo asignaFuncionalidadRol ");
            }
        } catch (HibernateException e) {
            insercion = false;
            sesion.beginTransaction().rollback();
        }
        return insercion;
    }

    public boolean asignarFuncionalidadRol(Funcionalidad funcionalidad,Rol rol) {
        return asignaFuncionalidadRol(funcionalidad, rol);
    }

    private boolean eliminaFuncionalidadRol(Funcionalidad funcionalidad,Rol rol) {
        Rolfuncionalidad rolfun = null;
        boolean eliminacion;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Criteria criteria = sesion.createCriteria(Rolfuncionalidad.class);
            criteria.add(Restrictions.eq("funcionalidad.funId", funcionalidad.getFunId()));
            criteria.add(Restrictions.eq("rol.rolId", rol.getRolId()));
            rolfun = (Rolfuncionalidad) criteria.uniqueResult();
            sesion.delete(rolfun);
            sesion.getTransaction().commit();
            eliminacion = true;
        } catch (HibernateException e) {
            eliminacion = false;
            sesion.beginTransaction().rollback();
        }
        return eliminacion;
    }

    public boolean eliminarFuncionalidadRol(Funcionalidad funcionalidad,Rol rol) {
        return eliminaFuncionalidadRol(funcionalidad,rol);
    }
}
