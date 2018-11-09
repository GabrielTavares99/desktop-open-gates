package SistemaDesktop.view.paineis;

import javax.swing.*;
import java.awt.*;

import static SistemaDesktop.config.ViewSettings.MEIO_TELA_X;

public class PainelFormularioLogin extends PainelCustom {

    public PainelFormularioLogin() {
        int width = 400;
        setBounds((MEIO_TELA_X) - (width / 2), 180, width, 300);
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 200), 1, true));
    }

}
