package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.MatriculaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FazerMatriculaListener implements ActionListener {

    private JFrame tela;
    private String[] cabecalho = new String[]{"ra_aluno", "disciplina", "matricula_professor", "semestre", "ano", "periodo"};

    public FazerMatriculaListener(JFrame tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MatriculaController matriculaController = new MatriculaController();
        matriculaController.fazerMatricula();
        //        matriculaController.fazerMatricula(TelasUtil.URL_CSV, TelasUtil.URL_ARQUIVO_FOTOS);


    }


}
