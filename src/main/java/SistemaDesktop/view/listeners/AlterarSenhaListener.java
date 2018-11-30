package SistemaDesktop.view.listeners;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.strategy.AlteradorSenha;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarSenhaListener implements ActionListener {

    TipoRedefinicaoSenha tipoRedefinicaoSenha;
    JPanel painel;
    private Usuario usuario;

    public AlterarSenhaListener(Usuario usuario, TipoRedefinicaoSenha tipoRedefinicaoSenha, JPanel painel) {
        this.usuario = usuario;
        this.tipoRedefinicaoSenha = tipoRedefinicaoSenha;
        this.painel = painel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        AlteradorSenha alteradorSenha = new AlteradorSenha(tipoRedefinicaoSenha);
        alteradorSenha.alteracaoDeSenha(usuario, painel);
        TelasUtil.limpaCampos(painel);
    }
}
