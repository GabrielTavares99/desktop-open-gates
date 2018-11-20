package SistemaDesktop.view.paineis;

import javax.swing.*;
import java.awt.*;

import static commoms.config.ViewSettings.VERMELHO_PADRAO;

public abstract class PainelCustom extends JPanel {

    public PainelCustom() {
        setOpaque(true);
        setLayout(null);
        setBackground(VERMELHO_PADRAO);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
    }

}
