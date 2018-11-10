package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Matricula;

import java.util.ArrayList;
import java.util.List;

public class MatriculaDao implements IDao {

    private List<Matricula> matriculas = new ArrayList<>();

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


    public boolean cadastrar(Matricula matricula) {
        matriculas.add(matricula);
        return true;
    }

    public List<Matricula> getAll() {
        return matriculas;
    }
}
