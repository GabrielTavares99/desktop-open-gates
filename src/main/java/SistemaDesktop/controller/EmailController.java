package SistemaDesktop.controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;

public class EmailController {


    public void enviarEmail(List<String> emails) {
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("sistema.open.gates@gmail.com", "opengates2018");
                    }
                });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sistema.open.gates@gmail.com")); //Remetente

            StringJoiner joiner = new StringJoiner(",");
            for (String email : emails) {
                joiner.add(email);
            }
            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(joiner.toString());
//                    .parse("seuamigo@gmail.com, seucolega@hotmail.com, seuparente@yahoo.com.br");

            message.setRecipients(Message.RecipientType.TO, toUser);
//            message.setRecipients(Message.RecipientType.BCC, toUser);
            message.setSubject("Enviando email com JavaMail - Tavares Spam");//Assunto
            message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");

            /**Método para enviar a mensagem criada*/
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
