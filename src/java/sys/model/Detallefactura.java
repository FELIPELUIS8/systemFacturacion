package sys.model;
// Generated 21/07/2024 02:15:13 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Detallefactura generated by hbm2java
 */
@Entity
@Table(name = "DETALLEFACTURA")
public class Detallefactura  implements java.io.Serializable {

      @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODDETALLE")
     private Integer coddetalle;
     private Factura factura;
     private Producto producto;
     private String codbarra;
     private String nombreproducto;
     private int cantidad;
     private BigDecimal precioventa;
     private BigDecimal total;

    public Detallefactura() {
    }

	
    public Detallefactura(Integer coddetalle, Factura factura, Producto producto, String codbarra, String nombreproducto, int cantidad) {
        this.coddetalle = coddetalle;
        this.factura = factura;
        this.producto = producto;
        this.codbarra = codbarra;
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
    }
    public Detallefactura(Integer coddetalle, Factura factura, Producto producto, String codbarra, String nombreproducto, int cantidad, BigDecimal precioventa, BigDecimal total) {
       this.coddetalle = coddetalle;
       this.factura = factura;
       this.producto = producto;
       this.codbarra = codbarra;
       this.nombreproducto = nombreproducto;
       this.cantidad = cantidad;
       this.precioventa = precioventa;
       this.total = total;
    }
   
    public Integer getCoddetalle() {
        return this.coddetalle;
    }
    
    public void setCoddetalle(Integer coddetalle) {
        this.coddetalle = coddetalle;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public String getCodbarra() {
        return this.codbarra;
    }
    
    public void setCodbarra(String codbarra) {
        this.codbarra = codbarra;
    }
    public String getNombreproducto() {
        return this.nombreproducto;
    }
    
    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getPrecioventa() {
        return this.precioventa;
    }
    
    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }




}


