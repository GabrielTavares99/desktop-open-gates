package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Cargo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.util.DAOUtil.executeSelectQuery;
import static SistemaDesktop.util.DAOUtil.getPreparedStatement;

public class CargoDAO implements IDao {

    private Connection connection = Conexao.getInstance().getConnection();

    @Override
    public Object salvar(Object o) {
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
    public Cargo getById(int id) {

        String query = "SELECT id,descricao FROM Cargo where id = ? LIMIT 1";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPreparedStatement(query);
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
    public Cargo monstarObjetoFromResultSet(ResultSet resultSet) throws SQLException {
        Cargo cargo = new Cargo();
        cargo.setId(resultSet.getInt("id"));
        cargo.setDescricao(resultSet.getString("descricao"));
        return cargo;
    }


    @Override
    public List<Object> pegarTodos() {
        String query = "SELECT * FROM Cargo";
        PreparedStatement preparedStatement = null;
        List<Object> cargos = new ArrayList<>();
        try {
            preparedStatement = getPreparedStatement(query);
            ResultSet resultSet = executeSelectQuery(preparedStatement);
            while (resultSet.next()) {
                cargos.add(monstarObjetoFromResultSet(resultSet));
            }
            return cargos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
