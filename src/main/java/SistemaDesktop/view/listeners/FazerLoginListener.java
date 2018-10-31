package SistemaDesktop.view.listeners;

import SistemaDesktop.view.telas.TelaDashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FazerLoginListener implements ActionListener {

    private JFrame telaLogin;

    public FazerLoginListener(JFrame telaLogin) {
        this.telaLogin = telaLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaDashboard();
        telaLogin.hide();
    }
}
