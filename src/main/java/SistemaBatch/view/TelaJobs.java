package SistemaBatch.view;

import SistemaDesktop.view.telas.TelaCustom;

import javax.swing.*;
import java.awt.*;

import static SistemaDesktop.config.ViewSettings.MEIO_TELA_X;

public class TelaJobs extends TelaCustom {


    public TelaJobs() {
        super();
        Image image = Toolkit.getDefaultToolkit().getImage(TelaJobs.class.getClassLoader().getResource("image/open-gates-logo.png"));
        ImageIcon imageIcon = new ImageIcon(image);
        imageIcon.setImage(image.getScaledInstance(150, 150, 100));
        JLabel lblTitulo = new JLabel(imageIcon);
        lblTitulo.setBounds(MEIO_TELA_X - 75, 30, 150, 150);
        add(lblTitulo);

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.red);
        jPanel.setLayout(null);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        jPanel.setBounds(MEIO_TELA_X - 100, 250, 200, 80);

        JLabel lblJobEnvioEmail = new JLabel("JOB ENVIA EMAIL");
        lblJobEnvioEmail.setBounds(0, 0, 200, 40);
        lblJobEnvioEmail.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(lblJobEnvioEmail);

        JButton btnJobEnvioEmail = new JButton("INICIAR");
        btnJobEnvioEmail.addActionListener(new JobEnvioEmail(btnJobEnvioEmail));
        btnJobEnvioEmail.setBounds(100 - 50, 40, 100, 30);
        btnJobEnvioEmail.setForeground(Color.WHITE);
        btnJobEnvioEmail.setBackground(Color.green);
        jPanel.add(btnJobEnvioEmail);
        add(jPanel);

        setVisible(true);
    }


}
