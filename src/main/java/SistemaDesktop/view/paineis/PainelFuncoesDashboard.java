package SistemaDesktop.view.paineis;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import static SistemaDesktop.config.ViewSettings.MEIO_TELA_X;
import static SistemaDesktop.config.ViewSettings.MEIO_TELA_Y;

public class PainelFuncoesDashboard extends PainelCustom {

    public PainelFuncoesDashboard() {
        setBounds(MEIO_TELA_X - 100, MEIO_TELA_Y - 125, 600, 250);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}
