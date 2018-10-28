package SistemaDesktop.view.telas;

import javax.swing.*;

import static SistemaDesktop.config.Settings.TELA_HEIGHT;
import static SistemaDesktop.config.Settings.TELA_WIDTH;

public abstract class TelaCustom extends JFrame {

    public TelaCustom(String title) {
        setTitle(title);
        setLocationRelativeTo(null);
        setSize(TELA_WIDTH, TELA_HEIGHT);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
