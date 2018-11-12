package SistemaTerminal.model;

import SistemaDesktop.model.Pessoa;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.AcaoPortaria;
import SistemaDesktop.util.CriptografiaUtil;

import java.util.Date;

public class Validacao {

    private boolean permitida;
    private Pessoa pessoa;
    private String mensagem;
    private String uuidImagem;
    private String imagemBase64;
    private AcaoPortaria acaoPortaria;
    private Date data;

    public Validacao() {
        uuidImagem = String.valueOf(CriptografiaUtil.generateUUID());
        pessoa = new Pessoa();
        Usuario usuario = new Usuario();
        pessoa.setUsuario(usuario);
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public boolean isPermitida() {
        return permitida;
    }

    public void setPermitida(boolean permitida) {
        this.permitida = permitida;
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


    public String getUuidImagem() {
        return uuidImagem;
    }

    public void setUuidImagem(String uuidImagem) {
        this.uuidImagem = uuidImagem;
    }

    public AcaoPortaria getAcaoPortaria() {
        return acaoPortaria;
    }

    public void setAcaoPortaria(AcaoPortaria acaoPortaria) {
        this.acaoPortaria = acaoPortaria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
