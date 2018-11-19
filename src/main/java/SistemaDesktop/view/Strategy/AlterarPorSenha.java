package SistemaDesktop.view.Strategy;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.paineis.PainelFormularioRedefinicaoSenha;

import javax.swing.*;

public class AlterarPorSenha extends AlteracaoSenha {
    private Usuario usuario;
    private UsuarioController usuarioController = new UsuarioController();
    private JPanel painel;

    private String confirmacaoSenha = String.valueOf(PainelFormularioRedefinicaoSenha.txtConfirmacaoSenhaNova.getPassword());
    private String novaSenha = String.valueOf(PainelFormularioRedefinicaoSenha.txtSenhaNova.getPassword());
    private String codigoEmail = PainelFormularioRedefinicaoSenha.txtCodigoEmail.getText();
    String senhaAtualText = String.valueOf(PainelFormularioRedefinicaoSenha.txtSenhaAtual.getPassword());

    public AlterarPorSenha(Usuario usuario, JPanel painel){
        this.usuario = usuario;
        this.painel = painel;
    }

    public  void alterarSenha(){
        if (podeAlterarPorRedefinicaoComSenha()) {
            usuario = usuarioController.alterarSenha(usuario, novaSenha);
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
            TelasUtil.limpaCampos(painel);
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha!");
        }
    }

    private boolean podeAlterarPorRedefinicaoComSenha(){
        String senhaMD5 = CriptografiaUtil.gerarMD5(senhaAtualText);
        String senhaUsuario = usuario.getSenha();

        boolean senhasIguais = novaSenha.equals(confirmacaoSenha);
        boolean redefinirSenhaPorDashBoard = (senhasIguais && senhaMD5.equals(senhaUsuario));

        return redefinirSenhaPorDashBoard;
    }
}
