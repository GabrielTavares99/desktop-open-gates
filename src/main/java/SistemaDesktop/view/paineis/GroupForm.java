package SistemaDesktop.view.paineis;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GroupForm extends JPanel {

    public GroupForm(JLabel label, JComponent component) {
        setLayout(new GridLayout(2, 1,3,5));
        setBorder(new EmptyBorder(2,3,2,3));
        setSize(200, 60);
        add(label);
        add(component);
    }
}
