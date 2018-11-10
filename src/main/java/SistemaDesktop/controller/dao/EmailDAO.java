package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmailDAO implements IDao {

    private Connection connection = Conexao.getInstance().getConnection();

    @Override
    public void salvar(Object o) {
        Email email = (Email) o;
        String query = "INSERT INTO EnvioEmail(html, destinatario, assunto) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email.getHmtl());
            preparedStatement.setString(2, email.getDestinatario());
            preparedStatement.setString(3, email.getAssunto());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Override
    public void atualizar(Object o) {
        Email email = (Email) o;
        String query = "UPDATE EnvioEmail\n" +
                "SET\n" +
                "  html = ?,\n" +
                "  destinatario = ?,\n" +
                "  assunto = ?,\n" +
                "  enviado = ?,\n" +
                "  dataEnvio = ?\n" +
                "WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email.getHmtl());
            preparedStatement.setString(2, email.getDestinatario());
            preparedStatement.setString(3, email.getAssunto());
            preparedStatement.setBoolean(4, email.isEnviado());
            Object dataEmTimestamp = new java.sql.Timestamp(email.getDataEnvio().getTime());
            preparedStatement.setObject(5, dataEmTimestamp);
            preparedStatement.setInt(6, email.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Email getEmailNaoEnviado() {
        String query = "SELECT * FROM EnvioEmail WHERE enviado = false";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Email email = new Email();
                email.setId(resultSet.getInt("id"));
                email.setHmtl(resultSet.getString("html"));
                email.setDestinatario(resultSet.getString("destinatario"));
                email.setAssunto(resultSet.getString("assunto"));
                email.setEnviado(resultSet.getBoolean("enviado"));
                return email;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }
}
