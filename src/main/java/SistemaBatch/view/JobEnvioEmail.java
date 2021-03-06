package SistemaBatch.view;

import SistemaBatch.controller.jobs.JobEnviarEmail;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static commoms.config.ViewSettings.COR_VERDE_SUCESSO;
import static commoms.config.ViewSettings.COR_VERMELHA_ATENCAO;

public class JobEnvioEmail implements ActionListener {

    public static Boolean ativo = false;
    private JButton jButton;

    public JobEnvioEmail(JButton jButton) {
        this.jButton = jButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ativo = !ativo;
        if (ativo) {
            new JobEnviarEmail().start();
            jButton.setText("PARAR");
            jButton.setBackground(COR_VERMELHA_ATENCAO);
        } else {
            jButton.setText("INICIAR");
            jButton.setBackground(COR_VERDE_SUCESSO);
        }
    }
}
