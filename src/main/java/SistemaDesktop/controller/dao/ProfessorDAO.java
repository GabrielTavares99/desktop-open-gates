package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements IDao {
    private static List<Professor> professores = new ArrayList<>();

    private UsuarioDAO usuarioDao = new UsuarioDAO();

    @Override
    public void salvar(Object o) {
        professores.add((Professor) o);
    }

    @Override
    public void atualizar(Object o) {

    }

    @Override
    public List<Object> pegarTodos() {
        return null;
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
