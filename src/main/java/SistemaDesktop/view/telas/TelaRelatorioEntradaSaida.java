package SistemaDesktop.view.telas;

import SistemaDesktop.view.MenuBar;
import SistemaDesktop.view.labels.LabelTitulo;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.TITULO_TELA_RELATORIO_ENTRADA_SAIDA;

public class TelaRelatorioEntradaSaida extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_RELATORIO_ENTRADA_SAIDA);

    public TelaRelatorioEntradaSaida() {
        super();
        add(lblTitulo);
        setJMenuBar(new MenuBar(tela));
        setVisible(true);
    }
}
