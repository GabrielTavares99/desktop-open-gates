package SistemaDesktop.view.labels;

import javax.swing.*;
import java.awt.*;

import static commoms.config.ViewSettings.TELA_DEFAULT_WIDTH;

public class LabelTitulo extends LabelCustom {
    public LabelTitulo(String descricao) {
        super(descricao);
        setFont(new Font("Sarif", Font.BOLD, 30));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(0, 25, TELA_DEFAULT_WIDTH, 40);
    }
}
