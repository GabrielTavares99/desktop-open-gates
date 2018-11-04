package SistemaDesktop.model.dao;

import SistemaDesktop.model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao implements IDao {

    List<Disciplina> disciplinas = new ArrayList<>();

    @Override
    public void cadastrar(Object o) {

    }

    @Override
    public void listarTudo(Object o) {

    }

    public Disciplina findBySigla(String sigla){
        for (Disciplina disciplina: disciplinas) {
            if (disciplina.getSigla().equalsIgnoreCase(sigla))
                return disciplina;
        }
        return null;
    }

}
