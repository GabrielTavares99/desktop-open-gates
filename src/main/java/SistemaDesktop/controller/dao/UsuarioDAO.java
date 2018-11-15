package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.CriptografiaUtil;

import java.sql.*;
import java.util.List;

import static SistemaDesktop.controller.dao.SettingsDAO.TB_USUARIO;
import static SistemaDesktop.util.DAOUtil.executeSelectQuery;
import static SistemaDesktop.util.DAOUtil.getPreparedStatement;

public class UsuarioDAO implements IDao {

    private Connection connection = Conexao.getInstance().getConnection();

    @Override
    public Usuario salvar(Object o) {
        Usuario usuario = (Usuario) o;
        String uuid = CriptografiaUtil.generateUUID();
        if (usuario.getSenha() == null)
            usuario.setSenha(uuid);
        String senhaEmMD5 = CriptografiaUtil.gerarMD5(usuario.getSenha());
        usuario.setSenha(senhaEmMD5);
        String codigoEmail = uuid.substring(0, 5);
        usuario.setCodigoEmail(codigoEmail);
        System.out.println("CODIGO EMAIL " + usuario.getCodigoEmail());
        String sql = String.format(
                "INSERT INTO %s (email,senha,acessaSistema,tipoUsuario,codigoEmail,cpf)" +
                        "VALUES (?,?,?,?,?,?)", TB_USUARIO);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setBoolean(3, usuario.isAcessaSistema());
            preparedStatement.setString(4, usuario.getTipoUsuario().toString());
            preparedStatement.setString(5, usuario.getCodigoEmail());
            preparedStatement.setString(6, usuario.getCpf());
            int linesAfetadas = preparedStatement.executeUpdate();
            int idUsuario;
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idUsuario = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            usuario.setId(idUsuario);
            return usuario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void atualizar(Object o) {

    }

    @Override
    public Usuario getById(int id) {
        String query = "SELECT * FROM Usuario WHERE id = ? LIMIT 1";
        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            while (resultSet.next()) {
                return monstarObjetoFromResultSet(resultSet);
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

    public Usuario getByEmail(String email) {
        String query = "SELECT * FROM Usuario WHERE email = ?";
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


    public Usuario getByCpf(String cpf) {

        String query = "SELECT * FROM Usuario WHERE cpf = ?";
        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            while (resultSet.next()) {
                return monstarObjetoFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Usuario monstarObjetoFromResultSet(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("id"));
        usuario.setAcessaSistema(resultSet.getBoolean("acessaSistema"));
        usuario.setTipoUsuario(TipoUsuario.valueOf(resultSet.getString("tipoUsuario")));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setCodigoEmail(resultSet.getString("codigoEmail"));
        usuario.setSenha(resultSet.getString("senha"));
        usuario.setCpf(resultSet.getString("cpf"));
        return usuario;
    }

}
