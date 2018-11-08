package SistemaDesktop.view.paineis;

import javax.swing.*;
import java.awt.*;

public class GroupForm extends JPanel {

    public GroupForm(JLabel label, JComponent component) {
        setLayout(new GridLayout(2, 1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setSize(200, 60);
        add(label);
        add(component);
    }
}
