package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.modelosTabela.TabelaValidacoesModelCustom;
import SistemaDesktop.controller.ValidacaoController;
import SistemaDesktop.model.RelatorioValidacoesColetivaModel;
import SistemaDesktop.model.RelatorioValidacoesIndividualModel;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
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
    private JComboBox tipoUsuario;

    public BuscarRelatorioValidacoes(JTable table, RelatorioValidacoesColetivaModel tableModel, JTextField txtPesquisa, JDateChooser dtInicial, JDateChooser dtFinal, JComboBox tipoUsuario) {
        this.table = table;
        this.tableModel = tableModel;
        this.txtPesquisa = txtPesquisa;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        this.tipoUsuario = tipoUsuario;
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

        if (tipoUsuario == null) {
            Usuario usuarioLogado = TelasUtil.USUARIO_LOGADO;
            validacaos = validacaoController.pegarValidacoesIndividuais(usuarioLogado, dataInicial, dataFinal);
        } else if (!tipoUsuario.getSelectedItem().toString().equals("TODOS")) {
            TipoUsuario tipo;
            tipo = TipoUsuario.valueOf(this.tipoUsuario.getSelectedItem().toString());
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
