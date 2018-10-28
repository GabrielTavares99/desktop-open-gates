package SistemaDesktop.view.listeners;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class PainelFeatureListener implements MouseListener {

    private JFrame telaAnterior;
    private Class novaTela;

    public PainelFeatureListener(Class novaTela) {
        this.telaAnterior = telaAnterior;
        this.novaTela = novaTela;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Constructor<?> constructor = novaTela.getConstructor(String.class);
            Object instance = constructor.newInstance("open gates");
            TELA_ANTERIOR.hide();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e1) {
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