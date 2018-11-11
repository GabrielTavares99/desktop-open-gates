package SistemaDesktop.controller.dao;

import SistemaDesktop.model.CredenciamentoAluno;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CredenciamentoAlunoDAO implements IDao {

    private List<CredenciamentoAluno> credenciamentoAlunos = new ArrayList<>();

    @Override
    public CredenciamentoAluno salvar(Object o) {
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


    public boolean cadastrar(CredenciamentoAluno credenciamentoAluno) {
        credenciamentoAlunos.add(credenciamentoAluno);
        return true;
    }

    public List<CredenciamentoAluno> getAll() {
        return credenciamentoAlunos;
    }
}
