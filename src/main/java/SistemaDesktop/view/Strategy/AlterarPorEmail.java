package SistemaDesktop.view.Strategy;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

import javax.swing.*;

public class AlterarPorEmail extends AlteracaoSenha {
    private Usuario usuario;
    private UsuarioController usuarioController = new UsuarioController();
    private JPanel painel;

    private String confirmacaoSenha = String.valueOf(PainelFormularioRedefinicaoSenha.txtConfirmacaoSenhaNova.getPassword());
    private String novaSenha = String.valueOf(PainelFormularioRedefinicaoSenha.txtSenhaNova.getPassword());
    private String codigoEmail = PainelFormularioRedefinicaoSenha.txtCodigoEmail.getText();


    public AlterarPorEmail(Usuario usuario, JPanel painel){
        this.usuario = usuario;
        this.painel = painel;
    }

    public void alterarSenha(){
        if (podeAlterarPorEmail()) {
            usuario = usuarioController.alterarSenha(usuario, novaSenha);
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
            TelasUtil.limpaCampos(painel);
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha!");
        }
    }

    private boolean podeAlterarPorEmail(){
        boolean senhasIguais = novaSenha.equals(confirmacaoSenha);
        boolean codigoEmailIguais = codigoEmail.equals(usuario.getCodigoEmail());
        boolean trocarSenhaPorEmail = senhasIguais && codigoEmailIguais;

        return trocarSenhaPorEmail;
    }
}
