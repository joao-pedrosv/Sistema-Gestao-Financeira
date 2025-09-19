package DAO.impl;

import DAO.UsuarioDAO;
import DataBase.DB;
import DataBase.DBException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection conn;

    public UsuarioDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Usuario usuario) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO usuario "
                    + "(Username, Senha) "
                    + "VALUES "
                    + "(?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, usuario.getUsername());
            st.setString(2, usuario.getSenha());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    usuario.setId(id);
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
    public void update(Usuario usuario) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE usuario "
                    + "SET Username = ?, Senha = ? "
                    + "WHERE Id = ?"
            );

            st.setString(1, usuario.getUsername());
            st.setString(2, usuario.getSenha());
            st.setInt(3, usuario.getId());

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
                    "DELETE FROM usuario "
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
    public boolean login(String username, String senha) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM usuario WHERE username = ? AND senha = ?");

            st.setString(1, username);
            st.setString(2, senha);

            rs = st.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }
}
