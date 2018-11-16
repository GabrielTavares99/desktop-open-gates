package SistemaDesktop.view.telas;


import SistemaDesktop.controller.dao.ArquivoCredenciamentoAlunoDAO;
import SistemaDesktop.controller.modelosTabela.ModeloTabelaArquivoCredenciamentoAluno;
import SistemaDesktop.model.ArquivoCredenciamentoAluno;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.view.paineis.PainelMatricula;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static SistemaDesktop.config.Constantes.TITULO_TELA_MATRICULA;
import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class TelaMatricula extends TelaCustom {
    public static JTable tabelaCredenciamentoAluno = new JTable();
    public static ModeloTabelaArquivoCredenciamentoAluno modeloTabelaCredenciamentoAluno;
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_MATRICULA);
    JPanel pnMatricula;
    private ArquivoCredenciamentoAlunoDAO arquivoCredenciamentoAlunoDAO = new ArquivoCredenciamentoAlunoDAO();

    public TelaMatricula() {
        super();
        add(lblTitulo);

        List<ArquivoCredenciamentoAluno> all = arquivoCredenciamentoAlunoDAO.pegarTodosImp();
        modeloTabelaCredenciamentoAluno = new ModeloTabelaArquivoCredenciamentoAluno();
        modeloTabelaCredenciamentoAluno.setArquivosCredenciamento(all);
        tabelaCredenciamentoAluno.setModel(modeloTabelaCredenciamentoAluno);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelaCredenciamentoAluno.setDefaultRenderer(Integer.class, centerRenderer);
//        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );


        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            public Component getTableCellRendererComponent(JTable table,
                                                           Object value, boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                if (value instanceof Date) {
                    value = f.format(value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
            }
        };

        tabelaCredenciamentoAluno.getColumnModel().getColumn(6).setCellRenderer(tableCellRenderer);
        JScrollPane scroolPane = new JScrollPane(tabelaCredenciamentoAluno);
        scroolPane.setBounds(50, 85, 700, 200);
        add(scroolPane);

        pnMatricula = new PainelMatricula(tela);
        add(pnMatricula);

        TELA_ANTERIOR = this;
        setJMenuBar(new MenuSuperior(tela));

        setVisible(true);
    }
}
