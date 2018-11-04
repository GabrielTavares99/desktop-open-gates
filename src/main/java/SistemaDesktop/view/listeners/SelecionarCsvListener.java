package SistemaDesktop.view.listeners;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.paineis.PainelMatricula;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelecionarCsvListener implements ActionListener {

    private JFrame tela;

    public SelecionarCsvListener(JFrame tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("CSV file", "csv");
        jFileChooser.setFileFilter(filter);
        jFileChooser.showOpenDialog(tela);
        if (jFileChooser.getSelectedFile() != null) {
            String path = jFileChooser.getSelectedFile().getAbsolutePath();
            String nomeArquivo = jFileChooser.getSelectedFile().getName();
            TelasUtil.URL_CSV = path;
            PainelMatricula.lblDescricaoArquivoCSV.setText(nomeArquivo);
        } else {
            JOptionPane.showMessageDialog(tela, "Arquivo não selecionado!!!", "ARQUIVO", JOptionPane.WARNING_MESSAGE);
        }
    }
}
