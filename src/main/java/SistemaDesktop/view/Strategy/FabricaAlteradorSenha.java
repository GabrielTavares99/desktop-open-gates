package SistemaDesktop.view.Strategy;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoRedefinicaoSenha;

import javax.swing.*;

public class FabricaAlteradorSenha {
    TipoRedefinicaoSenha tipoRedefinicaoSenha;

    public FabricaAlteradorSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha){
        this.tipoRedefinicaoSenha = tipoRedefinicaoSenha;
    }

    public AlteracaoSenha fabricarAlteracaoSenha(Usuario usuario, JPanel painel){
        if(tipoRedefinicaoSenha.equals(tipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL))
            return new AlterarPorEmail(usuario, painel);
        else
            return new AlterarPorSenha(usuario, painel);
    }
}
