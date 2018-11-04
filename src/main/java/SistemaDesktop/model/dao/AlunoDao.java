package SistemaDesktop.model.dao;

import SistemaDesktop.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao implements IDao {
    List<Aluno> alunos = new ArrayList<>();

    @Override
    public void cadastrar(Object o) {

    }

    @Override
    public void listarTudo(Object o) {

    }

    public Aluno getByRa(int ra) {
        for (Aluno aluno : alunos) {
            if (aluno.getRa() == (ra))
                return aluno;
        }
        return null;
    }
}
