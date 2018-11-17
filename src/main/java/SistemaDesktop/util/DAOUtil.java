package SistemaDesktop.util;

import SistemaDesktop.controller.dao.Conexao;

import java.sql.*;

public class DAOUtil {

    public static PreparedStatement getPreparedStatement(String query) throws SQLException {
        Connection connection = Conexao.getInstance().getConnection();
        return connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
