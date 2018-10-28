package SistemaDesktop.view.telas;
//TESTE GIT

import SistemaDesktop.view.labels.LabelTitulo;

import javax.swing.*;

public class TelaMatricula extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo("MATRICULA");

    public TelaMatricula(String title) {
        super(title);
        add(lblTitulo);
        setVisible(true);
    }
}
