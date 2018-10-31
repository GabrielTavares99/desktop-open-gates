package SistemaDesktop.view.telas;


import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.paineis.PainelMenu;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.TITULO_TELA_MATRICULA;
import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class TelaMatricula extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_MATRICULA);
    JPanel pnMenu = new PainelMenu();

    public TelaMatricula() {
        super();
        add(lblTitulo);
        TELA_ANTERIOR = this;
        add(pnMenu);
        setVisible(true);
    }
}
