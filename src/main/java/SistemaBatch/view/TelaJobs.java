package SistemaBatch.view;

import SistemaDesktop.view.botoes.BotaoSimples;
import SistemaDesktop.view.paineis.PainelSimples;
import SistemaDesktop.view.telas.TelaCustom;

import javax.swing.*;
import java.awt.*;

import static commoms.config.ViewSettings.COR_VERDE_SUCESSO;
import static commoms.config.ViewSettings.MEIO_TELA_X;

public class TelaJobs extends TelaCustom {


    public TelaJobs() {
        super();
        Image image = Toolkit.getDefaultToolkit().getImage(TelaJobs.class.getClassLoader().getResource("image/open-gate-com-texto.png"));
        ImageIcon imageIcon = new ImageIcon(image);
        imageIcon.setImage(image.getScaledInstance(150, 150, 100));
        JLabel lblTitulo = new JLabel(imageIcon);
        lblTitulo.setBounds(MEIO_TELA_X - 75, 30, 150, 150);
        add(lblTitulo);

        JPanel jPanel = new PainelSimples();
        jPanel.setBounds(MEIO_TELA_X - 100, 250, 200, 80);

        JLabel lblJobEnvioEmail = new JLabel("JOB ENVIO DE EMAIL");
        lblJobEnvioEmail.setForeground(Color.WHITE);
        lblJobEnvioEmail.setBounds(0, 0, 200, 40);
        lblJobEnvioEmail.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(lblJobEnvioEmail);

        JButton btnJobEnvioEmail = new BotaoSimples("INICIAR");
        btnJobEnvioEmail.addActionListener(new JobEnvioEmail(btnJobEnvioEmail));
        btnJobEnvioEmail.setBounds(100 - 50, 40, 100, 30);
        btnJobEnvioEmail.setForeground(Color.WHITE);
        btnJobEnvioEmail.setBackground(COR_VERDE_SUCESSO);
        jPanel.add(btnJobEnvioEmail);
        add(jPanel);

        setVisible(true);
    }


}
