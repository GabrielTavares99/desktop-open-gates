package SistemaDesktop.view.telas;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.listeners.VoltarRedefinicaoSenhaListener;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

import javax.swing.*;

public class TelaRedefinicaoSenha extends TelaCustom {
    JMenuBar menuBar = new MenuSuperior();

    public TelaRedefinicaoSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha) {
        super();
        JLabel lblTitulo = new LabelTitulo("TELA REDEFINIÇÃO SENHA");
        add(lblTitulo);
        add(new PainelFormularioRedefinicaoSenha(tipoRedefinicaoSenha));

        JMenuItem sair = new JMenuItem("SAIR");
        sair.addMouseListener(new VoltarRedefinicaoSenhaListener(tipoRedefinicaoSenha));

        setVisible(true);
    }


}
