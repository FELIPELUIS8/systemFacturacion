/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.Clientedao;
import sys.imp.Clientedaoimp;
import sys.model.Cliente;
import sys.util.HibernateUtil;

/**
 *
 * @author Luis Felipe Cantero
 */
@ManagedBean
@ViewScoped
public class facturaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    Session session = null;
    Transaction transation = null;
    private Cliente cliente;
    private Integer codigoCliente;

    public facturaBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    //Metodo para mostrar los datos de los clientes por medio del dialogClientes
    public void agregarDatosCliente(Integer codcliente) {
        this.session = null;
        this.transation = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            Clientedao cDao = new Clientedaoimp();
            this.transation = this.session.beginTransaction();
            System.out.println("Transacción Hibernate iniciada.");
            //obtener los datos del cliente en la variable objeto cliente, segun el codigo del cliente.
            this.cliente = cDao.ObtenerClientesPorCodigo(this.session, codcliente);
            System.out.println("Cliente obtenido: " + this.cliente);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del cliente agregado"));
        } catch (Exception e) {
            if (this.transation != null) {
                System.out.println(e.getMessage());
                transation.rollback();
            }
        } finally {
            if (this.session != null) {
                this.session.close();
                System.out.println("Sesión Hibernate cerrada.");
            }
        }
    }

    //Metodo para mostrar los datos de los cliente buscado por codigo
    public void agregarDatosCliente2() {
        this.session = null;
        this.transation = null;
        
        try {
            if (this.codigoCliente==null) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            Clientedao cDao = new Clientedaoimp();
            this.transation = this.session.beginTransaction();
            System.out.println("Transacción Hibernate iniciada.");
            //obtener los datos del cliente en la variable objeto cliente, segun el codigo del cliente.
            this.cliente = cDao.ObtenerClientesPorCodigo(this.session, this.codigoCliente);
            if (this.cliente != null) {
                this.codigoCliente = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del cliente agregado"));
            } else {
                this.codigoCliente = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correcto", "Datos del cliente no encontrado"));

            }
            System.out.println("Cliente obtenido: " + this.cliente);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del cliente agregado"));
        } catch (Exception e) {
            if (this.transation != null) {
                System.out.println(e.getMessage());
                transation.rollback();
            }
        } finally {
            if (this.session != null) {
                this.session.close();
                System.out.println("Sesión Hibernate cerrada.");
            }
        }
    }
}
