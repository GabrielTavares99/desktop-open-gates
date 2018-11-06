package SistemaDesktop.view.telas;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.OPEN_GATES;
import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_HEIGHT;
import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_WIDTH;

public abstract class TelaCustom extends JFrame {
    JFrame tela;
    public TelaCustom() {
        tela = this;
        JPanel fundo = new JPanel();
        setTitle(OPEN_GATES);
        setSize(TELA_DEFAULT_WIDTH, TELA_DEFAULT_HEIGHT);
        fundo.setOpaque(true);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
