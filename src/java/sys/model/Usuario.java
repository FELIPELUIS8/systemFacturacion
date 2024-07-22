package sys.model;
// Generated 21/07/2024 02:15:13 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "USUARIO")
public class Usuario  implements java.io.Serializable {

 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODUSUARIO")
     private int codusuario;
     private Vendedor vendedor;
     private String username;
     private String password;

    public Usuario() {
    }

    public Usuario(int codusuario, Vendedor vendedor, String username, String password) {
       this.codusuario = codusuario;
       this.vendedor = vendedor;
       this.username = username;
       this.password = password;
    }
   
    public int getCodusuario() {
        return this.codusuario;
    }
    
    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }
    public Vendedor getVendedor() {
        return this.vendedor;
    }
    
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


