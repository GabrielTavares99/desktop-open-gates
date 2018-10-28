package SistemaDesktop.view.paineis;

import javax.swing.*;

import static SistemaDesktop.config.ViewSettings.PAINEL_DEFAULT_COLOR;

public abstract class PainelCustom extends JPanel {

    public PainelCustom() {
        setOpaque(true);
        setBackground(PAINEL_DEFAULT_COLOR);
    }

}
