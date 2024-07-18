/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import org.hibernate.Session;
import sys.model.Detallefactura;

/**
 *
 * @author Luis Felipe Cantero
 */
public interface detalleFacturaDao {
     //Metodo para guardar el registro en la tabla detallefactura de la BD.
    public boolean guardarVentaDetalleFactura(Session session, Detallefactura detallefactura )throws Exception;

}
