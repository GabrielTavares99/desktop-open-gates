package SistemaBatch.view;

import SistemaBatch.controller.jobs.JobEnviarEmail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobEnvioEmail implements ActionListener {

    public static Boolean ativo = false;
    private JobEnviarEmail jobEnviarEmail ;
    private JButton jButton;

    public JobEnvioEmail(JButton jButton) {
        this.jButton = jButton;
        jobEnviarEmail = new JobEnviarEmail();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ativo = !ativo;
        if (ativo) {
            if (!jobEnviarEmail.isAlive())
                jobEnviarEmail.start();
            jButton.setText("PARAR");
            jButton.setBackground(Color.RED);
        } else {
            jButton.setText("INICIAR");
            jButton.setBackground(Color.green);
        }
    }
}
