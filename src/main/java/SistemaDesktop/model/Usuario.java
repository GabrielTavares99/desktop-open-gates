package SistemaDesktop.model;

import SistemaDesktop.model.enums.TipoUsuario;

public class Usuario {

    private String email;
    private String senha;
    private boolean acessaSistema;
    private TipoUsuario tipoUsuario;

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
}
