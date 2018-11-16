package SistemaDesktop.controller.modelosTabela;

import SistemaDesktop.model.ArquivoCredenciamentoAluno;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModeloTabelaArquivoCredenciamentoAluno extends AbstractTableModel {

    private List<String> cabecalho = new ArrayList<>();

    public List<ArquivoCredenciamentoAluno> getArquivosCredenciamento() {
        return arquivosCredenciamento;
    }

    public void setArquivosCredenciamento(List<ArquivoCredenciamentoAluno> arquivosCredenciamento) {
        this.arquivosCredenciamento = arquivosCredenciamento;
    }

    private List<ArquivoCredenciamentoAluno> arquivosCredenciamento = new ArrayList<>();

    public ModeloTabelaArquivoCredenciamentoAluno() {
        cabecalho.add("Arquivo Fotos");
        cabecalho.add("Arquivo CSV");
        cabecalho.add("Qtd Novos");
        cabecalho.add("Qtd Total");
        cabecalho.add("Qtd Erros");
        cabecalho.add("Data");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArquivoCredenciamentoAluno arquivoCredenciamentoAluno = arquivosCredenciamento.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return arquivoCredenciamentoAluno.getNomeArquivoFotos();
            case 1:
                return arquivoCredenciamentoAluno.getNomeArquivoCsv();
            case 2:
                return arquivoCredenciamentoAluno.getQtdCredenciamentosFeitos();
            case 3:
                return arquivoCredenciamentoAluno.getQtdTotal();
            case 4:
                return arquivoCredenciamentoAluno.getQuantidadeErros();
            case 5:
                return arquivoCredenciamentoAluno.getData();
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
                return Integer.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            case 5:
                return Date.class;
        }
        return String.class;
    }

    @Override
    public int getRowCount() {
        return arquivosCredenciamento.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho.size();
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


}
