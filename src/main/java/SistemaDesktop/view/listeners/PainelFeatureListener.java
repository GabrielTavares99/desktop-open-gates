package SistemaDesktop.view.listeners;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class PainelFeatureListener implements MouseListener {

    private Class novaTela;

    public PainelFeatureListener(Class novaTela) {
        this.novaTela = novaTela;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Constructor<?> constructor = novaTela.getConstructor(String.class);
            Object instance = constructor.newInstance("open gates");
            TELA_ANTERIOR.dispose();
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
