package SistemaDesktop.util;

import SistemaDesktop.controller.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUtil {

    public static PreparedStatement getPreparedStatement(String query) throws SQLException {
        Connection connection = Conexao.getInstance().getConnection();
        return connection.prepareStatement(query);
    }

    public static ResultSet executeSelectQuery(PreparedStatement preparedStatement) {
        try {
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
