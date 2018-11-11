package SistemaBatch;

import SistemaBatch.controller.jobs.JobEnviarEmail;

public class SistemaBatch {
    public static void main(String[] args) {
        new JobEnviarEmail().start();
//        Email email = new Email();
//        email.setDestinatario("gabriel.tavares99@hotmail.com");
//        email.setAssunto("Seu QRCode de acesso a Fatec Zona Leste");
//        List<String> objects = new ArrayList<>();
//        objects.add("/tmp/ola.jpg");
//        objects.add("/tmp/oi.jpg");
//        email.setAnexos(objects);
//        email.setHmtl("<h1>ANEXO MAIS TEXTO</h1>");
//        new EmailController().sendEmail(email);
    }
}
