package SistemaDesktop.model;

import SistemaDesktop.controller.modelosTabela.TabelaValidacoesModelCustom;
import SistemaTerminal.model.Validacao;

import javax.swing.event.TableModelListener;
import java.util.ArrayList;
import java.util.List;

public class RelatorioValidacoesColetivaModel extends TabelaValidacoesModelCustom {

    List<String> cabecalho = new ArrayList<>();

    public RelatorioValidacoesColetivaModel() {
        cabecalho.add("CPF");
        cabecalho.add("Nome");
        cabecalho.add("Ação");
        cabecalho.add("Data");
        cabecalho.add("Valido");
        cabecalho.add("Tipo Usuario");
    }

    @Override
    public int getRowCount() {
        return getValidacaos().size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return cabecalho.get(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Validacao validacao = getValidacaos().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return validacao.getPessoa().getNome();
            case 1:
                return validacao.getPessoa().getUsuario().getCpf();
            case 2:
                return validacao.getAcaoPortaria().toString();
            case 3:
                return validacao.getData().toString();
            case 4:
                return validacao.isPermitida();
            case 5:
                return validacao.getPessoa().getUsuario().getTipoUsuario().toString();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Boolean.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
