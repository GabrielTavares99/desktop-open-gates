package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.MatriculaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FazerMatriculaListener implements ActionListener {

    private JFrame tela;
    private MatriculaController matriculaController = new MatriculaController();

    public FazerMatriculaListener(JFrame tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        matriculaController.fazerMatricula();
    }


}
