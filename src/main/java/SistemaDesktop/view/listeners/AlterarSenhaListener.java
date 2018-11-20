package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.Strategy.AlteradorSenha;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarSenhaListener implements ActionListener {

    private Usuario usuario;
    TipoRedefinicaoSenha tipoRedefinicaoSenha;
    JPanel painel;

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
