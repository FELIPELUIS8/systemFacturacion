package sys.model;
// Generated 15/06/2024 11:11:38 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "PRODUCTO")

public class Producto  implements java.io.Serializable {

     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     @Column (name = "CODPRODUCTO")
     private int codproducto;
     @Column (name = "NOMBREPRODUCTO")
     private String nombreproducto;
     @Column (name = "PRECIOVENTA")
     private BigDecimal precioventa;
     @Column (name = "STOCKMINIMO")
     private int stockminimo;
     @Column (name = "STOCKACTUAL")
     private int stockactual;
     @Column (name = "CODIGOBARRA")
     private String codigobarra;
     private Set<Detallefactura> detallefacturas = new HashSet<Detallefactura>(0);

    public Producto() {
    }

	
    public Producto(int codproducto, String nombreproducto, BigDecimal precioventa, int stockminimo, int stockactual) {
        this.codproducto = codproducto;
        this.nombreproducto = nombreproducto;
        this.precioventa = precioventa;
        this.stockminimo = stockminimo;
        this.stockactual = stockactual;
    }
    public Producto(int codproducto, String nombreproducto, BigDecimal precioventa, int stockminimo, int stockactual, String codigobarra, Set<Detallefactura> detallefacturas) {
       this.codproducto = codproducto;
       this.nombreproducto = nombreproducto;
       this.precioventa = precioventa;
       this.stockminimo = stockminimo;
       this.stockactual = stockactual;
       this.codigobarra = codigobarra;
       this.detallefacturas = detallefacturas;
    }
   
    public int getCodproducto() {
        return this.codproducto;
    }
    
    public void setCodproducto(int codproducto) {
        this.codproducto = codproducto;
    }
    public String getNombreproducto() {
        return this.nombreproducto;
    }
    
    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }
    public BigDecimal getPrecioventa() {
        return this.precioventa;
    }
    
    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }
    public int getStockminimo() {
        return this.stockminimo;
    }
    
    public void setStockminimo(int stockminimo) {
        this.stockminimo = stockminimo;
    }
    public int getStockactual() {
        return this.stockactual;
    }
    
    public void setStockactual(int stockactual) {
        this.stockactual = stockactual;
    }
    public String getCodigobarra() {
        return this.codigobarra;
    }
    
    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }
    public Set<Detallefactura> getDetallefacturas() {
        return this.detallefacturas;
    }
    
    public void setDetallefacturas(Set<Detallefactura> detallefacturas) {
        this.detallefacturas = detallefacturas;
    }




}


