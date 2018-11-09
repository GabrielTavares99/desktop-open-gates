package SistemaDesktop.view.paineis;

import SistemaDesktop.view.listeners.FazerMatriculaListener;
import SistemaDesktop.view.listeners.SelecionarArquivoFotos;
import SistemaDesktop.view.listeners.SelecionarCsvListener;

import javax.swing.*;
import java.awt.*;

import static SistemaDesktop.config.ViewSettings.COR_PAINEL_FEATURE_LARANJA;

public class PainelMatricula extends PainelCustom {

    public static JLabel lblDescricaoArquivoFoto = new JLabel("Arquivo não selecionado!");
    public static JLabel lblDescricaoArquivoCSV = new JLabel("Arquivo não selecionado!");
    JLabel lblArquivoFotos;
    JLabel lblArquivoCSV;
    JPanel painelArquivoFotos = new JPanel();
    JPanel pnArquivoCSV = new JPanel();
    JButton btnBuscarArquivoFotos = new JButton("PROCURAR");
    JButton btnBuscarArquivoCSV = new JButton("PROCURAR");
    JButton btnFazerMatricula = new JButton("MATRICULAR");

    public PainelMatricula(JFrame tela) {
        super();
        setBounds(50, 290, 700, 250);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(PainelMatricula.class.getClassLoader().getResource("image/icone-zip.png"));
        imageIcon.getImage().getScaledInstance(64, 64, 100);
        lblArquivoFotos = new JLabel(imageIcon);

        painelArquivoFotos.setLayout(null);
        painelArquivoFotos.setOpaque(true);
        painelArquivoFotos.setBackground(COR_PAINEL_FEATURE_LARANJA);
        painelArquivoFotos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        painelArquivoFotos.setBounds(10, 10, 200, 230);

        lblArquivoFotos.setBounds(10, 10, 180, 100);
        painelArquivoFotos.add(lblArquivoFotos);

        lblDescricaoArquivoFoto.setBounds(0, 100, 200, 30);
        lblDescricaoArquivoFoto.setHorizontalAlignment(SwingConstants.CENTER);
        painelArquivoFotos.add(lblDescricaoArquivoFoto);

        btnBuscarArquivoFotos.setBounds(2, 199, 196, 28);
        painelArquivoFotos.add(btnBuscarArquivoFotos);

        pnArquivoCSV.setBackground(Color.green);
        pnArquivoCSV.setLayout(null);
        pnArquivoCSV.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        pnArquivoCSV.setBackground(COR_PAINEL_FEATURE_LARANJA);
        pnArquivoCSV.setBounds(250, 10, 200, 230);

        imageIcon = new ImageIcon(PainelMatricula.class.getClassLoader().getResource("image/icone-csv.png"));
        imageIcon.getImage().getScaledInstance(64, 64, 100);
        lblArquivoCSV = new JLabel(imageIcon);

        lblArquivoCSV.setBounds(10, 10, 180, 100);
        pnArquivoCSV.add(lblArquivoCSV);

        lblDescricaoArquivoCSV.setBounds(0, 100, 200, 30);
        lblDescricaoArquivoCSV.setHorizontalAlignment(SwingConstants.CENTER);
        pnArquivoCSV.add(lblDescricaoArquivoCSV);

        btnBuscarArquivoCSV.setBounds(2, 199, 196, 28);;
        pnArquivoCSV.add(btnBuscarArquivoCSV);

        btnFazerMatricula.setBounds(500, 200, 150, 30);

        btnBuscarArquivoCSV.addActionListener(new SelecionarCsvListener(tela));
        btnBuscarArquivoFotos.addActionListener(new SelecionarArquivoFotos(tela));
        btnFazerMatricula.addActionListener(new FazerMatriculaListener(tela));

        add(btnFazerMatricula);
        add(pnArquivoCSV);
        add(painelArquivoFotos);

    }

}
