
package com.mycompany.gestaofinance;

import BO.BOFactory;
import BO.DespesaBO;
import BO.UsuarioBO;
import DAO.DAOFactory;
import DAO.DespesaDAO;
import DAO.UsuarioDAO;
import DAO.impl.UsuarioDAOImpl;
import DataBase.DB;
import static DataBase.DB.getConexao;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.Despesa;
import model.Usuario;

public class GestaoFinance {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
     
        UsuarioBO usuarioBO = BOFactory.createUsuarioBO();
          
        String username = "Jao";
        String senha = "1234";
        
       if (usuarioBO.login(username, senha)) {
           System.out.println("logado");
       }else {
           System.out.println("acesso negado");
       }
    }
}
