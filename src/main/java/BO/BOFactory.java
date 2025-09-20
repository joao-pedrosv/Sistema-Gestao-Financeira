package BO;

import DAO.DespesaDAO;
import DAO.impl.DespesaDAOImpl;
import DataBase.DB;
import java.sql.Connection;

public class BOFactory {

    public static DespesaBO createDespesaBO() {
        DespesaDAO dao = new DespesaDAOImpl(DB.getConexao());
        return new DespesaBO(dao);
    }
}
