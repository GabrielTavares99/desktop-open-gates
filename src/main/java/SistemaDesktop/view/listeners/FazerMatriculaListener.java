package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.MatriculaController;
import SistemaDesktop.util.TelasUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FazerMatriculaListener implements ActionListener {

    private JFrame tela;
    private String[] cabecalho = new String[]{"ra_aluno", "disciplina", "matricula_professor", "semestre", "ano", "periodo"};

    public FazerMatriculaListener(JFrame tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MatriculaController matriculaController = new MatriculaController();
        try {
            matriculaController.fazerMatricula();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
//        matriculaController.fazerMatricula(TelasUtil.URL_CSV, TelasUtil.URL_ARQUIVO_FOTOS);


    }


}
