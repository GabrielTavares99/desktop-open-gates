package SistemaDesktop.controller.modelosTabela;

import SistemaDesktop.controller.dao.FuncionarioDAO;
import SistemaDesktop.model.Funcionario;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ModeloTabelaCadastroFuncionario extends AbstractTableModel {
    private String colunas[] = new String[]{"#", "Nome", "CPF", "Email", "Cargo", "Ativo"};

    private List<Object> funcionarios;
    private JTable table;
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public ModeloTabelaCadastroFuncionario(JTable table) {
        this.table = table;
        funcionarios = funcionarioDAO.pegarTodos();
    }

    public List<Object> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Object> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void atualizar() {
        funcionarios = funcionarioDAO.pegarTodos();
        table.invalidate();
        table.revalidate();
        table.repaint();
    }

    @Override
    public String getColumnName(int column) {
        if (column > colunas.length || column < 0) {
            return null;
        }
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario funcionario = (Funcionario) funcionarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return funcionario.getNome();
            case 2:
                return funcionario.getUsuario().getCpf();
            case 3:
                return funcionario.getUsuario().getEmail();
            case 4:
                return funcionario.getCargo().getDescricao();
            case 5:
                return funcionario.getUsuario().isAtivo();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Boolean.class;
        }
        return null;
    }
}
