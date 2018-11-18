package SistemaDesktop.view.labels;

import javax.swing.*;
import java.awt.*;

import static SistemaDesktop.view.telas.TelaDashboard.PAINEL_FUNCAO_WIDTH;

public class LabelIconeFuncaoDashboard extends JLabel {

    public LabelIconeFuncaoDashboard() {
        int width = 95;
        int heigth = 95;
        setBounds((PAINEL_FUNCAO_WIDTH / 2) - (width/2), 15, width, heigth);
    }

}
