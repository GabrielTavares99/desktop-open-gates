package SistemaDesktop.view;

import javax.swing.*;

public abstract class TelaCustom extends JFrame {

    public TelaCustom(String title) {
        setTitle(title);
        setLocationRelativeTo(null);
        setSize(800, 600);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
