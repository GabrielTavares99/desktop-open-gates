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
            new EmailController().sendEmail(email);
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
