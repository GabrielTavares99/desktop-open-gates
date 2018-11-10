package SistemaBatch.controller;

import SistemaDesktop.controller.dao.EmailDAO;
import SistemaDesktop.model.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import static SistemaDesktop.config.Constantes.OPEN_GATES;

public class EmailController {

    private final String emailSistema = "sistema.open.gates@gmail.com";
    private final String senhaSistema = "opengates2018";
    private EmailDAO emailDAO = new EmailDAO();

    public void sendEmail(Email emailTo) throws EmailException {

        SimpleEmail email = new SimpleEmail();
        email.setDebug(true);

        System.out.println("alterando hostname...");
        email.setHostName("smtp.gmail.com");
        // Quando a porta utilizada não é a padrão (gmail = 465)
        email.setSmtpPort(465);

        // Adicione os destinatários
        email.addTo(emailTo.getDestinatario());

        email.addTo("hidrot@gmail.com");
        // Configure o seu emailSistema do qual enviará
        email.setFrom(emailSistema, OPEN_GATES);

        // Adicione um assunto
        email.setSubject(emailTo.getAssunto());

        email.setContent(emailTo.getHmtl(), "text/html; charset=utf-8");

        // Para autenticar no servidor é necessário chamar os dois métodos abaixo
        System.out.println("autenticando...");
        email.setSSL(true);
        email.setAuthentication(emailSistema, senhaSistema);
        System.out.println("enviando...");
        email.send();
        System.out.println("Email enviado!");
    }

    public Email getEmailNaoEnviado() {
        return emailDAO.getEmailNaoEnviado();
    }

    public void update(Email email) {
        emailDAO.atualizar(email);
    }
}
