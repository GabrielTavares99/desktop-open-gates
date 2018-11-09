package SistemaTerminal;

import SistemaDesktop.controller.EmailController;
import SistemaDesktop.model.Email;
import SistemaTerminal.view.telas.TelaLeituraCarteirinha;
import org.apache.commons.mail.EmailException;

import java.util.ArrayList;
import java.util.List;

public class SistemaTerminal {
    public static void main(String[] args) {

        new TelaLeituraCarteirinha();
//        try {
//            List<String> emails = new ArrayList<>();
//            Email email = new Email();
//            email.setAssunto("Ummm é tardinha - OPEN GATES & VC");
//            email.setHmtl("<h1>PORTOES ABERTOS PARA VOCÊ TOMAR AQUELE LANCHINHO DA TARDE...</h1>");
//            email.setDestinatarios(emails);
//            new EmailController().sendEmail(email);
//        } catch (EmailException e) {
//            e.printStackTrace();
//        }
    }
}
