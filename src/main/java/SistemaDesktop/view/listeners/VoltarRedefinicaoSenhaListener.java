package SistemaDesktop.view.listeners;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.view.telas.TelaDashboard;
import SistemaDesktop.view.telas.TelaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoltarRedefinicaoSenhaListener implements ActionListener {
    private JFrame tela;
    private TipoRedefinicaoSenha tipoRedefinicaoSenha;

    public VoltarRedefinicaoSenhaListener(JFrame tela, TipoRedefinicaoSenha tipoRedefinicaoSenha) {
        this.tela = tela;
        this.tipoRedefinicaoSenha = tipoRedefinicaoSenha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tipoRedefinicaoSenha.equals(TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL)) {
            new TelaLogin();
        } else {
            new TelaDashboard();
        }
        tela.dispose();
    }
}
