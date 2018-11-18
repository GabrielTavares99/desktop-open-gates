package SistemaDesktop.view.paineis;

import javax.swing.*;
import java.awt.*;

import static SistemaDesktop.config.ViewSettings.DEFAULT_COLOR_BOTAO;

public class PainelFuncaoDashboard extends PainelCustom {

    public PainelFuncaoDashboard() {
        setOpaque(true);
        setLayout(null);
        setBackground(DEFAULT_COLOR_BOTAO);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    }

}
