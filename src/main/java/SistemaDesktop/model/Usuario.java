package SistemaDesktop.model;

import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.CriptografiaUtil;

public class Usuario {

    private String email;
    private String senha;
    private boolean acessaSistema;
    private TipoUsuario tipoUsuario;

    public String getCodigoEmail() {
        return codigoEmail;
    }

    public void setCodigoEmail(String codigoEmail) {
        this.codigoEmail = codigoEmail;
    }

    private String codigoEmail;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAcessaSistema() {
        return acessaSistema;
    }

    public void setAcessaSistema(boolean acessaSistema) {
        this.acessaSistema = acessaSistema;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isSenhasIguais(String senhaPura) {
        String senhaMd5 = CriptografiaUtil.gerarMD5(senhaPura);
        return senhaMd5.equals(this.getSenha());
    }
}
