package SistemaTerminal;

import SistemaDesktop.controller.EmailController;
import SistemaDesktop.model.Email;
import org.apache.commons.mail.EmailException;

import java.util.ArrayList;
import java.util.List;

public class SistemaTerminal {
    public static void main(String[] args) {

//        new TelaLeituraCarteirinha();
        try {
            List<String> emails = new ArrayList<>();
            Email email = new Email();
            email.setAssunto("BOA TARDE - OPEN GATES & VC");
            email.setHmtl("<h1>TENHA UM ÓTIMO ALMOCO DE PORTÕES ABERTOS</h1>");
            email.setDestinatarios(emails);
            new EmailController().sendEmail(email);
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
