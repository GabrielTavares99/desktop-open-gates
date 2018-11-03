package SistemaDesktop.view.listeners;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.view.telas.TelaRedefinicaoSenha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RedefinicaoSenhaListener implements MouseListener, ActionListener {

    private JFrame frame;
    private TipoRedefinicaoSenha tipoRedefinicaoSenha;

    public RedefinicaoSenhaListener(JFrame frame, TipoRedefinicaoSenha tipoRedefinicaoSenha) {
        this.frame = frame;
        this.tipoRedefinicaoSenha = tipoRedefinicaoSenha;
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
        cursor = frame.getCursor();
        frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        frame.setCursor(cursor);
    }

    private Cursor cursor;

    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaRedefinicaoSenha(tipoRedefinicaoSenha);
        frame.dispose();
    }
}
