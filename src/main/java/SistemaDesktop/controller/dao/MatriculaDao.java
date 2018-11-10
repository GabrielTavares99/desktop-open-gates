package SistemaDesktop.controller.dao;

import SistemaDesktop.model.CredenciamentoAluno;

import java.util.ArrayList;
import java.util.List;

public class MatriculaDao implements IDao {

    private List<CredenciamentoAluno> credenciamentoAlunos = new ArrayList<>();

    @Override
    public void salvar(Object o) {

    }

    @Override
    public void atualizar(Object o) {

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
