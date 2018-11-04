package SistemaDesktop.model.dao;

import SistemaDesktop.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDao implements IDao {
    List<Professor> professores = new ArrayList<>();

    @Override
    public void cadastrar(Object o) {

    }

    @Override
    public void listarTudo(Object o) {

    }

    public Professor findByMatricula(String matricula) {
        for (Professor professor : professores) {
            if (professor.getRa().equalsIgnoreCase(matricula)) {
                return professor;
            }
        }
        return null;

    }

}
