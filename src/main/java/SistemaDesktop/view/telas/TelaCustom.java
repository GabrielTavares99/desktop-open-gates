package SistemaDesktop.view.telas;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.OPEN_GATES;
import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_HEIGHT;
import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_WIDTH;

public abstract class TelaCustom extends JFrame {

    public TelaCustom() {
        setTitle(OPEN_GATES);
        setLocationRelativeTo(null);
        setSize(TELA_DEFAULT_WIDTH, TELA_DEFAULT_HEIGHT);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
