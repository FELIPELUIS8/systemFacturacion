/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import org.hibernate.Session;
import sys.model.Factura;

/**
 *
 * @author Luis Felipe Cantero
 */
public interface facturaDao {
    //Metodo para obtener el ultimo registro en la tabla factura de la BD.
    public Factura obtenerUltimoRegistro(Session session)throws Exception;
    //Metodo para saber si la tabla factura posee algun registros.
    public Long obtenerTotalRegistrosEnFactura(Session session);
    
    //Metodo para guardar el registro en la tabla factura de la BD.
    public boolean guardarVentaFactura(Session session, Factura factura)throws Exception;
    
}
