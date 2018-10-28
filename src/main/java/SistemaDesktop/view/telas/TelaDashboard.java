package SistemaDesktop.view.telas;

import SistemaDesktop.view.labels.LabelSaudacao;
import SistemaDesktop.view.labels.LabelTitulo;

import javax.swing.*;

public class TelaDashboard extends TelaCustom {

    JLabel lbl_saudacao = new LabelSaudacao("");
    JLabel lbl_titulo = new LabelTitulo("DASHBOARD");

    public TelaDashboard(String title) {
        super(title);




        setVisible(true);
    }
}
