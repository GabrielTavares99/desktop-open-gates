package SistemaDesktop.view.telas;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.listeners.VoltarRedefinicaoSenhaListener;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

import javax.swing.*;

public class TelaRedefinicaoSenha extends TelaCustom {
    JMenuBar menuSuperior = new JMenuBar();

    public TelaRedefinicaoSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha) {
        super();
        JLabel lblTitulo = new LabelTitulo("TELA REDEFINIÇÃO SENHA");
        add(lblTitulo);
        add(new PainelFormularioRedefinicaoSenha(tipoRedefinicaoSenha));

        JMenu menuSair = new JMenu("VOLTAR");
        menuSuperior.add(menuSair);
//        JMenuItem sair = new JMenuItem("SAIR");
//        menuSair.add(sair);
        setJMenuBar(menuSuperior);
//        menuSuperior.add(menuSair);

        menuSair.addMouseListener(new VoltarRedefinicaoSenhaListener(tipoRedefinicaoSenha));

        add(menuSuperior);

        setVisible(true);
    }


}
