package SistemaDesktop.view.telas;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.listeners.VoltarRedefinicaoSenhaListener;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

import javax.swing.*;

public class TelaRedefinicaoSenha extends TelaCustom {
    JMenuBar menuSuperior = new JMenuBar();

    public TelaRedefinicaoSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha) {
        super();
        Usuario byEmail = TelasUtil.USUARIO_LOGADO;
        if (tipoRedefinicaoSenha.equals(TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL)) {
            String emailRecuperacao = JOptionPane.showInputDialog(null, "Para recuperar sua senha, informe seu endereço de e-mail cadastrado no sistema.", "Recuperar Senha", JOptionPane.INFORMATION_MESSAGE);
            TelasUtil.EMAIL_RECUPERACAO = emailRecuperacao;
            UsuarioController usuarioController = new UsuarioController();
            byEmail = usuarioController.findByEmail(emailRecuperacao);
            if (byEmail == null) {
                JOptionPane.showConfirmDialog(this, "Email não enconrado!");
            }
        }
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
