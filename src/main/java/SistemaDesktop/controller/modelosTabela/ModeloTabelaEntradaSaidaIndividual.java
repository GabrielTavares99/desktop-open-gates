package SistemaDesktop.controller.modelosTabela;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTabelaEntradaSaidaIndividual implements TableModel {
    private List<String> cabecalho = new ArrayList<>();
    private List<Object> objects = new ArrayList<>();

    public ModeloTabelaEntradaSaidaIndividual() {
        cabecalho.add("campo1");
        cabecalho.add("campo2");
        cabecalho.add("campo3");
        cabecalho.add("campo4");
    }

    @Override
    public int getRowCount() {
        return objects.size();
    }

    @Override
    public int getColumnCount() {
        return 0;
    }


    @Override
    public String getColumnName(int columnIndex) {
        return cabecalho.get(columnIndex - 1);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
//        FALAR O TIPO DE CADA CAMPO
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = objects.get(rowIndex);
//        pega o campo do cabecalho no columnIndex
        return o.getClass();
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
