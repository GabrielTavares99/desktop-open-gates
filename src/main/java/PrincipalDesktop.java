import SistemaDesktop.view.telas.TelaCadastroFuncionario;
import SistemaDesktop.view.telas.TelaLogin;
import SistemaDesktop.view.telas.TelaMatricula;
import SistemaDesktop.view.telas.TelaRelatorioEntradaSaida;

import java.io.File;

public class PrincipalDesktop {
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

//        new TelaLogin();
        boolean mkdirs = new File("/tmp/opengates/qrcode").mkdirs();
        System.out.println("CRIOU DIRETORIOS "+ mkdirs);
        new TelaCadastroFuncionario();
//        new TelaMatricula();
//        new TelaRelatorioEntradaSaida();
//        new TelaCadastroFuncionario();
    }
}
