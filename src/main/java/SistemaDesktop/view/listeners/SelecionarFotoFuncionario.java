package SistemaDesktop.view.listeners;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.telas.TelaCadastroFuncionario;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SelecionarFotoFuncionario implements ActionListener {
    private JFrame tela;

    public SelecionarFotoFuncionario(JFrame tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File foto;
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("Images file", "png", "jpg");
        jFileChooser.setFileFilter(filter);
        jFileChooser.showOpenDialog(tela);
        if (jFileChooser.getSelectedFile() != null) {
            foto = jFileChooser.getSelectedFile();
        } else {
            JOptionPane.showMessageDialog(tela, "Foto não selecionada!!!", "ARQUIVO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        TelasUtil.URL_FOTO_FUNCIONARIO = foto.getAbsolutePath();
        Image image = Toolkit.getDefaultToolkit().getImage(foto.getAbsolutePath());
        ImageIcon imageIcon = new ImageIcon(image);
        imageIcon.setImage(image.getScaledInstance(198, 170, 100));
        TelaCadastroFuncionario.lblImagemFuncionario.setIcon(imageIcon);
        TelaCadastroFuncionario.lblImagemFuncionario.repaint();
    }
}
