package SistemaDesktop.view.listeners;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PainelFeatureListener implements MouseListener {

    private String tela;

    public PainelFeatureListener(String tela) {
        this.tela = tela;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Class.forName(tela);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
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
