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

    public TelaRedefinicaoSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha, Usuario usuario) {
        super();
        Usuario byEmail = usuario;

        JLabel lblTitulo = new LabelTitulo("TELA REDEFINIÇÃO SENHA");
        add(lblTitulo);
        add(new PainelFormularioRedefinicaoSenha(tipoRedefinicaoSenha, byEmail));

        JMenu menuSair = new JMenu("VOLTAR");
        menuSuperior.add(menuSair);
        JMenuItem sair = new JMenuItem("SAIR");
        menuSair.add(sair);
        sair.addActionListener(new VoltarRedefinicaoSenhaListener(this, tipoRedefinicaoSenha));
        setJMenuBar(menuSuperior);
        setVisible(true);
    }


}
