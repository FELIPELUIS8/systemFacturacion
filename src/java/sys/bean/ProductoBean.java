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
import sys.dao.Productodao;
import sys.imp.Productodaoimp;
import sys.model.Producto;

/**
 *
 * @author Luis Felipe Cantero
 */
@ManagedBean
@ViewScoped
public class ProductoBean implements Serializable {

    private static final long serialVersionUID = 1L; // ID de serialización
    private List<Producto> listaProducto;
    private Producto producto;

    public ProductoBean() {
        producto = new Producto();
    }

    public List<Producto> getListaProducto() {
         Productodao pDao = new Productodaoimp();
        listaProducto = pDao.listarProducto();
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void prepararNuevoProducto() {
        producto = new Producto();
    }

    public void nuevoProducto() {
        Productodao pDao = new Productodaoimp();
        pDao.newProducto(producto);
    }

    public void modificarProducto() {
        Productodao cDao = new Productodaoimp();
        cDao.updateProducto(producto);
        producto = new Producto();
    }

    public void eliminarProducto() {
        Productodao cDao = new Productodaoimp();
        cDao.deleteProducto(producto);
        producto = new Producto();
    }

}
