package SistemaDesktop.view.telas;

import SistemaDesktop.controller.modelosTabela.ModeloTabelaEntradaSaidaIndividual;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.menu.MenuSuperior;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.TITULO_TELA_RELATORIO_ENTRADA_SAIDA;

public class TelaRelatorioEntradaSaida extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_RELATORIO_ENTRADA_SAIDA);

    public TelaRelatorioEntradaSaida() {
        super();
        add(lblTitulo);

        ModeloTabelaEntradaSaidaIndividual modeloTabelaEntradaSaidaIndividual = new ModeloTabelaEntradaSaidaIndividual();
        JTable table = new JTable(modeloTabelaEntradaSaidaIndividual);
//        add(table);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setBounds(10, 80, 400, 500);
        add(scrollPane);

        setJMenuBar(new MenuSuperior(tela));
        setVisible(true);
    }

    public void refreshJTable(JTable table){

        table.invalidate(); // LIMPA A MEMÓRIA DA TABELA
        table.revalidate(); // BUSCA INFORMAÇÕES NOVAMENTE
        table.repaint();
    }
}
