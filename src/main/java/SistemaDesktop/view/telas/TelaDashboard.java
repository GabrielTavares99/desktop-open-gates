package SistemaDesktop.view.telas;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelMenu;
import SistemaDesktop.view.labels.LabelSaudacao;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.paineis.PainelMenu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaDashboard extends TelaCustom {

    JLabel lbl_saudacao = new LabelSaudacao("BOA ???");
    JLabel lbl_titulo = new LabelTitulo("DASHBOARD");
    JLabel lbl_sair = new LabelMenu("LOG OUT");
    JLabel lbl_trocar_senha = new LabelMenu("PASSWORD");

    JPanel pn_geral = new JPanel();
    JPanel pn_menu = new PainelMenu();


    List<JComponent> lista_menu = new ArrayList<>();
    public TelaDashboard(String title) {
        super(title);
        pn_geral.setLayout(null);
        pn_geral.add(lbl_saudacao);
        pn_geral.add(lbl_titulo);


        pn_menu.setLayout(new GridLayout(2,1));
        lista_menu.add(lbl_sair);
        lista_menu.add(lbl_trocar_senha);
        TelasUtil.addItensToTela(pn_menu, lista_menu);

        pn_geral.add(pn_menu);
        setContentPane(pn_geral);
        setVisible(true);
    }
}
