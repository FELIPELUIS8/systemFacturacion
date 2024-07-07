/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.Productodao;
import sys.model.Producto;
import sys.util.HibernateUtil;


public class Productodaoimp implements Productodao{

    @Override
    public List<Producto> listarProducto() {
        List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto";
        try {
            lista = session.createQuery(hql).list();
            
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void newProducto(Producto producto) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateProducto(Producto producto) {
       Session session = null;

       try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Cargar la entidad Porducto antes de actualizar
        Producto ProductoExistente = (Producto) session.get(Producto.class, producto.getCodproducto());

        if (ProductoExistente != null) {
            // Actualizar los campos necesarios del producto existente
            ProductoExistente.setNombreproducto(producto.getNombreproducto());
            ProductoExistente.setPrecioventa(producto.getPrecioventa());
            ProductoExistente.setStockminimo(producto.getStockminimo());
            ProductoExistente.setStockactual(producto.getStockactual());
            ProductoExistente.setCodigobarra(producto.getCodigobarra());
            // Actualiza otros campos según sea necesario

            session.merge(ProductoExistente);
            session.getTransaction().commit();
        } else {
            System.out.println("Producto no encontrado para actualizar.");
            // Manejo de error o mensaje adecuado
        }
    } catch (Exception e) {
        System.out.println("Error al actualizar Producto: " + e.getMessage());
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
    } finally {
        if (session != null) {
            session.close();
        }
    }
    }

    @Override
    public void deleteProducto(Producto producto) {
         Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Cargar la entidad Producto antes de eliminar
            producto = (Producto) session.get(Producto.class, producto.getCodproducto());

            if (producto != null) {
                session.delete(producto);
                session.getTransaction().commit();
            } else {
                System.out.println("Producto no encontrado para eliminar.");
                // Manejo de error o mensaje adecuado
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Producto ObtenerProductoPorCodigo(Session session, String codigobarra) throws Exception {
        String hql = "FROM Producto WHERE codigobarra =:codigobarra";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("codigobarra", codigobarra);
            return (Producto) query.uniqueResult();
            
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta" + e.getMessage());
            throw e;
        }
    }

  @Override
    public Producto ObtenerProductoPorNombre(Session session, String nombreproducto) throws Exception {
         String hql = "FROM Producto WHERE nombreproducto =:nombreproducto";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("nombreproducto", nombreproducto);
            return (Producto) query.uniqueResult();
            
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta" + e.getMessage());
            throw e;
        }
    }

  

    
}
