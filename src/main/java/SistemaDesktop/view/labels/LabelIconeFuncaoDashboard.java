package SistemaDesktop.view.labels;

import javax.swing.*;
import java.awt.*;

import static SistemaDesktop.view.telas.TelaDashboard.PAINEL_FUNCAO_WIDTH;

public class LabelIconeFuncaoDashboard extends JLabel {

    public LabelIconeFuncaoDashboard() {
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 200), 1, true));
        int width = 64;
        int heigth = 64;
        setBounds((PAINEL_FUNCAO_WIDTH / 2) - (width/2), 15, width, heigth);
    }

}
