package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Pessoa;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.AcaoPortaria;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.DataUtil;
import SistemaTerminal.model.Validacao;

import java.sql.*;
import java.util.*;
import java.util.Date;

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

    @Override
    public Object update(Object o) {
        return null;
    }

    public List<Validacao> getValidacoesByTipoUsuario(TipoUsuario tipoUsuario, Date dtInicial, Date dtFinal) {
        //-- BUSCA POR TIPO USUÁRIO - DATA INICIAL/FINAL - LIMIT 50
        List<Validacao> validacaos = new ArrayList<>();
        String query = "SELECT u.cpf, v.acao, v.data, v.permitida, u.tipoUsuario, u.id, CONCAT(COALESCE(a.nome,''), COALESCE(f.nome,'')) nome FROM Validacao v " +
                " inner join Usuario u on v.usuarioId = u.id  " +
                "                left JOIN Funcionario f ON u.id = f.usuarioId" +
                "                left JOIN Aluno a ON u.id = a.usuarioId" +
                " WHERE u.tipoUsuario = ? AND data between ? and ? " +
                " ORDER BY v.id desc LIMIT 50";
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
        String query = "SELECT u.cpf, v.acao, v.data, v.permitida, u.tipoUsuario, u.id, CONCAT(COALESCE(a.nome,''), COALESCE(f.nome,'')) nome FROM Validacao v " +
                "inner join Usuario u on v.usuarioId = u.id  " +
                "                left JOIN Funcionario f ON u.id = f.usuarioId" +
                "                left JOIN Aluno a ON u.id = a.usuarioId " +
                " WHERE data between date(?) and date(?) " +
                " ORDER BY v.id desc LIMIT 50";
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
        String query = "SELECT acao from Validacao where usuarioId = ? ORDER BY id DESC";
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
        ResultSetMetaData metaData = resultSet.getMetaData();
        int qtd = metaData.getColumnCount();
        Set<String> colunas = new HashSet<>();
        for (int i = 1; i <= qtd; i++) {
            colunas.add(metaData.getColumnName(i));
        }
        Validacao validacao = new Validacao();
        if (colunas.contains("cpf"))
            validacao.getPessoa().getUsuario().setCpf(resultSet.getString("cpf"));
        validacao.setAcaoPortaria(AcaoPortaria.valueOf(resultSet.getString("acao")));
        validacao.setData(resultSet.getDate("data"));
        validacao.setPermitida(resultSet.getBoolean("permitida"));
        if (colunas.contains("nome"))
            validacao.getPessoa().setNome(resultSet.getString("nome"));
        if (colunas.contains("tipoUsuario"))
            validacao.getPessoa().getUsuario().setTipoUsuario(TipoUsuario.valueOf(resultSet.getString("tipoUsuario")));
        return validacao;
    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }

    public List<Validacao> getValidacoesIndividuais(Usuario usuario, Date date, Date date1) {

        String query = "SELECT v.acao, v.data, v.permitida FROM Validacao v where usuarioId = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPreparedStatement(query);
            preparedStatement.setInt(1, usuario.getId());
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            List<Validacao> validacaos = new ArrayList<>();
            while (resultSet.next())
                validacaos.add(monstarObjetoFromResultSet(resultSet));
            return validacaos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
