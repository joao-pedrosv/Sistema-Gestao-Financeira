
package DAO.impl;

import DAO.DespesaDAO;
import DataBase.DB;
import DataBase.DBException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Despesa;

public class DespesaDAOImpl implements DespesaDAO {

    private Connection conn;

    public DespesaDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Despesa despesa) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO despesas "
                    + "(Nome, Preco, Status, Data_vencimento) "
                    + "VALUES "
                    + "(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, despesa.getNome());
            st.setDouble(2, despesa.getPreco());
            st.setString(3, despesa.getStatus());
            st.setDate(4, java.sql.Date.valueOf(despesa.getDataVencimento()));

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    despesa.setId(id);
                }
                DB.fecharResultSet(rs);
            } else {
                throw new DBException("Unexpected error: No rows affected!");
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
        }
    }

    @Override
    public void update(Despesa despesa) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE despesas "
                    + "SET status = ?"
                    + "WHERE Id = ?"
            );
   
            st.setString(1, despesa.getStatus());
            st.setInt(2, despesa.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM despesas "
                    + "WHERE Id = ?"
            );

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
        }
    }

    @Override
    public Despesa findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM Despesas WHERE Id = ? ");

            st.setInt(1, id);
            rs = st.executeQuery();
            
            if (rs.next()) {
                Despesa despesa = instantiateDespesa(rs);
                return despesa;
            }
            return null;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharResultSet(rs);
        }
    }
    
    @Override
    public List<Despesa> findByStatus(String status) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM Despesas WHERE status = ? ORDER BY data_vencimento");

            st.setString(1, status);
            rs = st.executeQuery();
            
            List<Despesa> list = new ArrayList<>();
            
            while (rs.next()) {
                Despesa despesa = instantiateDespesa(rs);
                list.add(despesa);
            }
            return list;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharResultSet(rs);
        }
    }
    
    
    @Override
    public List<Despesa> findByDate(int year, int month) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM Despesas WHERE YEAR(data_vencimento) = ? AND MONTH(data_vencimento) = ? ORDER BY data_vencimento");

            st.setInt(1, year);
            st.setInt(2, month);
            rs = st.executeQuery();
            
            List<Despesa> list = new ArrayList<>();
            
            while (rs.next()) {
                Despesa despesa = instantiateDespesa(rs);
                list.add(despesa);
            }
            return list;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharResultSet(rs);
        }
    }

    @Override
    public List<Despesa> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM despesas "
                    + "ORDER BY data_vencimento"
            );

            rs = st.executeQuery();

            List<Despesa> list = new ArrayList<>();

            while (rs.next()) {
                Despesa despesa = instantiateDespesa(rs);
                list.add(despesa);
            }
            return list;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharResultSet(rs);
        }
    }

     private Despesa instantiateDespesa(ResultSet rs) {
        try {
            Despesa despesa = new Despesa();
            despesa.setId(rs.getInt("Id"));
            despesa.setNome(rs.getString("Nome"));
            despesa.setPreco(rs.getDouble("Preco"));
            despesa.setStatus(rs.getString("Status"));
            despesa.setDataVencimento(rs.getDate("data_vencimento").toLocalDate());
            return despesa;
        } catch (SQLException ex) {
            throw new DBException(ex.getMessage());
        }
    }
}


