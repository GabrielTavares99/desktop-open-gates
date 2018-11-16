package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.MatriculaController;
import SistemaDesktop.controller.dao.ArquivoCredenciamentoAlunoDAO;
import SistemaDesktop.model.ArquivoCredenciamentoAluno;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.paineis.PainelMatricula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static SistemaDesktop.view.telas.TelaMatricula.modeloTabelaCredenciamentoAluno;
import static SistemaDesktop.view.telas.TelaMatricula.tabelaCredenciamentoAluno;

public class FazerMatriculaListener implements ActionListener {

    private MatriculaController matriculaController = new MatriculaController();

    public FazerMatriculaListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean sucessoMatricula = matriculaController.fazerMatricula();
        if (!sucessoMatricula) {
            JOptionPane.showMessageDialog(null, "Arquivos não selecionados ou Corrompidos!");
        } else {
            List<ArquivoCredenciamentoAluno> arquivoCredenciamentoAlunos = new ArquivoCredenciamentoAlunoDAO().pegarTodosImp();
            modeloTabelaCredenciamentoAluno.setArquivosCredenciamento(arquivoCredenciamentoAlunos);
            tabelaCredenciamentoAluno.invalidate();
            tabelaCredenciamentoAluno.revalidate();
            tabelaCredenciamentoAluno.repaint();
            TelasUtil.URL_CSV = null;
            TelasUtil.URL_ARQUIVO_FOTOS = null;
            PainelMatricula.lblDescricaoArquivoFoto.setText("Arquivo não selecionado");
            PainelMatricula.lblDescricaoArquivoCSV.setText("Arquivo não selecionado");
        }


    }


}
