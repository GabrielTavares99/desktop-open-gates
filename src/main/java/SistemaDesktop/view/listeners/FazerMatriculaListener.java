package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.MatriculaController;
import SistemaDesktop.controller.dao.ArquivoCredenciamentoAlunoDAO;
import SistemaDesktop.model.ArquivoCredenciamentoAluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static SistemaDesktop.view.telas.TelaMatricula.modeloTabelaCredenciamentoAluno;
import static SistemaDesktop.view.telas.TelaMatricula.tabelaCredenciamentoAluno;

public class FazerMatriculaListener implements ActionListener {

    private JFrame tela;
    private MatriculaController matriculaController = new MatriculaController();

    public FazerMatriculaListener(JFrame tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        matriculaController.fazerMatricula();

        List<ArquivoCredenciamentoAluno> arquivoCredenciamentoAlunos = new ArquivoCredenciamentoAlunoDAO().pegarTodosImp();
        modeloTabelaCredenciamentoAluno.setArquivosCredenciamento(arquivoCredenciamentoAlunos);
        tabelaCredenciamentoAluno.invalidate();
        tabelaCredenciamentoAluno.revalidate();
        tabelaCredenciamentoAluno.repaint();
    }


}
