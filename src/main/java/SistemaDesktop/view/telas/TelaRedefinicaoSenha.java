package SistemaDesktop.view.telas;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.controller.dao.AlunoDAO;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.listeners.VoltarRedefinicaoSenhaListener;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

import javax.swing.*;

public class TelaRedefinicaoSenha extends TelaCustom {
    JMenuBar menuSuperior = new JMenuBar();
    PainelFormularioRedefinicaoSenha painel;
    public TelaRedefinicaoSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha, Usuario usuario) {
        super();

        JLabel lblTitulo = new LabelTitulo("TELA REDEFINIÇÃO SENHA");
        add(lblTitulo);

        painel = new PainelFormularioRedefinicaoSenha(tipoRedefinicaoSenha, usuario);
        add(painel);

        JMenu menuSair = new JMenu("VOLTAR");

        menuSuperior.add(menuSair);
        JMenuItem sair = new JMenuItem("SAIR");
        menuSair.add(sair);

        sair.addActionListener(new VoltarRedefinicaoSenhaListener(this, tipoRedefinicaoSenha, painel));
        setJMenuBar(menuSuperior);
        setVisible(true);
    }


}
