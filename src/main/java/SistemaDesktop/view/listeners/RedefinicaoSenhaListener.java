package SistemaDesktop.view.listeners;

import SistemaDesktop.view.telas.TelaRedefinicaoSenha;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RedefinicaoSenhaListener implements MouseListener {

    private JFrame frame;

    public RedefinicaoSenhaListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        new TelaRedefinicaoSenha();

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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
