package SistemaDesktop.view.listeners;

import SistemaDesktop.view.telas.TelaLogin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class LogOutListener implements MouseListener {
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
