package SistemaDesktop.controller;

import SistemaBatch.controller.EmailController;
import SistemaDesktop.controller.dao.AlunoDAO;
import SistemaDesktop.controller.dao.CredenciamentoAlunoDAO;
import SistemaDesktop.controller.dao.EmailDAO;
import SistemaDesktop.controller.dao.UsuarioDAO;
import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.CredenciamentoAluno;
import SistemaDesktop.model.Email;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.Periodo;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.*;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MatriculaController {

    UsuarioDAO usuarioDao;
    AlunoDAO alunoDao;
    CredenciamentoAlunoDAO credenciamentoAlunoDAO;

    public MatriculaController() {
        usuarioDao = new UsuarioDAO();
        alunoDao = AlunoDAO.getInstance();
        credenciamentoAlunoDAO = new CredenciamentoAlunoDAO();
    }


    public void fazerMatricula() {
        List<CredenciamentoAluno> credenciamentoAlunos = new ArrayList<>();
        List<Map<String, String>> linhasCSV = CsvUtil.lerCSV(TelasUtil.URL_CSV);
        EmailDAO emailDAO = new EmailDAO();

        ZipUtil.unzip(TelasUtil.URL_ARQUIVO_FOTOS, "/tmp/");

        for (Map<String, String> linhaCsv : linhasCSV) {
            System.out.println(linhaCsv);
            CredenciamentoAluno credenciamentoAluno = new CredenciamentoAluno();
            Usuario usuario = usuarioDao.getByCpf(linhaCsv.get("cpf"));
            if (usuario == null) {
                Aluno novoAluno = new Aluno();
                novoAluno.setRa(Integer.parseInt(linhaCsv.get("ra_aluno")));
                novoAluno.setNome(linhaCsv.get("nome_aluno"));
                novoAluno.getUsuario().setTipoUsuario(TipoUsuario.ALUNO);
                novoAluno.getUsuario().setEmail(linhaCsv.get("e-mail"));
                novoAluno.getUsuario().setCpf(linhaCsv.get("cpf"));

                String a = TelasUtil.URL_ARQUIVO_FOTOS.replace(".zip", "");
                File foto = new File(String.format("/tmp/%s/%s.jpg", new File(a).getName(), novoAluno.getRa()));
                novoAluno.setFotoBase64(ImageUtil.fromImageToBase64(foto.getAbsolutePath()));
                alunoDao.salvar(novoAluno);

                Email email = fazerEmailBoasVindas(novoAluno);
                emailDAO.salvar(email);
                email = fazerEmailQrCode(novoAluno, foto.getAbsolutePath());
                emailDAO.salvar(email);
            }

            Aluno aluno = alunoDao.getByEmail(linhaCsv.get("e-mail"));
            credenciamentoAluno.setAluno(aluno);
            credenciamentoAluno.setSemestre(Integer.parseInt(linhaCsv.get("semestre")));
            credenciamentoAluno.setPeriodo(Periodo.valueOf(linhaCsv.get("periodo")));
            credenciamentoAluno.setDataCredenciamento(new Date());
            credenciamentoAlunoDAO.cadastrar(credenciamentoAluno);
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

    private Email fazerEmailQrCode(Aluno novoAluno, String fotoPath) {
        Email email = new Email();
        email.setAssunto("Seu QRCode de acesso!");
        email.setDestinatario(novoAluno.getUsuario().getEmail());
        File file = FileUtil.getFileFromResource("html/recebimento-qrcode.html");
        String htmlEmTexto = FileUtil.fileToText(file.getAbsolutePath());
        String qrCodePath = fotoPath;
        QRCodeUtil.createQRCode(novoAluno.getUsuario().getEmail(), qrCodePath, 200, 200);
        email.getAnexos().add(qrCodePath);
        email.setHmtl(htmlEmTexto);
        return email;
    }

    public void enviaEmailsMatricula(List<String> emails) {

        EmailController emailController = new EmailController();

    }

}
