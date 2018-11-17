package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Cargo;
import SistemaDesktop.model.Funcionario;
import SistemaDesktop.model.Pessoa;
import SistemaDesktop.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.util.DAOUtil.getPreparedStatement;

public class FuncionarioDAO implements IDao {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    public Funcionario salvar(Object o) {
        Funcionario funcionario = (Funcionario) o;
        String query = "INSERT INTO Funcionario(nome, fotoBase64, usuarioId, cargoId) " +
                "VALUES (?,?,?,?)";

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            funcionario.setUsuario(usuarioDAO.salvar(funcionario.getUsuario()));

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
        Funcionario funcionario = (Funcionario) o;
        String query = "UPDATE Funcionario " +
                "SET nome = ?, " +
                "fotoBase64 = ?, " +
                "cargoId = ? " +
                "WHERE id = ?";
        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getFotoBase64());
            preparedStatement.setInt(3, funcionario.getCargo().getId());
            preparedStatement.setInt(4, funcionario.getId());
            int i = preparedStatement.executeUpdate();
            Object update = usuarioDAO.update(funcionario.getUsuario());
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

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(resultSet.getString("nome"));
        funcionario.setFotoBase64(resultSet.getString("fotoBase64"));
        funcionario.setId(resultSet.getInt("id"));

        int cargoId = resultSet.getInt("cargoId");
        CargoDAO cargoDAO = new CargoDAO();
        Cargo cargo = cargoDAO.getById(cargoId);
        funcionario.setCargo(cargo);

        int usuarioId = resultSet.getInt("usuarioId");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.getById(usuarioId);
        funcionario.setUsuario(usuario);
        usuario.setPessoa(funcionario);

        return funcionario;
    }

    @Override
    public List<Object> pegarTodos() {
        List<Object> funcionarios = new ArrayList<>();
        String query = "SELECT id,nome, cargoId,fotoBase64, cargoId,usuarioId FROM Funcionario";
        try {
            PreparedStatement preparedStatement = getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                funcionarios.add(monstarObjetoFromResultSet(resultSet));
            }
            return funcionarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Pessoa findByEmail(String email) {
        return null;
    }
}
