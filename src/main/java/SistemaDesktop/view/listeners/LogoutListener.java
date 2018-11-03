package SistemaDesktop.view.listeners;

import SistemaDesktop.view.telas.TelaLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutListener implements ActionListener {

    private Cursor cursor;
    private JFrame tela;

    public LogoutListener(JFrame frame) {
        this.tela = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaLogin();
        tela.dispose();
    }
}
