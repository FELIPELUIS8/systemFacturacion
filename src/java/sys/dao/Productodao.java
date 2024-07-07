/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import sys.model.Producto;

/**
 *
 * @author Luis Felipe Cantero
 */
public interface Productodao {
     public List<Producto> listarProducto();
    public void newProducto(Producto producto);
    public void updateProducto(Producto producto);
    public void deleteProducto(Producto producto); 
    public Producto ObtenerProductoPorCodigo(Session session, String codigobarra)throws Exception;
    public Producto ObtenerProductoPorNombre(Session session, String nombreproducto)throws Exception;
}
