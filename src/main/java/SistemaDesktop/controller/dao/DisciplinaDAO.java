package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO implements IDao {

    private static List<Disciplina> disciplinas = new ArrayList<>();

    @Override
    public void salvar(Object o) {
        disciplinas.add((Disciplina) o);
    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }

    public Disciplina findBySigla(String sigla) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getSigla().equalsIgnoreCase(sigla))
                return disciplina;
        }
        return null;
    }

}
