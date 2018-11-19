package SistemaBatch.controller.jobs;

import SistemaBatch.controller.EmailController;
import SistemaBatch.view.JobEnvioEmail;
import SistemaDesktop.model.Email;

import java.util.Date;

import static commoms.config.Settings.MINUTO;

public class JobEnviarEmail extends Thread {

    private EmailController emailController = new EmailController();

    public JobEnviarEmail() {
    }

    @Override
    public void run() {
        while (JobEnvioEmail.ativo) {
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
                Thread.sleep(MINUTO / 4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
