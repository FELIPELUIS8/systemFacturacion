
package sys.dao;

import sys.model.Usuario;


public interface usuarioDao {
   public Usuario obtenerDatosPorUsuario(Usuario usiario);
   public Usuario login(Usuario usuario);
}
