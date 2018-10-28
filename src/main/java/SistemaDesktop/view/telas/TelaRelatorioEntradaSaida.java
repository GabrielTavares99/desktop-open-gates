package SistemaDesktop.view.telas;
//TESTE GIT

import SistemaDesktop.view.labels.LabelTitulo;

import javax.swing.*;

public class TelaRelatorioEntradaSaida extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo("RELATORIO ENTRADA E SAIDA");

    public TelaRelatorioEntradaSaida(String title) {
        super(title);
        add(lblTitulo);
        setVisible(true);
    }
}
