package SistemaDesktop.model;

import SistemaDesktop.model.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class MatriculaDao implements IDao {

    private List<Matricula> matriculas = new ArrayList<>();

    @Override
    public void cadastrar(Object o) {

    }

    @Override
    public void pegarTodas(Object o) {

    }


    public boolean cadastrar(Matricula matricula) {
        matriculas.add(matricula);
        return true;
    }

    public List<Matricula> getAll() {
        return matriculas;
    }
}
