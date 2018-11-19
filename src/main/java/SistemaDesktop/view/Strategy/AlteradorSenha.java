package SistemaDesktop.view.Strategy;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoRedefinicaoSenha;

import javax.swing.*;

public class AlteradorSenha {
    private TipoRedefinicaoSenha tipoRedefinicaoSenha;
    private FabricaAlteradorSenha fabricaAlteradorSenha;

    public AlteradorSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha){
        this.tipoRedefinicaoSenha = tipoRedefinicaoSenha;
        fabricaAlteradorSenha = new FabricaAlteradorSenha(tipoRedefinicaoSenha);
    }

    public void alteracaoDeSenha(Usuario usuario, JPanel panel){
        AlteracaoSenha alterador = fabricaAlteradorSenha.fabricarAlteracaoSenha(usuario, panel);
        alterador.alterarSenha();
    }
}
