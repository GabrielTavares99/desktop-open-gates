package SistemaTerminal.model;

import SistemaDesktop.model.Pessoa;

public class Validacao {

    private boolean isEntradaPermitida;
    private Pessoa pessoa;
    private String mensagem;
    private String imagemBase64;

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public boolean isEntradaPermitida() {
        return isEntradaPermitida;
    }

    public void setEntradaPermitida(boolean entradaPermitida) {
        isEntradaPermitida = entradaPermitida;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


}
