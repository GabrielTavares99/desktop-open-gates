package SistemaTerminal;

import SistemaDesktop.controller.EmailController;
import SistemaTerminal.view.telas.TelaLeituraCarteirinha;
import org.apache.commons.mail.EmailException;

public class SistemaTerminal {
    public static void main(String[] args) {

//        new TelaLeituraCarteirinha();
        try {
            new EmailController().sendEmail();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
