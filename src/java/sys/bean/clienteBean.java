/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sys.dao.Clientedao;
import sys.imp.Clientedaoimp;
import sys.model.Cliente;

/**
 *
 * @author Luis Felipe Cantero
 */
@ManagedBean
@ViewScoped
public class clienteBean {

  private List<Cliente> listaCliente;
    private Cliente cliente;

    public clienteBean() {
    }
   

    public List<Cliente> getListaCliente() {
        Clientedao cDao = new Clientedaoimp();
        listaCliente = cDao.listarClientes();
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void PrepararNuevoCliente(){
        cliente = new Cliente();
    }
    public void nuevoCliente(){
        Clientedao cDao = new Clientedaoimp();
        cDao.newCliente(cliente);
    }
     public void modificarCliente(){
        Clientedao cDao = new Clientedaoimp();
        cDao.updateCliente(cliente);
        cliente = new Cliente();
    }
     public void eliminarCliente(){
        Clientedao cDao = new Clientedaoimp();
        cDao.deleteCliente(cliente);
        cliente = new Cliente();
    }
}
