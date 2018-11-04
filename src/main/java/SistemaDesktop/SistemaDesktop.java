package SistemaDesktop;

import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.Disciplina;
import SistemaDesktop.model.Professor;
import SistemaDesktop.model.dao.AlunoDao;
import SistemaDesktop.model.dao.DisciplinaDao;
import SistemaDesktop.model.dao.ProfessorDao;
import SistemaDesktop.view.telas.TelaFuncaoMatricula;

public class SistemaDesktop {
    public static void main(String[] args) {
//        new TelaLogin();
//        new TelaDashboard();
//        new TelaRedefinicaoSenha(TipoRedefinicaoSenha.REDEFINICAO_COM_SENHA);
//        new TelaFuncaoMatricula();

        AlunoDao alunoDao = new AlunoDao();
        Aluno aluno = new Aluno();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        Disciplina disciplina = new Disciplina();
        disciplina.setSigla("ADS");
        disciplinaDao.cadastrar(disciplina);
        aluno.setRa(123);
        alunoDao.cadastrar(aluno);
        ProfessorDao professorDao = new ProfessorDao();
        Professor professor = new Professor();
        professor.setNumMatricula(String.valueOf(100));
        professorDao.cadastrar(professor);
        new TelaFuncaoMatricula();
    }
}
