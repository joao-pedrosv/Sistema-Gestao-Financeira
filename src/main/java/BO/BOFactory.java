package BO;

import DAO.DespesaDAO;
import DAO.UsuarioDAO;
import DAO.impl.DespesaDAOImpl;
import DAO.impl.UsuarioDAOImpl;
import DataBase.DB;
import java.sql.Connection;

public class BOFactory {

    public static DespesaBO createDespesaBO() {
        DespesaDAO despesaDAO = new DespesaDAOImpl(DB.getConexao());
        return new DespesaBO(despesaDAO);
    }
    
    public static UsuarioBO createUsuarioBO() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(DB.getConexao());
        return new UsuarioBO(usuarioDAO);
    }
}
