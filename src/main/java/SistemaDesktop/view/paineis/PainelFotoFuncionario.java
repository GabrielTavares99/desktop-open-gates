package SistemaDesktop.view.paineis;

import SistemaDesktop.util.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class PainelFotoFuncionario extends PainelCustom {

    public PainelFotoFuncionario(JLabel label, JComponent component) {
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setSize(210, 260);
        setBackground(Color.WHITE);

        label.setBounds(2, 2, getWidth() - 4, 220);
        label.setIcon(new ImageIcon(ImageUtil.getImagemProporcional("image/avatar.png", label.getWidth(), label.getHeight())));
        add(label);

        component.setBounds(2, getHeight() - 34, getWidth() - 4, 30);
        add(component);
    }
}
