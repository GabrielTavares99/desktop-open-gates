package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.controller.dao.UsuarioDAO;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarSenhaListener implements ActionListener {

    private Usuario usuario;
    private UsuarioController usuarioController = new UsuarioController();

    public AlterarSenhaListener(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String confirmacaoSenha = String.valueOf(PainelFormularioRedefinicaoSenha.txtConfirmacaoSenhaNova.getPassword());
        String novaSenha = String.valueOf(PainelFormularioRedefinicaoSenha.txtSenhaNova.getPassword());
        String codigoEmail = PainelFormularioRedefinicaoSenha.txtCodigoEmail.getText();
        String senhaAtualText = String.valueOf(PainelFormularioRedefinicaoSenha.txtSenhaAtual.getPassword());

        if ((novaSenha.equals(confirmacaoSenha) && codigoEmail.equals(usuario.getCodigoEmail())) ||
                (novaSenha.equals(confirmacaoSenha) && CriptografiaUtil.gerarMD5(senhaAtualText).equals(usuario.getSenha()))) {
            usuario = usuarioController.alterarSenha(usuario, novaSenha);
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha!");
        }

    }
}
