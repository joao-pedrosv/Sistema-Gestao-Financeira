
package BO;

import DAO.UsuarioDAO;
import model.Usuario;

public class UsuarioBO {
    
    private UsuarioDAO usuarioDAO;
    
    public UsuarioBO(UsuarioDAO usuarioDAO){
        this.usuarioDAO = usuarioDAO;
    }
    
    public void inserirUsuario(Usuario usuario){
        usuarioDAO.insert(usuario);
    }
    
    public void atualizar(Usuario usuario){
        usuarioDAO.update(usuario);
    }
    
    public void deletar(String email){
        usuarioDAO.delete(email);
    }
    
     public boolean login(String username, String email, String senha){
         return usuarioDAO.login(username, email, senha);
    }
    
}
