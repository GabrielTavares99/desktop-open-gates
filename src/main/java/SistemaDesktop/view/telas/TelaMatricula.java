package SistemaDesktop.view.telas;
//TESTE GIT

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.paineis.PainelMenu;


import javax.swing.*;

import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class TelaMatricula extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo("MATRICULA");
    JPanel pnMenu = new PainelMenu();


    public TelaMatricula(String title) {
        super(title);
        add(lblTitulo);
        TELA_ANTERIOR = this;


        add(pnMenu);
        setVisible(true);
    }
}
