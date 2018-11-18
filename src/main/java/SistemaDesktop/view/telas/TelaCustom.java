package SistemaDesktop.view.telas;

import SistemaDesktop.util.ImageUtil;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.OPEN_GATES;
import static SistemaDesktop.config.ViewSettings.*;

public abstract class TelaCustom extends JFrame {
    JFrame tela;

    public TelaCustom() {
        tela = this;
        setTitle(OPEN_GATES);
        setSize(TELA_DEFAULT_WIDTH, TELA_DEFAULT_HEIGHT);
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(true);
        jPanel.setBackground(DEFAULT_COLOR_TELA);
        setContentPane(jPanel);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(ImageUtil.getImagemProporcional("image/open-gates-sem-texto.png",100,100));
    }

}
