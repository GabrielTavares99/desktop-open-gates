package SistemaDesktop.view.paineis;

import javax.swing.*;
import java.awt.*;

public class PainelMatricula extends PainelCustom {


    JLabel lblArquivoFotos;
    JLabel lblDescricaoArquivoFoto = new JLabel("arquivo.zip");
    JLabel lblArquivoCSV;
    JLabel lblDescricaoArquivoCSV = new JLabel("arquivo2.csv");
    JButton btnBuscarArquivoFotos = new JButton("PROCURAR");
    JButton btnBuscarArquivoCSV = new JButton("PROCURAR");
    JPanel painelArquivoFotos = new JPanel();
    JPanel pnArquivoCSV = new JPanel();
    JButton fazerMatricula = new JButton("MATRICULAR");

    public PainelMatricula() {
        super();
        setBounds(50, 315, 700, 300);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("../").getPath() + "images/icone-foto.jpg");
        imageIcon.getImage().getScaledInstance(100, 200, 100);
        lblArquivoFotos = new JLabel(imageIcon);

        painelArquivoFotos.setLayout(null);
        painelArquivoFotos.setOpaque(true);
        painelArquivoFotos.setBackground(Color.orange);
        painelArquivoFotos.setBounds(10, 10, 200, 250);

        lblArquivoFotos.setBounds(10, 10, 180, 100);
        painelArquivoFotos.add(lblArquivoFotos);

        lblDescricaoArquivoFoto.setBounds(0, 100, 200, 30);
        painelArquivoFotos.add(lblDescricaoArquivoFoto);

        btnBuscarArquivoFotos.setBounds(0, 130, 200, 30);
        painelArquivoFotos.add(btnBuscarArquivoFotos);

        pnArquivoCSV.setBackground(Color.green);
        pnArquivoCSV.setLayout(null);
        pnArquivoCSV.setBackground(Color.cyan);
        pnArquivoCSV.setBounds(250, 10, 200, 250);

        imageIcon = new ImageIcon(getClass().getResource("../").getPath() + "images/csv.png");
        imageIcon.getImage().getScaledInstance(100, 200, 100);
        lblArquivoCSV = new JLabel(imageIcon);

        lblArquivoCSV.setBounds(10, 10, 180, 100);
        pnArquivoCSV.add(lblArquivoCSV);

        lblDescricaoArquivoCSV.setBounds(0, 100, 200, 30);
        pnArquivoCSV.add(lblDescricaoArquivoCSV);

        btnBuscarArquivoCSV.setBounds(0, 130, 200, 30);
        pnArquivoCSV.add(btnBuscarArquivoCSV);


        fazerMatricula.setBounds(500, 200, 150, 30);
        add(fazerMatricula);

        add(pnArquivoCSV);
        add(painelArquivoFotos);

    }

}
