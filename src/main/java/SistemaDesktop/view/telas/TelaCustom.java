package SistemaDesktop.view.telas;

import javax.swing.*;

import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_HEIGHT;
import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_WIDTH;

//TESTE GIT

public abstract class TelaCustom extends JFrame {

    public TelaCustom(String title) {
        setTitle(title);
        setLocationRelativeTo(null);
        setSize(TELA_DEFAULT_WIDTH, TELA_DEFAULT_HEIGHT);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public TelaCustom() {
        setTitle("");
        setLocationRelativeTo(null);
        setSize(TELA_DEFAULT_WIDTH, TELA_DEFAULT_HEIGHT);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
