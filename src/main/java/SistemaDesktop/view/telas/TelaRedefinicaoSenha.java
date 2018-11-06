package SistemaDesktop.view.telas;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.listeners.VoltarRedefinicaoSenhaListener;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

import javax.swing.*;

public class TelaRedefinicaoSenha extends TelaCustom {
    JMenuBar menuSuperior = new JMenuBar();

    public TelaRedefinicaoSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha) {
        super();
        if (tipoRedefinicaoSenha.equals(TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL)) {
            String emailRecuperacao = JOptionPane.showInputDialog(null, "Para recuperar sua senha, informe seu endereço de e-mail cadastrado no sistema.", "Recuperar Senha", JOptionPane.INFORMATION_MESSAGE);

            // TODO: 05/11/18 ENVIAR EMAIL
        }
        JLabel lblTitulo = new LabelTitulo("TELA REDEFINIÇÃO SENHA");
        add(lblTitulo);
        add(new PainelFormularioRedefinicaoSenha(tipoRedefinicaoSenha));

        JMenu menuSair = new JMenu("VOLTAR");
        menuSuperior.add(menuSair);
        JMenuItem sair = new JMenuItem("SAIR");
        menuSair.add(sair);
        sair.addActionListener(new VoltarRedefinicaoSenhaListener(this, tipoRedefinicaoSenha));
        setJMenuBar(menuSuperior);


        setVisible(true);
    }


}
