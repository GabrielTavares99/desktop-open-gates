package SistemaDesktop.controller;

import SistemaBatch.controller.EmailController;
import SistemaDesktop.controller.dao.*;
import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.CredenciamentoAluno;
import SistemaDesktop.model.Curso;
import SistemaDesktop.model.Email;
import SistemaDesktop.model.enums.Periodo;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MatriculaController {

    DisciplinaDAO disciplinaDao;
    UsuarioDAO usuarioDao;
    AlunoDAO alunoDao;
    MatriculaDao matriculaDao;

    public MatriculaController() {
        disciplinaDao = new DisciplinaDAO();
        usuarioDao = new UsuarioDAO();
        alunoDao = AlunoDAO.getInstance();
        matriculaDao = new MatriculaDao();
    }


    public void fazerMatricula() throws IOException {
        List<CredenciamentoAluno> credenciamentoAlunos = new ArrayList<>();
        List<Map<String, String>> linhasCSV = CsvUtil.lerCSV(TelasUtil.URL_CSV);
        EmailDAO emailDAO = new EmailDAO();

        ZipUtil.unzip(TelasUtil.URL_ARQUIVO_FOTOS, "/tmp");

        for (Map<String, String> line : linhasCSV) {
            System.out.println(line);
            CredenciamentoAluno credenciamentoAluno = new CredenciamentoAluno();

            String sigla = line.get("sigla_disciplina");
            Curso curso = disciplinaDao.findBySigla(sigla);
            credenciamentoAluno.setCurso(curso);

            String ra_aluno = line.get("ra_aluno");
            Aluno aluno = alunoDao.getByRa(Integer.parseInt(ra_aluno));
            if (aluno == null) {
                Aluno novoAluno = new Aluno();
                novoAluno.setRa(Integer.parseInt(ra_aluno));
                novoAluno.getUsuario().setEmail(line.get("e-mail"));
                novoAluno.getUsuario().setTipoUsuario(TipoUsuario.ALUNO);
                novoAluno.setNome(line.get("nome_aluno"));
                String a = TelasUtil.URL_ARQUIVO_FOTOS.replace(".zip", "");
                File foto = new File(String.format("/tmp/%s/%s.jpg", new File(a).getName(), novoAluno.getRa()));
                novoAluno.setFotoBase64(ImageUtil.fromImageToBase64(foto.getAbsolutePath()));
                alunoDao.salvar(novoAluno);

                Email email = fazerEmailBoasVindas(novoAluno);
                emailDAO.salvar(email);
                email = fazerEmailQrCode(novoAluno);
                emailDAO.salvar(email);
            }
            credenciamentoAluno.setAluno(aluno);

            credenciamentoAluno.setSemestre(Integer.parseInt(line.get("semestre")));
            credenciamentoAluno.setPeriodo(Periodo.valueOf(line.get("periodo")));
            credenciamentoAluno.setDataCredenciamento(new Date());
            matriculaDao.cadastrar(credenciamentoAluno);
        }
        JOptionPane.showMessageDialog(null, "CADASTRO FEITO COM SUCESSO!");
    }

    private Email fazerEmailBoasVindas(Aluno novoAluno) {
        Email email = new Email();
        email.setAssunto("ACESSO LIBERADO A FATEC ZL");
        email.setDestinatario(novoAluno.getUsuario().getEmail());
        File file = FileUtil.getFileFromResource("novo-login.html");
        String htmlEmTexto = FileUtil.fileToText(file.getAbsolutePath());
        htmlEmTexto = String.format(htmlEmTexto, novoAluno.getNome(), novoAluno.getUsuario().getCodigoEmail());
        email.setHmtl(htmlEmTexto);
        return email;
    }

    private Email fazerEmailQrCode(Aluno novoAluno) {
        Email email = new Email();
        email.setAssunto("Seu QRCode de acesso!");
        email.setDestinatario(novoAluno.getUsuario().getEmail());
        File file = FileUtil.getFileFromResource("html/recebimento-qrcode.html");
        String htmlEmTexto = FileUtil.fileToText(file.getAbsolutePath());
        String qrCodePath = "/tmp/opengates/" + novoAluno.getRa() + ".jpg";
        QRCodeUtil.createQRCode(novoAluno.getUsuario().getEmail(), qrCodePath, 200, 200);
        email.getAnexos().add(qrCodePath);
        email.setHmtl(htmlEmTexto);
        return email;
    }

    public void enviaEmailsMatricula(List<String> emails) {

        EmailController emailController = new EmailController();

    }

}
