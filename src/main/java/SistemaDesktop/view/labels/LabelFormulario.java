package SistemaDesktop.view.labels;

import javax.swing.*;
import java.awt.*;

public class LabelFormulario extends LabelCustom {
    public LabelFormulario(String descricao) {
        super(descricao);
        setHorizontalAlignment(SwingConstants.CENTER);
        new Font("Serif", Font.BOLD, 50);
        setForeground(Color.WHITE);
    }
}
