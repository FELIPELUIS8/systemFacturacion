/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import sys.model.Cliente;

/**
 *
 * @author Luis Felipe Cantero
 */
public interface Clientedao {

    public List<Cliente> listarClientes();
    public void newCliente(Cliente cliente);
    public void updateCliente(Cliente cliente);
    public void deleteCliente(Cliente cliente); 
    
    public Cliente ObtenerClientesPorCodigo(Session session ,Integer codCliente)throws Exception;
}
