package SistemaDesktop.controller.modelosTabela;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModeloTabelaMatricula extends AbstractTableModel {

    //	Variaveis da classe
    private String colunas[];
    private List<Object> listaMoradores;

    //	Método contrutor
    public ModeloTabelaMatricula(String[] cabecalho, List<Object> listaMoradores) {
        this.listaMoradores = listaMoradores;
        this.colunas = cabecalho;
    }

    public ModeloTabelaMatricula(List<Object> listaMoradores) {
        this.listaMoradores = listaMoradores;
    }

    //	Método para atualzar a tabelaCredenciamentoAluno
    public static void atualizar(AbstractTableModel modelo, JTable tabela, List<Object> lista, String[] cabecalhos) {
        modelo = new ModeloTabelaMatricula(cabecalhos, lista);
        tabela.setModel(modelo);
    }

    //	Dando nome as colunas
    @Override
    public String getColumnName(int column) {
        if (column > colunas.length || column < 0) {
            return null;
        }
        return colunas[column];

    }

    //	Pega a quatidade de colunas da tabelaCredenciamentoAluno
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //	Pegar indice do item
    public Object getMorador(int indice) {
        return listaMoradores.get(indice);
    }

    //	Pega a quantidade de linhas da tabelaCredenciamentoAluno
    @Override
    public int getRowCount() {
        return listaMoradores.size();
    }

    //	Nega edição da célula
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    //	Pega um valor de um campo unico
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        Morador morador = listaMoradores.get(rowIndex);
//        switch (columnIndex) {
//            case 0:
//                return morador.getNome();
//            case 1:
//                return morador.getBloco();
//            case 2:
//                return morador.getNumeroApartamento();
//            case 3:
//                return morador.getRg();
//
//            default:
//                break;
//        }
//
        return null;
    }

}