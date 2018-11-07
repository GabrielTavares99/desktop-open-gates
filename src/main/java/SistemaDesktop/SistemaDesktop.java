package SistemaDesktop;

import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.dao.AlunoDao;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.view.telas.TelaFuncaoMatricula;
import SistemaTerminal.view.telas.TelaLeituraCarteirinha;

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
//        List<String> objects = new ArrayList<>();
//        objects.add("weverson.t@gmail.com");
//        objects.add("gabriel.tavares.silva99@gmail.com");

//        new EmailController().enviarEmail(objects);

        new Thread(() -> new TelaLeituraCarteirinha()).start();
        new Thread(() -> new TelaFuncaoMatricula()).start();


        // TODO: 06/11/18 TEMPORÁRIO
        Aluno aluno = new Aluno();
        aluno.setUsuario(new Usuario());
        aluno.getUsuario().setSenha(("123"));
        aluno.setNome("SUPER ADM");
        aluno.getUsuario().setEmail("adm");
        aluno.getUsuario().setTipoUsuario(TipoUsuario.ALUNO);
        new AlunoDao().cadastrar(aluno);
//        new TelaLogin();
    }
}
