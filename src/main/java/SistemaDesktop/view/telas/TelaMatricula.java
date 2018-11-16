package SistemaDesktop.view.telas;


import SistemaDesktop.controller.dao.ArquivoCredenciamentoAlunoDAO;
import SistemaDesktop.controller.modelosTabela.ModeloTabelaArquivoCredenciamentoAluno;
import SistemaDesktop.model.ArquivoCredenciamentoAluno;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.view.paineis.PainelMatricula;

import javax.swing.*;
import java.util.List;

import static SistemaDesktop.config.Constantes.TITULO_TELA_MATRICULA;
import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class TelaMatricula extends TelaCustom {
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_MATRICULA);
    public static JTable tabelaCredenciamentoAluno = new JTable();
    public static ModeloTabelaArquivoCredenciamentoAluno modeloTabelaCredenciamentoAluno;
    JPanel pnMatricula;
    private ArquivoCredenciamentoAlunoDAO arquivoCredenciamentoAlunoDAO = new ArquivoCredenciamentoAlunoDAO();

    public TelaMatricula() {
        super();
        add(lblTitulo);

        List<ArquivoCredenciamentoAluno> all = arquivoCredenciamentoAlunoDAO.pegarTodosImp();
        modeloTabelaCredenciamentoAluno = new ModeloTabelaArquivoCredenciamentoAluno();
        modeloTabelaCredenciamentoAluno.setArquivosCredenciamento(all);
        tabelaCredenciamentoAluno.setModel(modeloTabelaCredenciamentoAluno);
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
