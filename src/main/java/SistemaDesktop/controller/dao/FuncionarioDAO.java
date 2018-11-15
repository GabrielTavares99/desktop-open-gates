package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Funcionario;
import SistemaDesktop.model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static SistemaDesktop.util.DAOUtil.getPreparedStatement;

public class FuncionarioDAO implements IDao {
    @Override
    public Funcionario salvar(Object o) {
        Funcionario funcionario = (Funcionario) o;
        String query = "INSERT INTO (nome, fotoBase64, usuarioId, cargoId)\n" +
                "VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getFotoBase64());
            preparedStatement.setInt(3, funcionario.getUsuario().getId());
            preparedStatement.setInt(4, funcionario.getCargo().getId());
            int i = preparedStatement.executeUpdate();
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
    public Object monstarObjetoFromResultSet(ResultSet resultSet) {
        return null;
    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }

    public Pessoa findByEmail(String email) {
        return null;
    }
}
