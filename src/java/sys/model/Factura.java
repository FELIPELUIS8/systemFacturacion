package sys.model;
// Generated 15/06/2024 11:11:38 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Factura generated by hbm2java
 */
public class Factura  implements java.io.Serializable {


     private int codfactura;
     private Cliente cliente;
     private Vendedor vendedor;
     private String numerofactura;
     private BigDecimal totalventa;
     private Date fecharegistro;
     private Set<Detallefactura> detallefacturas = new HashSet<Detallefactura>(0);

    public Factura() {
    }

	
    public Factura(int codfactura, Cliente cliente, Vendedor vendedor, String numerofactura) {
        this.codfactura = codfactura;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.numerofactura = numerofactura;
    }
    public Factura(int codfactura, Cliente cliente, Vendedor vendedor, String numerofactura, BigDecimal totalventa, Date fecharegistro, Set<Detallefactura> detallefacturas) {
       this.codfactura = codfactura;
       this.cliente = cliente;
       this.vendedor = vendedor;
       this.numerofactura = numerofactura;
       this.totalventa = totalventa;
       this.fecharegistro = fecharegistro;
       this.detallefacturas = detallefacturas;
    }
   
    public int getCodfactura() {
        return this.codfactura;
    }
    
    public void setCodfactura(int codfactura) {
        this.codfactura = codfactura;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Vendedor getVendedor() {
        return this.vendedor;
    }
    
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public String getNumerofactura() {
        return this.numerofactura;
    }
    
    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }
    public BigDecimal getTotalventa() {
        return this.totalventa;
    }
    
    public void setTotalventa(BigDecimal totalventa) {
        this.totalventa = totalventa;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public Set<Detallefactura> getDetallefacturas() {
        return this.detallefacturas;
    }
    
    public void setDetallefacturas(Set<Detallefactura> detallefacturas) {
        this.detallefacturas = detallefacturas;
    }




}


