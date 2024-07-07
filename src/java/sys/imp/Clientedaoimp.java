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
import sys.dao.Clientedao;
import sys.model.Cliente;
import sys.util.HibernateUtil;

/**
 *
 * @author Luis Felipe Cantero
 */
public class Clientedaoimp implements Clientedao {

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Cliente";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void newCliente(Cliente cliente) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cliente);
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
    public void updateCliente(Cliente cliente) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Cargar la entidad Cliente antes de actualizar
            Cliente clienteExistente = (Cliente) session.get(Cliente.class, cliente.getCodcliente());

            if (clienteExistente != null) {
                // Actualizar los campos necesarios del cliente existente
                clienteExistente.setNombres(cliente.getNombres());
                clienteExistente.setApellidos(cliente.getApellidos());
                clienteExistente.setCelular(cliente.getCelular());
                clienteExistente.setDirrecion(cliente.getDirrecion());
                clienteExistente.setIdentificacion(cliente.getIdentificacion());
                clienteExistente.setEmail(cliente.getEmail());
                // Actualiza otros campos según sea necesario

                session.merge(clienteExistente);
                session.getTransaction().commit();
            } else {
                System.out.println("Cliente no encontrado para actualizar.");
                // Manejo de error o mensaje adecuado
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
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
    // forma correcta de implementar el metodo deletecliente
    public void deleteCliente(Cliente cliente) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Cargar la entidad Cliente antes de eliminar
            cliente = (Cliente) session.get(Cliente.class, cliente.getCodcliente());

            if (cliente != null) {
                session.delete(cliente);
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

    @Override
    public Cliente ObtenerClientesPorCodigo(Session session, Integer codCliente) throws Exception {
        String hql = "FROM Cliente WHERE codcliente = :codCliente";
    try {
        Query query = session.createQuery(hql);
        query.setParameter("codCliente", codCliente);
        return (Cliente) query.uniqueResult();
    } catch (Exception e) {
        System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        throw e; // O manejar de otra forma según el contexto de tu aplicación
    }
    }

    @Override
    public Cliente ObtenerClientesPorNombre(Session session, String nombres) throws Exception {
      String hql = "FROM Cliente WHERE nombres =:nombres";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("nombres", nombres);
            return (Cliente) query.uniqueResult();
            
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta" + e.getMessage());
            throw e;
        }
    }

    @Override
    public Cliente ObtenerClientesPoridentificacion(Session session, String identificacion) throws Exception {
        String hql = "FROM Cliente WHERE identificacion =:identificacion";
        try {
            Query query = session.createQuery(hql);
            query.setParameter("identificacion", identificacion);
            return (Cliente) query.uniqueResult();
            
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta" + e.getMessage());
            throw e;
        }
    }
    
    
    
    
    
}
