package SistemaDesktop.model;

import java.util.List;

public class Email {

    private String hmtl;
    private List<String> destinatarios;
    private String assunto;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public List<String> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<String> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getHmtl() {
        return hmtl;
    }

    public void setHmtl(String hmtl) {
        this.hmtl = hmtl;
    }
}
