package SistemaDesktop;

import SistemaDesktop.controller.dao.AlunoDAO;
import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.view.telas.TelaMatricula;

public class SistemaDesktop {
    public static void main(String[] args) {
//        new TelaLogin();
//        new TelaDashboard();
//        new TelaRedefinicaoSenha(TipoRedefinicaoSenha.REDEFINICAO_COM_SENHA);
//        new TelaMatricula();

//        AlunoDAO alunoDao = new AlunoDAO();
//        Aluno aluno = new Aluno();
//        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
//        Curso disciplina = new Curso();
//        disciplina.setSigla("ADS");
//        disciplinaDao.salvar(disciplina);
//        aluno.setRa(123);
//        alunoDao.salvar(aluno);
//        ProfessorDAO professorDao = new ProfessorDAO();
//        Professor professor = new Professor();
//        professor.setNumMatricula(String.valueOf(100));
//        professorDao.salvar(professor);
//        List<String> objects = new ArrayList<>();
//        objects.add("weverson.t@gmail.com");
//        objects.add("gabriel.tavares.silva99@gmail.com");

//        new EmailController().enviarEmail(objects);

//        new Thread(() -> new TelaLeituraCarteirinha()).start();
//        new Thread(() -> new TelaMatricula()).start();


        // TODO: 06/11/18 TEMPORÁRIO
        Aluno aluno = new Aluno();
        aluno.setUsuario(new Usuario());
        aluno.getUsuario().setSenha(("123"));
        aluno.setNome("SUPER ADM");
        aluno.getUsuario().setEmail("adm");
        aluno.getUsuario().setTipoUsuario(TipoUsuario.SECRETARIA);
        AlunoDAO.getInstance().salvar(aluno);
//        new TelaLogin();
        new TelaMatricula();
//        new TelaRelatorioEntradaSaida();
    }
}
