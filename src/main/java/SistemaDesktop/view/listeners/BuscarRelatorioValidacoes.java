package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.ValidacaoController;
import SistemaDesktop.controller.modelosTabela.TabelaValidacoesModelCustom;
import SistemaDesktop.model.RelatorioValidacoesColetivaModel;
import SistemaDesktop.model.RelatorioValidacoesIndividualModel;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.TelasUtil;
import SistemaTerminal.model.Validacao;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class BuscarRelatorioValidacoes implements ActionListener {

    ValidacaoController validacaoController = new ValidacaoController();
    private JTextField txtPesquisa = new JTextField();
    private JDateChooser dtInicial;
    private JDateChooser dtFinal;
    private TabelaValidacoesModelCustom tableModel;
    private JTable table;
    private JComboBox comboTipoUsuario;

    public BuscarRelatorioValidacoes(JTable table, RelatorioValidacoesColetivaModel tableModel, JTextField txtPesquisa, JDateChooser dtInicial, JDateChooser dtFinal, JComboBox comboTipoUsuario) {
        this.table = table;
        this.tableModel = tableModel;
        this.txtPesquisa = txtPesquisa;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        this.comboTipoUsuario = comboTipoUsuario;
        List<Validacao> validacaos = validacaoController.pegarValidacoes("", null, dtInicial.getDate(), dtFinal.getDate());
        atualizarTabela(validacaos);
    }

    public BuscarRelatorioValidacoes(JTable table, RelatorioValidacoesIndividualModel tableModel, JDateChooser dtInicial, JDateChooser dtFinal) {
        this.table = table;
        this.tableModel = tableModel;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        Usuario usuarioLogado = TelasUtil.USUARIO_LOGADO;
        List<Validacao> validacaos = validacaoController.pegarValidacoesIndividuais(usuarioLogado, dtInicial.getDate(), dtFinal.getDate());
        atualizarTabela(validacaos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Validacao> validacaos = null;
        String termo = txtPesquisa.getText();
        Date dataInicial = dtInicial.getDate();
        Date dataFinal = dtFinal.getDate();

        if (comboTipoUsuario == null) {
            Usuario usuarioLogado = TelasUtil.USUARIO_LOGADO;
            validacaos = validacaoController.pegarValidacoesIndividuais(usuarioLogado, dataInicial, dataFinal);
        } else {
            String tipo;
            if (comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("TODOS"))
                tipo = null;
            else
                tipo = comboTipoUsuario.getSelectedItem().toString();

            validacaos = validacaoController.pegarValidacoes(termo, tipo, dataInicial, dataFinal);
        }
        System.out.println(validacaos.size());
        atualizarTabela(validacaos);
    }

    public void atualizarTabela(List<Validacao> validacaos) {
        tableModel.setValidacaos(validacaos);
        table.invalidate();
        table.revalidate();
        table.repaint();
    }
}
