package SistemaDesktop.model.dao;

import SistemaDesktop.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDao implements IDao {
    private static List<Professor> professores = new ArrayList<>();

    UsuarioDao usuarioDao = new UsuarioDao();

    @Override
    public void cadastrar(Object o) {
        professores.add((Professor) o);
    }

    @Override
    public void pegarTodas(Object o) {

    }

    public Professor findByMatricula(String matricula) {
        for (Professor professor : professores) {
            if (professor.getNumMatricula().equalsIgnoreCase(matricula)) {
                return professor;
            }
        }
        return null;
    }

    public Professor findByEmail(String email) {
        for (Professor professor : professores) {
            if (professor.getUsuario().getEmail().equalsIgnoreCase(email)) {
                return professor;
            }
        }
        return null;
    }

}
