package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.UsuarioController;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.telas.TelaDashboard;
import SistemaDesktop.view.telas.TelaLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FazerLoginListener implements ActionListener, MouseListener {

    private JFrame telaLogin;
    private JPanel pnLogin;
    private Cursor cursor;

    public FazerLoginListener(JFrame telaLogin) {
        this.telaLogin = telaLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UsuarioController usuarioController = new UsuarioController();

        String email = TelaLogin.txtUsername.getText();
        String senha = TelaLogin.txtPassword.getText();

        boolean isLogado = usuarioController.podeLogar(email, senha);
        if (isLogado) {
            TelasUtil.USUARIO_LOGADO = usuarioController.findByEmail(email);
            new TelaDashboard();
            telaLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(telaLogin, "Email ou Senha inválidos!!!", "LOGIN", JOptionPane.WARNING_MESSAGE);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        cursor = telaLogin.getCursor();
        telaLogin.setCursor(Cursor.HAND_CURSOR);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        telaLogin.setCursor(cursor);
    }
}
