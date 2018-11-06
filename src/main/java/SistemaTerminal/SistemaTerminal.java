package SistemaTerminal;

import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.Pessoa;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.dao.AlunoDao;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.telas.TelaStatusValidacao;

public class SistemaTerminal {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setUsuario(new Usuario());
        aluno.getUsuario().setSenha(("123"));
        aluno.setNome("SUPER ADM");
        aluno.getUsuario().setEmail("adm");
        aluno.getUsuario().setTipoUsuario(TipoUsuario.ALUNO);
        new AlunoDao().cadastrar(aluno);


        Validacao validacao = new Validacao();
        Pessoa adm = new AlunoDao().getByEmail("adm");
        validacao.setPessoa(adm);
        validacao.setEntradaPermitida(true);
        validacao.setMensagem("ENTRADA PERMITIDA");
        new TelaStatusValidacao(validacao);
    }
}
