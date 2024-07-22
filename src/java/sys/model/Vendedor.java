package sys.model;
// Generated 21/07/2024 02:15:13 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VENDEDOR")
public class Vendedor  implements java.io.Serializable {
 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODVENDEDOR")

     private int codvendedor;
     private String nombres;
     private String apellidos;
     private String dui;
     private String celular;
     private String direccion;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);
     private Set<Factura> facturas = new HashSet<Factura>(0);

    public Vendedor() {
    }

	
    public Vendedor(int codvendedor, String nombres, String apellidos, String dui, String celular, String direccion) {
        this.codvendedor = codvendedor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
        this.celular = celular;
        this.direccion = direccion;
    }
    public Vendedor(int codvendedor, String nombres, String apellidos, String dui, String celular, String direccion, Set<Usuario> usuarios, Set<Factura> facturas) {
       this.codvendedor = codvendedor;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.dui = dui;
       this.celular = celular;
       this.direccion = direccion;
       this.usuarios = usuarios;
       this.facturas = facturas;
    }
   
    public int getCodvendedor() {
        return this.codvendedor;
    }
    
    public void setCodvendedor(int codvendedor) {
        this.codvendedor = codvendedor;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDui() {
        return this.dui;
    }
    
    public void setDui(String dui) {
        this.dui = dui;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }




}


