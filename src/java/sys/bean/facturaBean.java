/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.Clientedao;
import sys.dao.Productodao;
import sys.imp.Clientedaoimp;
import sys.imp.Productodaoimp;
import sys.model.Cliente;
import sys.model.Detallefactura;
import sys.model.Producto;
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
    private String nombres;
    private String identificacion;
    private Producto producto;
    private String codigobarra;
    private String nombreproducto;
    private List<Detallefactura> listaDetalleFactura;

    public facturaBean() {
        listaDetalleFactura = new ArrayList<>();
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Detallefactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<Detallefactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
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
            if (this.codigoCliente == null) {
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

    //Metodo para mostrar los datos de los cliente buscado por nombre
    public void agregarDatosCliente3() {
        this.session = null;
        this.transation = null;

        try {
            if (this.nombres.equals("")) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            Clientedao cDao = new Clientedaoimp();
            this.transation = this.session.beginTransaction();
            System.out.println("Transacción Hibernate iniciada.");
            //obtener los datos del cliente en la variable objeto cliente, segun el codigo del cliente.
            this.cliente = cDao.ObtenerClientesPorNombre(this.session, this.nombres);
            if (this.cliente != null) {
                this.nombres = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del cliente agregado"));
            } else {
                this.nombres = null;
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

    //Metodo para mostrar los datos de los cliente buscado por identificacion
    public void agregarDatosCliente4() {
        this.session = null;
        this.transation = null;

        try {
            if (this.identificacion.equals("")) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            Clientedao cDao = new Clientedaoimp();
            this.transation = this.session.beginTransaction();
            System.out.println("Transacción Hibernate iniciada.");
            //obtener los datos del cliente en la variable objeto cliente, segun el codigo del cliente.
            this.cliente = cDao.ObtenerClientesPoridentificacion(this.session, this.identificacion);
            if (this.cliente != null) {
                this.identificacion = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del cliente agregado"));
            } else {
                this.identificacion = null;
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

    //Metodo para mostrar los datos de los productos buscado por medio del dialogProducto
    public void agregarDatosProducto(String codigoBarra) {
        this.session = null;
        this.transation = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            Productodao proDao = new Productodaoimp();
            this.transation = this.session.beginTransaction();
            System.out.println("Transacción Hibernate iniciada.");
            //obtener los datos del producto en la variable objeto producto, segun el codigo de barra.
            this.producto = proDao.ObtenerProductoPorCodigo(this.session, codigoBarra);
            listaDetalleFactura.add(new Detallefactura(null, null, this.producto, this.producto.getCodigobarra(), this.producto.getNombreproducto(), 0, this.producto.getPrecioventa(), BigDecimal.ZERO));
            System.out.println("Producto obtenido: " + this.producto);
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

    //Metodo para mostrar los datos del producto  buscado por codigo de barra
    public void agregarDatosProducto1() {
        this.session = null;
        this.transation = null;

        try {
            if (this.codigobarra.equals("")) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            Productodao proDao = new Productodaoimp();
            this.transation = this.session.beginTransaction();
            System.out.println("Transacción Hibernate iniciada.");
            //obtener los datos del Producto en la variable objeto producto, segun el codigo de barra.
            this.producto = proDao.ObtenerProductoPorCodigo(this.session, this.codigobarra);
            if (this.producto != null) {
                this.codigobarra = null;
                listaDetalleFactura.add(new Detallefactura(null, null, this.producto, this.producto.getCodigobarra(), this.producto.getNombreproducto(), 0, this.producto.getPrecioventa(), BigDecimal.ZERO));
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del producto agregado al detalle"));
            } else {
                this.codigobarra = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correcto", "Datos del producto no encontrado"));

            }
            System.out.println("producto obtenido: " + this.producto);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del producto agregado al detalle"));
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
    //Metodo para mostrar los datos del producto  buscado por codigo de barra
    public void agregarDatosProducto2() {
        this.session = null;
        this.transation = null;

        try {
            if (this.nombreproducto.equals("")) {
                return;
            }
            this.session = HibernateUtil.getSessionFactory().openSession();
            Productodao proDao = new Productodaoimp();
            this.transation = this.session.beginTransaction();
            System.out.println("Transacción Hibernate iniciada.");
            //obtener los datos del Producto en la variable objeto producto, segun el nombre.
            this.producto = proDao.ObtenerProductoPorNombre(session,nombreproducto);
            if (this.producto != null) {
                this.nombreproducto = null;
                listaDetalleFactura.add(new Detallefactura(null, null, this.producto, this.producto.getCodigobarra(), this.producto.getNombreproducto(), 0, this.producto.getPrecioventa(), BigDecimal.ZERO));
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del producto agregado al detalle"));
            } else {
                this.nombreproducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correcto", "Datos del producto no encontrado"));

            }
            System.out.println("producto obtenido: " + this.producto);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del producto agregado al detalle"));
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
