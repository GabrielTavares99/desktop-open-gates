package SistemaDesktop.controller.dao;

import SistemaDesktop.model.ArquivoCredenciamentoAluno;
import SistemaDesktop.model.CredenciamentoAluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoCredenciamentoAlunoDAO implements IDao {

    private Connection connection = Conexao.getInstance().getConnection();
    private List<CredenciamentoAluno> credenciamentoAlunos = new ArrayList<>();

    @Override
    public ArquivoCredenciamentoAluno salvar(Object o) {
        ArquivoCredenciamentoAluno arquivoCredenciamentoAluno
                = (ArquivoCredenciamentoAluno) o;
        String query = "INSERT INTO ArquivoCredenciamentoAluno(nomeArquivoFotos, nomeArquivoCsv, qtdCredenciamentosFeitos, qtdTotal,quantidadeErros,data)\n" +
                "VALUES (?,?,?,?,?,?)";
        try {
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, arquivoCredenciamentoAluno.getNomeArquivoFotos());
            preparedStatement.setString(2, arquivoCredenciamentoAluno.getNomeArquivoCsv());
            preparedStatement.setInt(3, arquivoCredenciamentoAluno.getQtdCredenciamentosFeitos());
            preparedStatement.setInt(4, arquivoCredenciamentoAluno.getQtdTotal());
            preparedStatement.setInt(5, arquivoCredenciamentoAluno.getQuantidadeErros());
            Object dataEmTimestamp = new java.sql.Timestamp(arquivoCredenciamentoAluno.getData().getTime());
            preparedStatement.setObject(6, dataEmTimestamp);
            int i = preparedStatement.executeUpdate();
            return arquivoCredenciamentoAluno;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object update(Object o) {
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
    public ArquivoCredenciamentoAluno monstarObjetoFromResultSet(ResultSet resultSet) throws SQLException {
        ArquivoCredenciamentoAluno arquivoCredenciamentoAluno = new ArquivoCredenciamentoAluno();
        arquivoCredenciamentoAluno.setNomeArquivoFotos(resultSet.getString("nomeArquivoFotos"));
        arquivoCredenciamentoAluno.setNomeArquivoCsv(resultSet.getString("nomeArquivoCsv"));
        arquivoCredenciamentoAluno.setQtdCredenciamentosFeitos(resultSet.getInt("qtdCredenciamentosFeitos"));
        arquivoCredenciamentoAluno.setQtdTotal(resultSet.getInt("qtdTotal"));
        arquivoCredenciamentoAluno.setQuantidadeErros(resultSet.getInt("quantidadeErros"));
        arquivoCredenciamentoAluno.setData(resultSet.getDate("data"));
        return arquivoCredenciamentoAluno;
    }


    public List<ArquivoCredenciamentoAluno> pegarTodosImp() {
        String query = "SELECT * FROM ArquivoCredenciamentoAluno ORDER BY id DESC";
        List<ArquivoCredenciamentoAluno> arquivosCredenciamentoAluno = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arquivosCredenciamentoAluno.add(monstarObjetoFromResultSet(resultSet));
            }
            return arquivosCredenciamentoAluno;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }

    public List<CredenciamentoAluno> getAll() {
        return credenciamentoAlunos;
    }
}
