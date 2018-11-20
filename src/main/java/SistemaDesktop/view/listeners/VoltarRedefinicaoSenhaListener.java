package SistemaDesktop.view.listeners;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;
import SistemaDesktop.view.telas.TelaDashboard;
import SistemaDesktop.view.telas.TelaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoltarRedefinicaoSenhaListener implements ActionListener {
    private JFrame tela;
    private TipoRedefinicaoSenha tipoRedefinicaoSenha;
    JPanel painel;

    public VoltarRedefinicaoSenhaListener(JFrame tela, TipoRedefinicaoSenha tipoRedefinicaoSenha, JPanel painel) {
        this.tela = tela;
        this.tipoRedefinicaoSenha = tipoRedefinicaoSenha;
        this.painel = painel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tipoRedefinicaoSenha.equals(TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL))
            new TelaLogin();
         else
            new TelaDashboard();

        TelasUtil.limpaCampos(painel);
        tela.dispose();
    }

}
