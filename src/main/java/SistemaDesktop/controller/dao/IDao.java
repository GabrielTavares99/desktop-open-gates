package SistemaDesktop.controller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IDao {

    Object salvar(Object o);
    Object update(Object o);

    void atualizar(Object o);

    Object getById(int id);

    Object monstarObjetoFromResultSet(ResultSet resultSet) throws SQLException;

    List<Object> pegarTodos();

}
