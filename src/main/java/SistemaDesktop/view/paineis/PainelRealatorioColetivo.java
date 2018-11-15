package SistemaDesktop.view.paineis;

import SistemaDesktop.controller.modelosTabela.ModeloTabelaEntradaSaidaIndividual;
import SistemaDesktop.model.RelatorioValidacoesColetivaModel;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.view.listeners.BuscarRelatorioValidacoes;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Vector;

public class PainelRealatorioColetivo extends PainelCustom {

    JTextField txtPesquisa = new JTextField();
    private int margemEsquerda = 20;
    JDateChooser dtInicial = new JDateChooser(new Date(), "dd/MM/yyyy"); //Aqui ele seta a data de hoje no formato dd/mm/aaaa
    JDateChooser dtFinal = new JDateChooser(new Date(), "dd/MM/yyyy"); //Aqui ele seta a data de hoje no formato dd/mm/aaaa

    public PainelRealatorioColetivo() {
        super();
        setBackground(Color.orange);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        setBounds(10, 80, 700, 400);
        setLayout(null);

        txtPesquisa.setBounds(margemEsquerda, 30, 200, 35);
        add(txtPesquisa);

        Vector<String> tiposUsuario = new Vector<>();
        tiposUsuario.add("TODOS");
        tiposUsuario.add(TipoUsuario.VISITANTE.toString());
        tiposUsuario.add(TipoUsuario.ALUNO.toString());
        tiposUsuario.add(TipoUsuario.FUNCIONARIO.toString());
        tiposUsuario.add(TipoUsuario.SECRETARIA.toString());
        JComboBox<String> objectJComboBox = new JComboBox(new DefaultComboBoxModel<>(tiposUsuario));
        objectJComboBox.setBounds(230, 30, 120, 35);
        add(objectJComboBox);

        dtInicial.setBounds(370, 30, 100, 35);
        add(dtInicial);

        dtFinal.setBounds(480, 30, 100, 35);
        add(dtFinal);

//        ModeloTabelaEntradaSaidaIndividual modeloTabelaEntradaSaidaIndividual = new ModeloTabelaEntradaSaidaIndividual();
        RelatorioValidacoesColetivaModel relatorioValidacoesColetivaModel = new RelatorioValidacoesColetivaModel();
        JTable table = new JTable(relatorioValidacoesColetivaModel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setBounds(margemEsquerda, 90, getWidth() - margemEsquerda * 2, 250);
        add(scrollPane);

        BuscarRelatorioValidacoes listener = new BuscarRelatorioValidacoes(table,relatorioValidacoesColetivaModel, txtPesquisa, dtInicial, dtFinal, objectJComboBox);
        JButton pesquisar = new JButton("PESQUISAR");
        pesquisar.setBounds(590,30,90,35);
        pesquisar.addActionListener(listener);
        add(pesquisar);

    }

}
