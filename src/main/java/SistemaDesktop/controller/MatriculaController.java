package SistemaDesktop.controller;

import SistemaBatch.controller.EmailController;
import SistemaDesktop.controller.dao.AlunoDAO;
import SistemaDesktop.controller.dao.ArquivoCredenciamentoAlunoDAO;
import SistemaDesktop.controller.dao.EmailDAO;
import SistemaDesktop.controller.dao.UsuarioDAO;
import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.ArquivoCredenciamentoAluno;
import SistemaDesktop.model.Email;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.*;

import javax.swing.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MatriculaController {

    private UsuarioDAO usuarioDao;
    private AlunoDAO alunoDao;
    private ArquivoCredenciamentoAlunoDAO arquivoCredenciamentoAlunoDAO;
    private EmailDAO emailDAO;

    public MatriculaController() {
        usuarioDao = new UsuarioDAO();
        alunoDao = AlunoDAO.getInstance();
        arquivoCredenciamentoAlunoDAO = new ArquivoCredenciamentoAlunoDAO();
        emailDAO = new EmailDAO();
    }


    public boolean fazerMatricula() {
        if (TelasUtil.URL_CSV == null || TelasUtil.URL_ARQUIVO_FOTOS == null)
            return false;

        ArquivoCredenciamentoAluno arquivoCredenciamentoAluno = new ArquivoCredenciamentoAluno();
        // TODO: 15/11/18 FAZER VALIDAÇÃO DOS PATHS
        List<Map<String, String>> linhasCSV = CsvUtil.lerCSV(TelasUtil.URL_CSV);
        ZipUtil.unzip(TelasUtil.URL_ARQUIVO_FOTOS, "/tmp/");

        arquivoCredenciamentoAluno.setNomeArquivoCsv(FileUtil.getNomeArquivoFromPath(TelasUtil.URL_CSV));
        arquivoCredenciamentoAluno.setNomeArquivoFotos(FileUtil.getNomeArquivoFromPath(TelasUtil.URL_ARQUIVO_FOTOS));
        arquivoCredenciamentoAluno.setData(new Date());
        int erro = 0;
        int novos = 0;
        for (Map<String, String> linhaCsv : linhasCSV) {
            try {
                System.out.println(linhaCsv);
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
                    novos++;
                }
            } catch (Exception e) {
                erro++;
            }
        }
        arquivoCredenciamentoAluno.setQtdCredenciamentosFeitos(novos);
        arquivoCredenciamentoAluno.setQtdTotal(linhasCSV.size());
        arquivoCredenciamentoAluno.setQuantidadeErros(erro);
        arquivoCredenciamentoAlunoDAO.salvar(arquivoCredenciamentoAluno);

        JOptionPane.showMessageDialog(null, "CADASTRO FEITO COM SUCESSO!");
        return true;
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
