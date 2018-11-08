package SistemaDesktop.controller;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;

public class EmailController {

    private String emailSistema = "sistema.open.gates@gmail.com";
    private String senhaSistema = "opengates2018";

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
                        return new PasswordAuthentication(emailSistema, senhaSistema);
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
            message.setSubject("Enviando emailSistema com JavaMail - Tavares Spam");//Assunto
            message.setText("Enviei este emailSistema utilizando JavaMail com minha conta GMail!");

            /**Método para enviar a mensagem criada*/
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    public void enviaEmail() {
        try {

            //Variaveis
            String d_email = emailSistema,
                    d_password = senhaSistema,
                    d_host = "smtp.gmail.com",
                    d_port = "465",
                    m_to = "gabriel.tavares99@hotmail.com",
                    m_subject = "Titulo",
                    m_text = "This is a test.";
            //Propriedades Necessarias
            Properties props = new Properties();
            //Modo debug para verificar os passos do envio
            props.put("mail.debug", "true");
            //Servidor SMTP
            props.put("mail.host", d_host);
            //Porta
            props.put("mail.smtp.port", d_port);
            //Necessario autenticacao
            props.put("mail.smtp.auth", "true");
            //Liga o SSL
            props.put("mail.smtp.ssl.enable", "true");
            //Cria a sessao
            Session session = Session.getInstance(props, new SMTPAuthenticator(d_email, d_password));
            //Pega a sessao com usuario e senhaSistema
            MimeMessage msg = new MimeMessage(session);
            //Coloca O corpo do titulo
            msg.setText(m_text);
            //Coloca o assunto
            msg.setSubject(m_subject);
            //Coloca quem enviou
            msg.setFrom(new InternetAddress(d_email));
            //Coloca para quem sera enviado
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            //Envia a mensagem
            Transport.send(msg);
            System.out.println("Terminado");
        } catch (MessagingException mex) {
            System.out.println("Falha no envio, exception: " + mex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmail() throws EmailException {

        SimpleEmail email = new SimpleEmail();
        // Utilize o hostname do seu provedor de emailSistema
        System.out.println("alterando hostname...");
        email.setHostName("smtp.gmail.com");

        // Quando a porta utilizada não é a padrão (gmail = 465)
        email.setSmtpPort(465);

        // Adicione os destinatários
        email.addTo("gabriel.tavares99@hotmail.com");

        // Configure o seu emailSistema do qual enviará
        email.setFrom("karanalpe@gmail.com", "Karan User");

        // Adicione um assunto
        email.setSubject("Lembrete de senhaSistema");

        // Adicione a mensagem do emailSistema
        email.setMsg("Lembrete de senhaSistema karanalpe ");

        // Para autenticar no servidor é necessário chamar os dois métodos abaixo
        System.out.println("autenticando...");
        email.setSSL(true);
        email.setAuthentication(emailSistema, senhaSistema);
        System.out.println("enviando...");
        email.send();
        System.out.println("Email enviado!");
    }

    //Classe necessaria para passar usuario e senhaSistema caso precisa de autenticacao
    class SMTPAuthenticator extends Authenticator {
        String login;
        String password;

        //Recebendo usuario e senhaSistema e guardando nas variaveis
        public SMTPAuthenticator(String login, String password) {
            this.login = login;
            this.password = password;
        }

        //Esse é o metodo usado para enviar usuario e senhaSistema
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.login, this.password);
        }
    }
}
