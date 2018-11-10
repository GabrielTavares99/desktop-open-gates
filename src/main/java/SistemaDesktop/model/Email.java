package SistemaDesktop.model;

import java.util.Date;

public class Email {

    private int id;
    private String hmtl;
    private String destinatario;
    private String assunto;
    private boolean enviado = false;
    private Date dataEnvio;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getHmtl() {
        return hmtl;
    }

    public void setHmtl(String hmtl) {
        this.hmtl = hmtl;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
