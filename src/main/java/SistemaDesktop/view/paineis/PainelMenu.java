package SistemaDesktop.view.paineis;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelMenu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PainelMenu extends PainelCustom {
    List<JComponent> lista_menu = new ArrayList<>();
    JLabel lblSair = new LabelMenu("LOG OUT");
    JLabel lblTrocarSenha = new LabelMenu("PASSWORD");

    public PainelMenu() {
        setBackground(Color.red);

        setBounds(0, 0, 100, 200);

        lista_menu.add(lblSair);
        lista_menu.add(lblTrocarSenha);
        TelasUtil.addItensToTela(this, lista_menu);
        setLayout(new GridLayout(2, 1));

    }

}
