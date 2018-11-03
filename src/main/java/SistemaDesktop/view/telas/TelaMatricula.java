package SistemaDesktop.view.telas;


import SistemaDesktop.model.ModeloTabela;
import SistemaDesktop.view.labels.LabelTitulo;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.Constantes.TITULO_TELA_MATRICULA;
import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class TelaMatricula extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_MATRICULA);
    JTable tabela = new JTable();
    String[] colunasNomes;
    ModeloTabela modeloTabela;
    public TelaMatricula() {
        super();
        add(lblTitulo);


        colunasNomes = new String[]{"Arquivo","Data e Hora","Nº Matriculados","ERROS"};
        List<Object> objects = new ArrayList<>();
        modeloTabela = new ModeloTabela(colunasNomes, objects);
        tabela.setModel(modeloTabela);
        JScrollPane scroolPane = new JScrollPane(tabela);
        scroolPane.setBounds(50,100,700,200);
        this.add(scroolPane);



        TELA_ANTERIOR = this;
        setVisible(true);
    }
}
