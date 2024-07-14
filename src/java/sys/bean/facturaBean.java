/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import sys.dao.Clientedao;
import sys.dao.Productodao;
import sys.imp.Clientedaoimp;
import sys.imp.Productodaoimp;
import sys.model.Cliente;
import sys.model.Detallefactura;
import sys.model.Factura;
import sys.model.Producto;
import sys.util.HibernateUtil;
import javax.faces.context.FacesContext;

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
    private String cantidadProducto;
    private String prodcutoSeleccionado;
    private Factura factura;
    private String cantidadProducto1;
    private String cantidadProducto2;

    public facturaBean() {
        listaDetalleFactura = new ArrayList<>();
        this.factura = new Factura();
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

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getProdcutoSeleccionado() {
        return prodcutoSeleccionado;
    }

    public void setProdcutoSeleccionado(String prodcutoSeleccionado) {
        this.prodcutoSeleccionado = prodcutoSeleccionado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getCantidadProducto1() {
        return cantidadProducto1;
    }

    public void setCantidadProducto1(String cantidadProducto1) {
        this.cantidadProducto1 = cantidadProducto1;
    }

    public String getCantidadProducto2() {
        return cantidadProducto2;
    }

    public void setCantidadProducto2(String cantidadProducto2) {
        this.cantidadProducto2 = cantidadProducto2;
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
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos del cliente no encontrado"));

            }
            System.out.println("Cliente obtenido: " + this.cliente);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");
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
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos del cliente no encontrado"));

            }
            System.out.println("Cliente obtenido: " + this.cliente);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");
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
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos del cliente no encontrado"));

            }
            System.out.println("Cliente obtenido: " + this.cliente);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");
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

    //Metodo para solicitar la cantidad de producto a vender
    public void pedirCantidadProducto(String codBarra) {
        this.prodcutoSeleccionado = codBarra;
    }

    //Metodo para mostrar los datos de los productos buscado por medio del dialogProducto
    public void agregarDatosProducto() {
        this.session = null;
        this.transation = null;
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            // Validar que la cantidad ingresada sea un número válido y mayor que cero
            if (!validarCantidad()) {
                return; // No continúa si la cantidad es inválida
            }

            this.session = HibernateUtil.getSessionFactory().openSession();
            Productodao proDao = new Productodaoimp();
            this.transation = this.session.beginTransaction();
            System.out.println("Transacción Hibernate iniciada.");

            // Obtener los datos del producto en la variable objeto producto, según el código de barra.
            this.producto = proDao.ObtenerProductoPorCodigo(this.session, prodcutoSeleccionado);

            // Verificar si el producto existe y tiene datos válidos
            if (this.producto == null || this.producto.getCodigobarra() == null) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Producto no encontrado"));
                return;
            }

            // Agregar detalle de factura con los datos del producto y la cantidad
            listaDetalleFactura.add(new Detallefactura(null, null, this.producto, this.producto.getCodigobarra(),
                    this.producto.getNombreproducto(), Integer.parseInt(this.cantidadProducto), this.producto.getPrecioventa(),
                    BigDecimal.valueOf(Integer.parseInt(this.cantidadProducto) * this.producto.getPrecioventa().floatValue())));

            System.out.println("Producto obtenido: " + this.producto);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del producto agregados"));
            // Llamada al método calcular totalFacturaVenta.
            this.totalFacturaVenta();
            this.cantidadProducto = "";

            // Mostrar los diálogos de PrimeFaces
            RequestContext.getCurrentInstance().execute("PF('dialogCantidadProducto').hide(); PF('dialogProductos').hide();");

        } catch (NumberFormatException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad debe ser un número entero"));
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

    // metodo para mostrar el dialogCantidadProducto1
    public void mostrarCantidadProducto1() {
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
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogCantidadProducto1').show();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del producto agregado al detalle"));

                this.codigobarra = null;
            } else {
                this.codigobarra = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correcto", "Datos del producto no encontrado"));

            }
            System.out.println("producto obtenido: " + this.producto);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");
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
        if (!ValidarCantidad1()) {
            this.cantidadProducto1 = "";
            return;
        }
        if (this.producto != null) {
            listaDetalleFactura.add(new Detallefactura(null, null, this.producto, this.producto.getCodigobarra(),
                    this.producto.getNombreproducto(), Integer.parseInt(this.cantidadProducto1), this.producto.getPrecioventa(),
                    BigDecimal.valueOf(Integer.parseInt(this.cantidadProducto1) * this.producto.getPrecioventa().floatValue())));
            this.cantidadProducto1 = "";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del producto agregado al detalle"));
            //Llamar al metodo totalFacturaVenta;
            this.totalFacturaVenta();
        }
    }

    // metodo para mostrar el dialogCantidadProducto2
    public void mostrarCantidadProducto2() {
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
            //obtener los datos del Producto en la variable objeto producto, segun el nombre del producto.
            this.producto = proDao.ObtenerProductoPorNombre(this.session, this.nombreproducto);
            if (this.producto != null) {
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogCantidadProducto2').show();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del producto agregado al detalle"));
                this.nombreproducto = null;
            } else {
                this.nombreproducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correcto", "Datos del producto no encontrado"));

            }
            System.out.println("producto obtenido: " + this.producto);
            this.transation.commit();
            System.out.println("Transacción Hibernate comprometida.");
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

    //Metodo para mostrar los datos del producto  buscado por nombre
    public void agregarDatosProducto2() {

        if (!ValidarCantidad2()) {
            this.cantidadProducto2 = "";
            return;
        }
        if (this.producto != null) {
            listaDetalleFactura.add(new Detallefactura(null, null, this.producto, this.producto.getCodigobarra(),
                    this.producto.getNombreproducto(), Integer.parseInt(this.cantidadProducto2), this.producto.getPrecioventa(),
                    BigDecimal.valueOf(Integer.parseInt(this.cantidadProducto2) * this.producto.getPrecioventa().floatValue())));
            this.cantidadProducto2 = "";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del producto agregado al detalle"));
            //Llamar al metodo totalFacturaVenta;
            this.totalFacturaVenta();
        }
    }

    //Metodo para calcular el total a vender
    public void totalFacturaVenta() {
        BigDecimal totalFacturaVenta = new BigDecimal("0");
        try {
            for (Detallefactura item : listaDetalleFactura) {
                BigDecimal totalVentaPorProducto = item.getPrecioventa().multiply(new BigDecimal(item.getCantidad()));
                item.setTotal(totalVentaPorProducto);
                totalFacturaVenta = totalFacturaVenta.add(totalVentaPorProducto);
            }
            if (factura != null) {
                this.factura.setTotalventa(totalFacturaVenta);
            } else {
                System.err.println("La factura es nula. No se puede establecer el total de la venta.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //validar la cantidad del dialogCantidadProducto
    private boolean validarCantidad() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Validar que la cantidad sea un número entero mayor que cero
            int cantidad = Integer.parseInt(this.cantidadProducto);
            if (cantidad <= 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad debe ser mayor que cero"));
                return false;
            }
        } catch (NumberFormatException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad debe ser un número entero"));
            return false;
        }
        return true;
    }
    //validar la cantidad del dialogCantidadProducto1

    public boolean ValidarCantidad1() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            int cantidad1 = Integer.parseInt(this.cantidadProducto1);
            if (cantidad1 <= 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad debe ser mayor a cero"));
                return false;
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad debe ser un numero entero"));
            return false;
        }
        return true;
    }
    //validar la cantidad del dialogCantidadProducto2

    public boolean ValidarCantidad2() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            int cantidad2 = Integer.parseInt(this.cantidadProducto2);
            if (cantidad2 <= 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad debe ser mayor a cero"));
                return false;
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad deber ser un numero entero"));
            return false;
        }
        return true;
    }

}
