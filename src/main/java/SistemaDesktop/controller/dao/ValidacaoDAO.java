package SistemaDesktop.controller.dao;

import SistemaDesktop.model.enums.AcaoPortaria;
import SistemaTerminal.model.Validacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import static SistemaDesktop.util.DAOUtil.executeSelectQuery;
import static SistemaDesktop.util.DAOUtil.getPreparedStatement;

public class ValidacaoDAO implements IDao {


    @Override
    public Object salvar(Object o) {
        Validacao validacao = (Validacao) o;
        String query = "INSERT INTO Validacao(usuarioId, acao, mensagem, permitida,data)\n" +
                "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            if (validacao.getPessoa().getUsuario().getId() != null)
                preparedStatement.setInt(1, validacao.getPessoa().getUsuario().getId());
            else
                preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setString(2, validacao.getAcaoPortaria().toString());
            preparedStatement.setString(3, validacao.getMensagem());
            preparedStatement.setBoolean(4, validacao.isPermitida());
            Object dataEmTimestamp = new java.sql.Timestamp(validacao.getData().getTime());
            preparedStatement.setObject(5, dataEmTimestamp);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AcaoPortaria getUltimaAcaoByUsuarioId(int usuarioId) {
        String query = "SELECT acao from Validacao where usuarioId = ? ORDER BY id DESC LIMIT 1";
        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            preparedStatement.setInt(1, usuarioId);
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            while (resultSet.next()) {
                return AcaoPortaria.valueOf(resultSet.getString("acao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void atualizar(Object o) {

    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Object monstarObjetoFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }
}
