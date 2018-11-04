package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.MatriculaController;
import SistemaDesktop.model.Matricula;
import SistemaDesktop.util.TelasUtil;
import com.opencsv.CSVReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FazerMatriculaListener implements ActionListener {

    private JFrame tela;
    private String[] cabecalho = new String[]{"ra_aluno","disciplina","matricula_professor","semestre","ano","periodo"};
    public FazerMatriculaListener(JFrame tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MatriculaController matriculaController = new MatriculaController();
        matriculaController.fazerMatricula(TelasUtil.URL_CSV);
    }



}
