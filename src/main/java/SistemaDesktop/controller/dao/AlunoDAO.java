package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO implements IDao {
    private static AlunoDAO alunoDao;
    private List<Aluno> alunos = new ArrayList<>();

    private AlunoDAO() {

    }

    public static synchronized AlunoDAO getInstance() {
        if (alunoDao == null)
            alunoDao = new AlunoDAO();
        return alunoDao;
    }

    @Override
    public void salvar(Object o) {
        alunos.add((Aluno) o);
        UsuarioDAO usuarioDao = new UsuarioDAO();
        usuarioDao.salvar(((Aluno) o).getUsuario());
    }

    @Override
    public void atualizar(Object o) {

    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }

    public Aluno getByRa(int ra) {
        for (Aluno aluno : alunos) {
            if (aluno.getRa() == (ra))
                return aluno;
        }
        return null;
    }

    public Aluno getByEmail(String email) {
        for (Aluno aluno : alunos) {
            if (aluno.getUsuario().getEmail().equalsIgnoreCase(email))
                return aluno;
        }
        return null;
    }
}
