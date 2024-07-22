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
@Table(name = "CLIENTE")
public class Cliente implements java.io.Serializable {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODCLIENTE")
    private int codcliente;
    private String nombres;
    private String apellidos;
    private String celular;
    private String dirrecion;
    private String identificacion;
    private String email;
    private Set<Factura> facturas = new HashSet<Factura>(0);

    public Cliente() {
    }

    public Cliente(int codcliente, String nombres, String apellidos, String celular, String dirrecion) {
        this.codcliente = codcliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.dirrecion = dirrecion;
    }

    public Cliente(int codcliente, String nombres, String apellidos, String celular, String dirrecion, String identificacion, String email, Set<Factura> facturas) {
        this.codcliente = codcliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.dirrecion = dirrecion;
        this.identificacion = identificacion;
        this.email = email;
        this.facturas = facturas;
    }

    public int getCodcliente() {
        return this.codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
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

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDirrecion() {
        return this.dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Factura> getFacturas() {
        return this.facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

}
