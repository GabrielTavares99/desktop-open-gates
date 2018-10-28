package SistemaDesktop.view.listeners;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PainelFeatureListener implements MouseListener {

    private Class tela;

    public PainelFeatureListener(Class tela) {
        this.tela = tela;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Constructor<?> constructor = tela.getConstructor(String.class);
            Object instance = constructor.newInstance("open gates");
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
