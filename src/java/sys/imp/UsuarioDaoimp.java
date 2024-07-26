/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import sys.claseAuxiliares.encriptarPassword;
import org.hibernate.Query;
import org.hibernate.Session;
import sys.dao.usuarioDao;
import sys.model.Usuario;
import sys.util.HibernateUtil;

/**
 *
 * @author Luis Felipe Cantero
 */
public class UsuarioDaoimp implements usuarioDao {

    @Override
    public Usuario obtenerDatosPorUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuario WHERE username=:username";
        Query q = session.createQuery(hql);
        q.setParameter("username", usuario.getUsername());
        return (Usuario) q.uniqueResult();
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario user = this.obtenerDatosPorUsuario(usuario);
        if (user!=null) {
            if(!user.getPassword().equals(encriptarPassword.sha512(usuario.getPassword()))){
                user=null;
            }
        }
        return user;
    }

}
