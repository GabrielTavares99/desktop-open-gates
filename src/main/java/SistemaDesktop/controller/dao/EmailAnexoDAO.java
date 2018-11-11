package SistemaDesktop.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailAnexoDAO {

    private Connection connection = Conexao.getInstance().getConnection();

    public List<String> getAnexosByEmailId(long emailId) {
        String query = String.format("SELECT caminhoAnexo FROM %s WHERE emailId = ?", "EmailAnexo");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, emailId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> paths = new ArrayList<>();
            while (resultSet.next()) {
                paths.add(resultSet.getString("caminhoAnexo"));
            }
            return paths;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cadastrar(String path, long emailId) {

        String query = String.format(
                "INSERT INTO EmailAnexo (caminhoAnexo, emailId) VALUES (?,?)");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, path);
            preparedStatement.setLong(2, emailId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
