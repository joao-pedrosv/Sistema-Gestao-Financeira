
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
        
        System.out.println("Usuário inserido com sucesso!");
    }
    
    public void atualizar(Usuario usuario){
        usuarioDAO.update(usuario);
        
        System.out.println("Usuário atualizado com sucesso");
    }
    
    public void deletar(Integer id){
        usuarioDAO.delete(id);
        
        System.out.println("Usuário excluído com sucesso!");
    }
    
    public boolean login(String username, String senha){
         return usuarioDAO.login(username, senha);
    }
    
}
