package SistemaDesktop.view.labels;

import javax.swing.*;
import java.awt.*;

import static SistemaDesktop.config.ViewSettings.MEIO_TELA_X;

public class LabelLogoLogin extends LabelCustom {
    public LabelLogoLogin(String descricao) {
        super(descricao);
        setBounds(MEIO_TELA_X - 100, 15, 200, 30);
        setHorizontalAlignment(SwingConstants.CENTER);
        new Font("Serif", Font.BOLD + Font.ITALIC, 40);
    }
}
