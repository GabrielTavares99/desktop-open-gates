package SistemaDesktop.model.dao;

import SistemaDesktop.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao implements IDao {
    private List<Aluno> alunos = new ArrayList<>();
    private static AlunoDao alunoDao;

    private AlunoDao() {

    }

    public static synchronized AlunoDao getInstance() {
        if (alunoDao == null)
            alunoDao = new AlunoDao();

        return alunoDao;
    }

    @Override
    public void cadastrar(Object o) {
        alunos.add((Aluno) o);
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.cadastrar(((Aluno) o).getUsuario());
    }

    @Override
    public void pegarTodas(Object o) {

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
