package SistemaBatch.controller;

import SistemaDesktop.controller.dao.EmailDAO;
import SistemaDesktop.model.Email;
import org.apache.commons.mail.MultiPartEmail;

import java.io.File;

import static SistemaDesktop.config.Constantes.OPEN_GATES;

public class EmailController {

    private final String emailSistema = "sistema.open.gates@gmail.com";
    private final String senhaSistema = "opengates2018";
    private EmailDAO emailDAO = new EmailDAO();

    public void sendEmailComAnexo(Email emailTo) {
        try {
            MultiPartEmail email = new MultiPartEmail();
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

            email.setFrom(emailSistema, OPEN_GATES);

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
