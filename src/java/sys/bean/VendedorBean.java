/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sys.dao.Vendedordao;
import sys.imp.Vendedordaoimp;
import sys.model.Vendedor;

/**
 *
 * @author Luis Felipe Cantero
 */
@ManagedBean
@ViewScoped
public class VendedorBean implements Serializable{
private static final long serialVersionUID = 1L; // ID de serialización
 private List<Vendedor> listaVendedor;
    private Vendedor vendedor;
    public VendedorBean() {
        vendedor = new Vendedor();
    }

    public List<Vendedor> getListaVendedor() {
        Vendedordao vDao = new Vendedordaoimp();
        listaVendedor = vDao.listarVendedor();
        return listaVendedor;
    }

    public void setListaVendedor(List<Vendedor> listaVendedor) {
        this.listaVendedor = listaVendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public void prepararNuevoVendedor(){
        vendedor = new Vendedor();
    }
    public void nuevoVendedor(){
        Vendedordao vDao = new Vendedordaoimp();
        vDao.newVendedor(vendedor);
    }
     public void modificarVendedor(){
         Vendedordao vDao = new Vendedordaoimp();
        vDao.updateVendedor(vendedor);
        vendedor = new Vendedor();
    }
     public void eliminarVendedor(){
         Vendedordao vDao = new Vendedordaoimp();
        vDao.deleteVendedor(vendedor);
        vendedor = new Vendedor();
    }
    
}
