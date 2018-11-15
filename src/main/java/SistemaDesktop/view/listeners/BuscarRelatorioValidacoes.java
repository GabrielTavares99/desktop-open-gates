package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.ValidacaoController;
import SistemaDesktop.model.RelatorioValidacoesColetivaModel;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaTerminal.model.Validacao;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class BuscarRelatorioValidacoes implements ActionListener {

    private RelatorioValidacoesColetivaModel tableModel;
    private final JTextField txtPesquisa;
    private final JDateChooser dtInicial;
    private final JDateChooser dtFinal;
    private JTable table;
    private JComboBox tipoUsuario;

    public BuscarRelatorioValidacoes(JTable table, RelatorioValidacoesColetivaModel tableModel, JTextField txtPesquisa, JDateChooser dtInicial, JDateChooser dtFinal, JComboBox tipoUsuario) {
        this.table = table;
        this.tableModel = tableModel;
        this.txtPesquisa = txtPesquisa;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String termo = txtPesquisa.getText();
        Date dataInicial = dtInicial.getDate();
        Date dataFinal = dtFinal.getDate();

        TipoUsuario tipo = null;
        if (!tipoUsuario.getSelectedItem().toString().equals("TODOS")) {
            tipo = TipoUsuario.valueOf(this.tipoUsuario.getSelectedItem().toString());
        }

        ValidacaoController validacaoController = new ValidacaoController();
        List<Validacao> validacaos = validacaoController.pegarValidacoes(termo, tipo, dataInicial, dataFinal);

        System.out.println(validacaos.size());
        tableModel.validacaos = validacaos;
        table.invalidate();
        table.revalidate();
        table.repaint();

    }
}
