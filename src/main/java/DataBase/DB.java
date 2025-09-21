
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

        private static final String DRIVE_MYSQL = "com.mysql.cj.jdbc.Driver";
        private static final String ENDERECO = "jdbc:mysql://localhost:3306/teste5";
        private static final String USUARIO = "root";
        private static final String SENHA = "382428";
        
        private static Connection conn = null;
       
        public static Connection getConexao() {

            try {
                Class.forName(DRIVE_MYSQL);
                try {
                    conn = DriverManager.getConnection(ENDERECO, USUARIO, SENHA);
                } catch (SQLException ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
                return conn;

            } catch (ClassNotFoundException ex) {

                ex.printStackTrace();

                throw new RuntimeException("Erro ao estabelecer uma conexao com o banco");
            }
        }

        public static void fecharConexao() {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar uma conexao com o banco");
            }

        }

        public static void fecharStatement(PreparedStatement stmt) {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar uma conexao com o banco");
            }

        }

        public static void fecharResultSet(ResultSet rs) {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar uma conexao com o banco");
            }

        }
        
        public void criarTabelas(){
        getConexao();
        String tablaUsuarios = "CREATE TABLE IF NOT EXISTS Usuario (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, senha VARCHAR(255) NOT NULL)";
         String tablaDespesas = "CREATE TABLE IF NOT EXISTS Despesas" + "(id int Primary key AUTO_INCREMENT, nome VARCHAR(255), preco float, status VARCHAR(255), data_vencimento DATE NOT NULL)";
             
        try {
            conn.prepareStatement(tablaUsuarios).execute();
            conn.prepareStatement(tablaDespesas).execute();
        } catch (SQLException ex) {
            ex.getMessage();
        } finally{
            fecharConexao();
        }
    }
    }
    
    
    
