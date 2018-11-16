package SistemaBatch.controller;

import SistemaDesktop.config.Constantes;
import SistemaDesktop.controller.dao.EmailDAO;
import SistemaDesktop.model.Email;
import SistemaDesktop.model.Pessoa;
import SistemaDesktop.util.FileUtil;
import SistemaDesktop.util.QRCodeUtil;
import org.apache.commons.mail.MultiPartEmail;

import java.io.File;

public class EmailController {

    private final String emailSistema = "sistema.open.gates@gmail.com";
    private final String senhaSistema = "opengates2018";
    private EmailDAO emailDAO = new EmailDAO();

    public static Email fazerEmailBoasVindas(Pessoa novoAluno) {
        Email email = new Email();
        email.setAssunto("ACESSO LIBERADO A FATEC ZL");
        email.setDestinatario(novoAluno.getUsuario().getEmail());
        File file = FileUtil.getFileFromResource("novo-login.html");
        String htmlEmTexto = FileUtil.fileToText(file.getAbsolutePath());
        htmlEmTexto = String.format(htmlEmTexto, novoAluno.getNome(), novoAluno.getUsuario().getCodigoEmail());
        email.setHmtl(htmlEmTexto);
        return email;
    }

    public static Email fazerEmailQrCode(Pessoa pessoa, String destino) {
        Email email = new Email();
        email.setAssunto("Seu QRCode de acesso!");
        email.setDestinatario(pessoa.getUsuario().getEmail());
        File file = FileUtil.getFileFromResource("html/recebimento-qrcode.html");
        String htmlEmTexto = FileUtil.fileToText(file.getAbsolutePath());
        String qrCodePath = destino;
        QRCodeUtil.createQRCode(pessoa.getUsuario().getEmail(), qrCodePath, 200, 200);
        email.getAnexos().add(qrCodePath);
        email.setHmtl(htmlEmTexto);
        return email;
    }

    public void sendEmail(Email emailTo) {
        System.out.println(emailTo.getDestinatario());
        System.out.println(emailTo.getAssunto());
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setDebug(false);
            if (emailTo.getAnexos().size() > 0) {
                for (String anexoPath : emailTo.getAnexos()) {
                    email.attach(new File(anexoPath));
                }
                email.addPart(emailTo.getHmtl(), "text/html; charset=utf-8");
            } else
                email.setContent(emailTo.getHmtl(), "text/html; charset=utf-8");

            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);

            // Adicione os destinatários
            email.addTo(emailTo.getDestinatario());
            email.addTo(emailSistema);

            email.setFrom(emailSistema, Constantes.OPEN_GATES);

            email.setSubject(emailTo.getAssunto());


            // Para autenticar no servidor é necessário chamar os dois métodos abaixo
            System.out.println("autenticando...");
            email.setSSLOnConnect(true);
            email.setAuthentication(emailSistema, senhaSistema);
            System.out.println("enviando...");
            email.send();
            System.out.println("Email enviado!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Email getEmailNaoEnviado() {
        return emailDAO.getEmailNaoEnviado();
    }

    public void update(Email email) {
        emailDAO.atualizar(email);
    }
}
