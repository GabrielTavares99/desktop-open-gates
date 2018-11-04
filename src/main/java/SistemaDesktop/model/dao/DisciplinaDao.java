package SistemaDesktop.model.dao;

import SistemaDesktop.model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao implements IDao {

    private static List<Disciplina> disciplinas = new ArrayList<>();

    @Override
    public void cadastrar(Object o) {
        disciplinas.add((Disciplina) o);
    }

    @Override
    public void pegarTodas(Object o) {

    }

    public Disciplina findBySigla(String sigla) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getSigla().equalsIgnoreCase(sigla))
                return disciplina;
        }
        return null;
    }

}
