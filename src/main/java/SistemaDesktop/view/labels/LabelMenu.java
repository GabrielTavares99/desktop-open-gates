package SistemaDesktop.view.labels;

import SistemaDesktop.view.listeners.LogoutListener;

import javax.swing.*;

public class LabelMenu extends LabelCustom {
    public LabelMenu(String descricao) {
        super(descricao);
    }

    public LabelMenu(JFrame tela) {
        super();
        setBounds(0, 0, 100, 200);
    }
}
