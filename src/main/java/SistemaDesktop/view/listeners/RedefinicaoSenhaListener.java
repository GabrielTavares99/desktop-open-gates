package SistemaDesktop.view.listeners;

import SistemaDesktop.view.telas.TelaEnvioCodigoRedefinicaoSenha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RedefinicaoSenhaListener implements MouseListener {

    private JFrame frame;

    public RedefinicaoSenhaListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        new TelaEnvioCodigoRedefinicaoSenha();
        frame.dispose();
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

    private Cursor cursor;
}
