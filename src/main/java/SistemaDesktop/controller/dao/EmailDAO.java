package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Email;

import java.sql.*;
import java.util.List;

public class EmailDAO implements IDao {

    private final String NOME_TABLE = "Email";
    EmailAnexoDAO emailAnexoDAO = new EmailAnexoDAO();
    private Connection connection = Conexao.getInstance().getConnection();

    @Override
    public void salvar(Object o) {
        Email email = (Email) o;
        String query = String.format("INSERT INTO %s(html, destinatario, assunto) VALUES(?,?,?)", NOME_TABLE);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, email.getHmtl());
            preparedStatement.setString(2, email.getDestinatario());
            preparedStatement.setString(3, email.getAssunto());
            int affectedRows = preparedStatement.executeUpdate();
            long idEmail;
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idEmail = generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            for (String anexo : email.getAnexos()) {
                emailAnexoDAO.cadastrar(anexo, idEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Override
    public void atualizar(Object o) {
        Email email = (Email) o;
        String query = String.format("UPDATE %s\n" +
                "SET\n" +
                "  html = ?,\n" +
                "  destinatario = ?,\n" +
                "  assunto = ?,\n" +
                "  enviado = ?,\n" +
                "  dataEnvio = ?\n" +
                "WHERE id = ?;", NOME_TABLE);
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
        String query = String.format("SELECT e.id,e.html,e.destinatario,e.assunto,e.enviado FROM %s e WHERE enviado = false", NOME_TABLE);
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

                List<String> anexosByEmailId = emailAnexoDAO.getAnexosByEmailId(email.getId());
                email.setAnexos(anexosByEmailId);
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
