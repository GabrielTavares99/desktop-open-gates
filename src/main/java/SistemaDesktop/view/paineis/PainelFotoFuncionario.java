package SistemaDesktop.view.paineis;

import javax.swing.*;
import java.awt.*;

public class PainelFotoFuncionario extends JPanel {

    public PainelFotoFuncionario(JLabel label, JComponent component) {
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setSize(200, 200);
        setBackground(Color.RED);
        label.setBounds(1,1,getWidth()-2,170);
        component.setBounds(1,getHeight()-32,getWidth()-2,30);
        add(label);
        add(component);
    }
}
