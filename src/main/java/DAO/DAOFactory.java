
package DAO;

import DAO.impl.DespesaDAOImpl;
import DAO.impl.UsuarioDAOImpl;
import DataBase.DB;

public class DAOFactory {
    public static UsuarioDAO createUsuarioDAO() {
        return new UsuarioDAOImpl(DB.getConexao());
    }
    
    public static DespesaDAO createDespesaDAO() {
        return new DespesaDAOImpl(DB.getConexao());
    }
	
}
