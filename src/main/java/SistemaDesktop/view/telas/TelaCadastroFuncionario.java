package SistemaDesktop.view.telas;

import SistemaDesktop.view.labels.LabelTitulo;

import javax.swing.*;

public class TelaCadastroFuncionario extends TelaCustom {

    JLabel lblTitulo = new LabelTitulo("CADASTRO FUNCIONARIO");

    public TelaCadastroFuncionario(String title) {
        super(title);

        add(lblTitulo);

        setVisible(true);
    }
}
