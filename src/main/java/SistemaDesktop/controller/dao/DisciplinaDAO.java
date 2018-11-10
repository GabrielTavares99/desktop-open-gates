package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO implements IDao {

    private static List<Curso> cursos = new ArrayList<>();

    @Override
    public void salvar(Object o) {
        cursos.add((Curso) o);
    }

    @Override
    public void atualizar(Object o) {

    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }

    public Curso findBySigla(String sigla) {
        for (Curso curso : cursos) {
            if (curso.getSigla().equalsIgnoreCase(sigla))
                return curso;
        }
        return null;
    }

}
