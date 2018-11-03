package SistemaDesktop.view.listeners;

import SistemaDesktop.view.telas.TelaLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class LogoutListener implements MouseListener {

    private Cursor cursor;
    private JFrame tela;

    public LogoutListener(JFrame frame){
        this.tela = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        new TelaLogin();
        TELA_ANTERIOR.dispose();
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
        tela.setCursor(Cursor.HAND_CURSOR);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tela.setCursor(cursor);
    }
}
