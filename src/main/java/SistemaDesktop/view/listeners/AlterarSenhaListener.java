package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;
import SistemaDesktop.view.telas.TelaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarSenhaListener implements ActionListener {

    private Usuario usuario;

    public AlterarSenhaListener(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String confirmacaoSenha = PainelFormularioRedefinicaoSenha.txtConfirmacaoSenhaNova.getText();
        String novaSenha = PainelFormularioRedefinicaoSenha.txtSenhaNova.getText();
        String codigoEmail = PainelFormularioRedefinicaoSenha.txtCodigoEmail.getText();
        String senhaAtualText = PainelFormularioRedefinicaoSenha.txtSenhaAtual.getText();

        if ((novaSenha.equals(confirmacaoSenha) && codigoEmail.equals(usuario.getCodigoEmail())) ||
                (novaSenha.equals(confirmacaoSenha) && CriptografiaUtil.gerarMD5(senhaAtualText).equals(usuario.getSenha()))) {
            UsuarioController usuarioController = new UsuarioController();
            usuarioController.alterarSenha(usuario, novaSenha);
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
        }

    }
}
