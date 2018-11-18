package SistemaDesktop.view.telas;

import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.view.paineis.PainelRealatorio;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.TITULO_TELA_RELATORIO_ENTRADA_SAIDA;

public class TelaRelatorioEntradaSaida extends TelaCustom {

    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_RELATORIO_ENTRADA_SAIDA);

    public TelaRelatorioEntradaSaida() {
        super();
        add(lblTitulo);
        add(new PainelRealatorio());
        setJMenuBar(new MenuSuperior(tela));
        setVisible(true);
    }

}
