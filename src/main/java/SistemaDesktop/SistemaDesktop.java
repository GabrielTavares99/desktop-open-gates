package SistemaDesktop;

import SistemaDesktop.controller.EmailController;
import SistemaDesktop.view.telas.TelaFuncaoMatricula;

import java.util.ArrayList;
import java.util.List;

public class SistemaDesktop {
    public static void main(String[] args) {
//        new TelaLogin();
//        new TelaDashboard();
//        new TelaRedefinicaoSenha(TipoRedefinicaoSenha.REDEFINICAO_COM_SENHA);
//        new TelaFuncaoMatricula();

//        AlunoDao alunoDao = new AlunoDao();
//        Aluno aluno = new Aluno();
//        DisciplinaDao disciplinaDao = new DisciplinaDao();
//        Disciplina disciplina = new Disciplina();
//        disciplina.setSigla("ADS");
//        disciplinaDao.cadastrar(disciplina);
//        aluno.setRa(123);
//        alunoDao.cadastrar(aluno);
//        ProfessorDao professorDao = new ProfessorDao();
//        Professor professor = new Professor();
//        professor.setNumMatricula(String.valueOf(100));
//        professorDao.cadastrar(professor);
        List<String> objects = new ArrayList<>();
        objects.add("weverson.t@gmail.com");
//        objects.add("gabriel.tavares.silva99@gmail.com");

//        new EmailController().enviarEmail(objects);
        new TelaFuncaoMatricula();
    }
}
