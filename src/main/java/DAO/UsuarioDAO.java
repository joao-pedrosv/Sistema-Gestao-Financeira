
package DAO;

import java.util.List;
import model.Usuario;

public interface UsuarioDAO {
    
    void insert(Usuario usuario);
    void update(Usuario usuario);
    void delete(Integer id);
    boolean login(String username, String senha);
}
