package SistemaDesktop.view.paineis;

import javax.swing.*;

import static SistemaDesktop.config.ViewSettings.DEFAULT_COLOR_PAINEL;
import static SistemaDesktop.config.ViewSettings.PAINEL_DEFAULT_COLOR;

public abstract class PainelCustom extends JPanel {

    public PainelCustom() {
        setOpaque(true);
        setBackground(DEFAULT_COLOR_PAINEL);
    }

}
