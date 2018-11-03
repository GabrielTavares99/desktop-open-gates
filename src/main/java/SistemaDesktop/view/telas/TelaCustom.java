package SistemaDesktop.view.telas;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.OPEN_GATES;
import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_HEIGHT;
import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_WIDTH;

public abstract class TelaCustom extends JFrame {

    public TelaCustom() {
        JPanel fundo = new JPanel();
        fundo.add(new JLabel(new ImageIcon(getClass().getResource("../").getPath() + "images/fundo-natureza.jpeg")));
        setTitle(OPEN_GATES);
        fundo.setOpaque(true);
        setLocationRelativeTo(null);
        setSize(TELA_DEFAULT_WIDTH, TELA_DEFAULT_HEIGHT);
        setContentPane(fundo);
        setLayout(null);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
