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

    private JFrame frame;
    private Cursor cursor;
    private TipoRedefinicaoSenha tipoRedefinicaoSenha;


    public RedefinicaoSenhaListener(JFrame frame, TipoRedefinicaoSenha tipoRedefinicaoSenha) {
        this.frame = frame;
        this.tipoRedefinicaoSenha = tipoRedefinicaoSenha;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        func();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        cursor = frame.getCursor();
        frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        frame.setCursor(cursor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        func();
    }


    private void func() {
        Usuario byEmail;
        if (tipoRedefinicaoSenha.equals(TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL)) {
            String emailRecuperacao = JOptionPane.showInputDialog(null, "Para recuperar sua senha, informe seu endereço de e-mail cadastrado no sistema.", "Recuperar Senha", JOptionPane.INFORMATION_MESSAGE);
            TelasUtil.EMAIL_RECUPERACAO = emailRecuperacao;
            UsuarioController usuarioController = new UsuarioController();
            byEmail = usuarioController.findByEmail(emailRecuperacao);
            if (byEmail == null) {
                JOptionPane.showConfirmDialog(frame, "Email não encontrado!");
            } else {
                new TelaRedefinicaoSenha(tipoRedefinicaoSenha);
                frame.dispose();
            }
        }

    }
}
