package SistemaDesktop.view.telas;


import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.controller.modelosTabela.ModeloTabelaMatricula;
import SistemaDesktop.view.paineis.PainelMatricula;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.Constantes.TITULO_TELA_MATRICULA;
import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class TelaMatricula extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_MATRICULA);
    JTable tabela = new JTable();
    String[] colunasNomes;
    ModeloTabelaMatricula modeloTabela;
    JPanel pnMatricula;

    public TelaMatricula() {
        super();
        add(lblTitulo);

        colunasNomes = new String[]{"Arquivo", "Data e Hora", "Nº Matriculados", "ERROS"};
        List<Object> objects = new ArrayList<>();
        modeloTabela = new ModeloTabelaMatricula(colunasNomes, objects);
        tabela.setModel(modeloTabela);
        JScrollPane scroolPane = new JScrollPane(tabela);
        scroolPane.setBounds(50, 85, 700, 200);
        add(scroolPane);

        pnMatricula = new PainelMatricula(tela);
        add(pnMatricula);

        TELA_ANTERIOR = this;
        setJMenuBar(new MenuSuperior(tela));

        setVisible(true);
    }
}
