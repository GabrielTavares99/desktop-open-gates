package SistemaBatch.controller.jobs;

import SistemaBatch.controller.EmailController;
import SistemaDesktop.model.Email;

import java.util.Date;

import static SistemaBatch.config.Settings.MINUTO;

public class JobEnviarEmail extends Thread {

    @Override
    public void run() {
        EmailController emailController = new EmailController();
        while (true) {
            System.out.println("INICIANDO JOB DE ENVIO DE EMAIL " + new Date().getHours() + ":" + new Date().getMinutes());
            Email emailNaoEnviado = emailController.getEmailNaoEnviado();

            if (emailNaoEnviado != null) {
                emailController.sendEmail(emailNaoEnviado);
                emailNaoEnviado.setEnviado(true);
                emailNaoEnviado.setDataEnvio(new Date());
                emailController.update(emailNaoEnviado);
            }
            System.out.println("FINALIZANDO JOB DE ENVIO DE EMAIL");
            try {
                Thread.sleep(MINUTO / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
