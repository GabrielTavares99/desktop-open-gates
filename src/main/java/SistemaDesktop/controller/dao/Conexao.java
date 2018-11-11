package SistemaDesktop.controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static SistemaBatch.config.Settings.*;

public class Conexao {

    private static Conexao conexao;
    private Connection connection;

    private Conexao() {

    }

    public static synchronized Conexao getInstance() {
        if (conexao == null)
            conexao = new Conexao();
        return conexao;
    }

    public Connection getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL_BD, USER_BD, SENHA_BD);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
