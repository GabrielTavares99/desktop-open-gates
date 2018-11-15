package SistemaDesktop.view.telas;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.view.paineis.PainelRealatorioColetivo;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.TITULO_TELA_RELATORIO_ENTRADA_SAIDA;

public class TelaRelatorioEntradaSaida extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_RELATORIO_ENTRADA_SAIDA);


    public TelaRelatorioEntradaSaida() {
        super();
        add(lblTitulo);

        add(new PainelRealatorioColetivo());

        setJMenuBar(new MenuSuperior(tela));
        setVisible(true);
    }

    public void refreshJTable(JTable table) {

        table.invalidate(); // LIMPA A MEMÓRIA DA TABELA
        table.revalidate(); // BUSCA INFORMAÇÕES NOVAMENTE
        table.repaint();
    }
}
