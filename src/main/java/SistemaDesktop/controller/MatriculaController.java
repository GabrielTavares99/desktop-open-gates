package SistemaDesktop.controller;

import SistemaDesktop.controller.dao.*;
import SistemaDesktop.model.*;
import SistemaDesktop.model.enums.Periodo;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.CsvUtil;
import SistemaDesktop.util.ImageUtil;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.util.ZipUtil;
import org.apache.commons.mail.EmailException;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MatriculaController {

    DisciplinaDAO disciplinaDao;
    UsuarioDAO usuarioDao;
    AlunoDAO alunoDao;
    ProfessorDAO professorDao;
    MatriculaDao matriculaDao;

    public MatriculaController() {
        disciplinaDao = new DisciplinaDAO();
        usuarioDao = new UsuarioDAO();
        alunoDao = AlunoDAO.getInstance();
        professorDao = new ProfessorDAO();
        matriculaDao = new MatriculaDao();
    }


    public void fazerMatricula() throws IOException {
        List<Matricula> matriculas = new ArrayList<>();
        List<Map<String, String>> linhasCSV = CsvUtil.lerCSV(TelasUtil.URL_CSV);

        ZipUtil.unzip(TelasUtil.URL_ARQUIVO_FOTOS, "/tmp");

        for (Map<String, String> line : linhasCSV) {
            System.out.println(line);
            Matricula matricula = new Matricula();

            String sigla = line.get("sigla_disciplina");
            Disciplina disciplina = disciplinaDao.findBySigla(sigla);
            matricula.setDisciplina(disciplina);

            String ra_aluno = line.get("ra_aluno");
            Aluno aluno = alunoDao.getByRa(Integer.parseInt(ra_aluno));
            if (aluno == null) {
                Aluno aluno1 = new Aluno();
                aluno1.setRa(Integer.parseInt(ra_aluno));
                aluno1.getUsuario().setEmail(line.get("e-mail"));
                aluno1.getUsuario().setTipoUsuario(TipoUsuario.ALUNO);
                aluno1.setNome(line.get("nome_aluno"));
                String a = TelasUtil.URL_ARQUIVO_FOTOS.replace(".zip", "");
                File foto = new File("/tmp/" + new File(a).getName() + "/" + aluno1.getRa() + ".jpg");
                aluno1.setFotoBase64(ImageUtil.fromImageToBase64(foto.getAbsolutePath()));
                alunoDao.salvar(aluno1);
                Email email = new Email();
                email.setAssunto("VOCÊ FOI MATRICULADO");
                ArrayList<String> objects = new ArrayList<>();
                objects.add(aluno1.getUsuario().getEmail());
                email.setDestinatarios(objects);
                File file = new File(MatriculaController.class.getClassLoader().getResource("novo-login.html").getPath());
                byte[] htmlEmail = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
                String htmlEmTexto = new String(htmlEmail, "utf8");
                htmlEmTexto = String.format(htmlEmTexto, aluno1.getNome(), aluno1.getUsuario().getCodigoEmail());
                email.setHmtl(htmlEmTexto);
                try {
                    new EmailController().sendEmail(email);
                } catch (EmailException e) {
                    e.printStackTrace();
                }
            }
            matricula.setAluno(aluno);

            String matricula_professor = line.get("matricula_professor");
            Professor professor = professorDao.findByMatricula(matricula_professor);
            matricula.setProfessor(professor);

            matricula.setSemestre(Integer.parseInt(line.get("semestre")));
            matricula.setAno(Integer.parseInt(line.get("ano")));
            matricula.setPeriodo(Periodo.valueOf(line.get("periodo")));
            matricula.setDataRealizacao(new Date());
            matriculaDao.cadastrar(matricula);
        }
        JOptionPane.showMessageDialog(null, "CADASTRO FEITO COM SUCESSO!");
    }

    public void enviaEmailsMatricula(List<String> emails) {

        EmailController emailController = new EmailController();

    }

}
