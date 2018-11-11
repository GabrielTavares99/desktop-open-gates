package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.Usuario;

import java.sql.*;
import java.util.List;

import static SistemaDesktop.controller.dao.SettingsDAO.TB_ALUNO;
import static SistemaDesktop.util.DAOUtil.executeSelectQuery;
import static SistemaDesktop.util.DAOUtil.getPreparedStatement;

public class AlunoDAO implements IDao {
    private static AlunoDAO alunoDao;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Connection connection = Conexao.getInstance().getConnection();

    public static synchronized AlunoDAO getInstance() {
        if (alunoDao == null)
            alunoDao = new AlunoDAO();
        return alunoDao;
    }

    @Override
    public Aluno salvar(Object o) {
        Aluno aluno = (Aluno) o;
        String sql = String.format(
                "INSERT INTO %s (nome,fotoBase64,usuarioId) VALUES (?,?,?)", TB_ALUNO);
        try {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            aluno.setUsuario(usuarioDao.salvar(aluno.getUsuario()));

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getFotoBase64());
            preparedStatement.setInt(3, aluno.getUsuario().getId());
            preparedStatement.executeUpdate();

            int idAluno;
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idAluno = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            aluno.setId(idAluno);
            return aluno;
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
    public List<Object> pegarTodos() {
        return null;
    }

    public Aluno getByRa(int ra) {
        String query = "SELECT id,nome,fotoBase64,usuarioId,ra FROM Aluno WHERE ra = ?";
        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            preparedStatement.setInt(1, ra);
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            while (resultSet.next()) {
                return monstarObjetoFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Aluno getByEmail(String email) {

        String query = "SELECT a.id,a.nome,a.fotoBase64,a.ra, a.usuarioId FROM Aluno a INNER JOIN Usuario u on a.usuarioId  = u.id WHERE u.email = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getPreparedStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            while (resultSet.next())
                return monstarObjetoFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Aluno monstarObjetoFromResultSet(ResultSet resultSet) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setId(resultSet.getInt("id"));
        aluno.setRa(resultSet.getInt("ra"));
        aluno.setFotoBase64(resultSet.getString("fotoBase64"));
        aluno.setNome(resultSet.getString("nome"));
        Usuario usuario = usuarioDAO.getById(resultSet.getInt("usuarioId"));
        aluno.setUsuario(usuario);
        return aluno;
    }
}
