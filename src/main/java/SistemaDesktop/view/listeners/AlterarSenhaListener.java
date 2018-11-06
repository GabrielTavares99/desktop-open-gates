package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

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

        if (novaSenha.equals(confirmacaoSenha) && codigoEmail.equals(usuario.getCodigoEmail())) {
            UsuarioController usuarioController = new UsuarioController();
            usuarioController.alterarSenha(usuario, novaSenha);
        }

    }
}
