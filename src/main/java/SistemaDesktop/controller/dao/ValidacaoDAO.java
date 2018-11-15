package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Pessoa;
import SistemaDesktop.model.enums.AcaoPortaria;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.DataUtil;
import SistemaTerminal.model.Validacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Validacao> getValidacoesByTipoUsuario(TipoUsuario tipoUsuario, Date dtInicial, Date dtFinal) {
        //-- BUSCA POR TIPO USUÁRIO - DATA INICIAL/FINAL - LIMIT 20
        List<Validacao> validacaos = new ArrayList<>();
        String query = "SELECT v.acao, v.data, v.permitida, u.tipoUsuario, u.cpf, u.email FROM Validacao v " +
                "inner join Usuario u on v.usuarioId = u.id  " +
                "WHERE u.tipoUsuario = ? AND data between ? and ? " +
                "ORDER BY id desc LIMIT 20";
        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            preparedStatement.setString(1, String.valueOf(tipoUsuario));
            preparedStatement.setDate(2, DataUtil.dataUtilToSqlDate(dtInicial));
            preparedStatement.setDate(3, DataUtil.dataUtilToSqlDate(dtFinal));
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            while (resultSet.next()) {
                validacaos.add(monstarObjetoFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return validacaos;
    }

    public List<Validacao> getValidacoes(Date dtInicial, Date dtFinal) {
        //-- BUSCA DATA INICIAL/FINAL - LIMIT 20
        List<Validacao> validacaos = new ArrayList<>();
        String query = "SELECT u.cpf, v.acao, v.data, v.permitida, u.tipoUsuario FROM Validacao v " +
                "inner join Usuario u on v.usuarioId = u.id  " +
                "WHERE data between date(?) and date(?) " +
                "ORDER BY v.id desc LIMIT 20";
        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            preparedStatement.setDate(1, DataUtil.dataUtilToSqlDate(dtInicial));
            preparedStatement.setDate(2, DataUtil.dataUtilToSqlDate(dtFinal));
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            while (resultSet.next()) {
                validacaos.add(monstarObjetoFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return validacaos;
    }

    public List<Validacao> getValidacoesByTipoUsuarioCpfNome(Pessoa pessoa, Date dtInicial, Date dtFinal) {
//      -- BUSCA POR CPF, NOME - LIMIT 20
        List<Validacao> validacaos = new ArrayList<>();
        String query = "    SELECT v.acao, v.data, v.permitida, u.tipoUsuario, u.cpf, u.email, u.id FROM Validacao v\n" +
                "    inner join Usuario u on (v.usuarioId = u.id) \n" +
                "    where tipoUsuario = ?\n" +
                "    and data between ? and ?\n" +
                "    and ( nome LIKE ? or cpf >= ?)\n" +
                "    ORDER BY id desc LIMIT 20";
        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            preparedStatement.setString(1, pessoa.getUsuario().getTipoUsuario().toString());
            preparedStatement.setDate(2, DataUtil.dataUtilToSqlDate(dtInicial));
            preparedStatement.setDate(3, DataUtil.dataUtilToSqlDate(dtFinal));
            preparedStatement.setString(4, pessoa.getNome());
            preparedStatement.setString(5, pessoa.getUsuario().getCpf());
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            while (resultSet.next()) {
                validacaos.add(monstarObjetoFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return validacaos;
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
    public Validacao monstarObjetoFromResultSet(ResultSet resultSet) throws SQLException {
        Validacao validacao = new Validacao();
        validacao.getPessoa().getUsuario().setCpf(resultSet.getString("cpf"));
        validacao.setAcaoPortaria(AcaoPortaria.valueOf(resultSet.getString("acao")));
        validacao.setData(resultSet.getDate("data"));
        validacao.setPermitida(resultSet.getBoolean("permitida"));
        validacao.getPessoa().getUsuario().setTipoUsuario(TipoUsuario.valueOf(resultSet.getString("tipoUsuario")));
        return validacao;
    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }
}
