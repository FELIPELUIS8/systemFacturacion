/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.Vendedordao;
import sys.model.Vendedor;
import sys.util.HibernateUtil;

/**
 *
 * @author Luis Felipe Cantero
 */
public class Vendedordaoimp implements Vendedordao{

    @Override
    public List<Vendedor> listarVendedor() {
        List<Vendedor> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Vendedor";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void newVendedor(Vendedor vendedor) {
       Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(vendedor);
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
    public void updateVendedor(Vendedor vendedor) {
         Session session = null;
        try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Cargar la entidad Vendedor antes de actualizar
        Vendedor vendedorExistente = (Vendedor) session.get(Vendedor.class, vendedor.getCodvendedor());

        if (vendedorExistente != null) {
            // Actualizar los campos necesarios del vendedor existente
            
            vendedorExistente.setNombres(vendedor.getNombres());
            vendedorExistente.setApellidos(vendedor.getApellidos());
            vendedorExistente.setDui(vendedor.getDui());
            vendedorExistente.setCelular(vendedor.getCelular());
            vendedorExistente.setDireccion(vendedor.getDireccion());
            // Actualiza otros campos según sea necesario

            session.merge(vendedorExistente);
            session.getTransaction().commit();
        } else {
            System.out.println("Vendedor no encontrado para actualizar.");
            // Manejo de error o mensaje adecuado
        }
    } catch (Exception e) {
        System.out.println("Error al actualizar vendedor: " + e.getMessage());
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
    public void deleteVendedor(Vendedor vendedor) {
          Session session = null;
       try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Cargar la entidad Cliente antes de eliminar
            vendedor = (Vendedor) session.get(Vendedor.class, vendedor.getCodvendedor());

            if (vendedor != null) {
                session.delete(vendedor);
                session.getTransaction().commit();
            } else {
                System.out.println("Cliente no encontrado para eliminar.");
                // Manejo de error o mensaje adecuado
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
