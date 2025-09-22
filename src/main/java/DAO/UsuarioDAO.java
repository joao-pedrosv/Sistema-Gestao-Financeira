
package DAO;

import java.util.List;
import model.Usuario;

public interface UsuarioDAO {
    
    void insert(Usuario usuario);
    void update(Usuario usuario);
    void delete(String email);
    boolean login(String username, String email, String senha);
    Usuario findByEmail(String email);
}
