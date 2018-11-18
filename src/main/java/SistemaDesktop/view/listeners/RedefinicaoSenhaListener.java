package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.telas.TelaRedefinicaoSenha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RedefinicaoSenhaListener implements MouseListener, ActionListener {

    private JFrame tela;
    private Cursor cursor;
    private TipoRedefinicaoSenha tipoRedefinicaoSenha;

    private UsuarioController usuarioController = new UsuarioController();

    public RedefinicaoSenhaListener(JFrame frame, TipoRedefinicaoSenha tipoRedefinicaoSenha) {
        this.tela = frame;
        this.tipoRedefinicaoSenha = tipoRedefinicaoSenha;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        redefinirSenha();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        cursor = tela.getCursor();
        tela.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tela.setCursor(cursor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        redefinirSenha();
    }


    private void redefinirSenha() {
        Usuario usuario;
        if (tipoRedefinicaoSenha.equals(TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL)) {
            String emailRecuperacao = JOptionPane.showInputDialog(null, "Para recuperar sua senha, informe seu endereço de e-mail cadastrado no sistema.", "Recuperar Senha", JOptionPane.INFORMATION_MESSAGE);
            TelasUtil.EMAIL_RECUPERACAO = emailRecuperacao;
            if (emailRecuperacao.isEmpty())
                return;
            usuario = usuarioController.findByEmail(emailRecuperacao);
            if (usuario == null) {
                JOptionPane.showMessageDialog(tela, "Email não encontrado!");
            } else {
                if (usuario.getCodigoEmail() == null) {
                    JOptionPane.showMessageDialog(tela, "Você receberá um email em breve com o seu código para redefinição de senha!");
                    usuarioController.enviarCodigoEsqueciSenha(usuario);
                }
                new TelaRedefinicaoSenha(tipoRedefinicaoSenha, usuario);
                tela.dispose();
            }
        } else {
            new TelaRedefinicaoSenha(tipoRedefinicaoSenha, TelasUtil.USUARIO_LOGADO);
            tela.dispose();
        }

    }
}
