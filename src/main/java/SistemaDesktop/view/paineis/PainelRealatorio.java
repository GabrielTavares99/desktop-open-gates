package SistemaDesktop.view.paineis;

import SistemaDesktop.model.RelatorioValidacoesColetivaModel;
import SistemaDesktop.model.RelatorioValidacoesIndividualModel;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.DataUtil;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.listeners.BuscarRelatorioValidacoes;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

public class PainelRealatorio extends PainelCustom {

    JTextField txtPesquisa = new JTextField();
    JDateChooser dtInicial = new JDateChooser(DataUtil.subtractDays(new Date(), 30), "dd/MM/yyyy"); //Aqui ele seta a data de hoje no formato dd/mm/aaaa
    JDateChooser dtFinal = new JDateChooser(new Date(), "dd/MM/yyyy"); //Aqui ele seta a data de hoje no formato dd/mm/aaaa
    private int margemEsquerda = 20;

    public PainelRealatorio() {
        super();
        setBackground(Color.orange);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        setBounds(10, 80, 700, 400);
        setLayout(null);

//        txtPesquisa.setBounds(margemEsquerda, 30, 200, 35);
//        add(txtPesquisa);

        dtInicial.setBounds(370, 30, 100, 35);
        add(dtInicial);

        dtFinal.setBounds(480, 30, 100, 35);
        add(dtFinal);

        Usuario usuarioLogado = TelasUtil.USUARIO_LOGADO;
        ActionListener listener;
        JTable table;
        JScrollPane scrollPane = new JScrollPane();

        if (TipoUsuario.SECRETARIA.equals(usuarioLogado.getTipoUsuario())) {

            Vector<String> tiposUsuario = new Vector<>();
            tiposUsuario.add("TODOS");
            tiposUsuario.add(TipoUsuario.VISITANTE.toString());
            tiposUsuario.add(TipoUsuario.ALUNO.toString());
            tiposUsuario.add(TipoUsuario.FUNCIONARIO.toString());
            tiposUsuario.add(TipoUsuario.SECRETARIA.toString());
            JComboBox<String> objectJComboBox = new JComboBox(new DefaultComboBoxModel<>(tiposUsuario));
            objectJComboBox.setBounds(230, 30, 120, 35);
            add(objectJComboBox);

            RelatorioValidacoesColetivaModel relatorioValidacoesColetivaModel = new RelatorioValidacoesColetivaModel();
            table = new JTable(relatorioValidacoesColetivaModel);
            scrollPane.getViewport().add(table);
            listener = new BuscarRelatorioValidacoes(table, relatorioValidacoesColetivaModel, txtPesquisa, dtInicial, dtFinal, objectJComboBox);
        } else {
            RelatorioValidacoesIndividualModel relatorioValidacoesIndividualModel = new RelatorioValidacoesIndividualModel();
            table = new JTable(relatorioValidacoesIndividualModel);
            scrollPane.getViewport().add(table);
            listener = new BuscarRelatorioValidacoes(table, relatorioValidacoesIndividualModel, dtInicial, dtFinal);
        }
        scrollPane.setBounds(margemEsquerda, 90, getWidth() - margemEsquerda * 2, 250);
        add(scrollPane);

        JButton pesquisar = new JButton("PESQUISAR");
        pesquisar.setBounds(590, 30, 90, 35);
        pesquisar.addActionListener(listener);
        add(pesquisar);

    }

}
