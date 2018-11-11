package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Funcionario;
import SistemaDesktop.model.Pessoa;

import java.sql.ResultSet;
import java.util.List;

public class FuncionarioDAO implements IDao {
    @Override
    public Funcionario salvar(Object o) {
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
