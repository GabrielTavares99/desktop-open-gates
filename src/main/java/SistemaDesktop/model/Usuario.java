package SistemaDesktop.model;

import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.CriptografiaUtil;

public class Usuario {

    private Integer id;
    private String email;
    private String senha;
    private boolean acessaSistema = true;
    private TipoUsuario tipoUsuario;
    private String codigoEmail;
    private String cpf;
    private Pessoa pessoa;

    public String getCodigoEmail() {
        return codigoEmail;
    }

    public void setCodigoEmail(String codigoEmail) {
        this.codigoEmail = codigoEmail;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
