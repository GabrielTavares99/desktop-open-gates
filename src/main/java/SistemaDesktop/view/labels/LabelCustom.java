package SistemaDesktop.view.labels;

import javax.swing.*;

import static SistemaDesktop.config.ViewSettings.LABEL_DEFAULT_HEIGHT;
import static SistemaDesktop.config.ViewSettings.LABEL_DEFAULT_WIDTH;

public class LabelCustom extends JLabel {
    public LabelCustom(String descricao) {
        setText(descricao);
        setSize(LABEL_DEFAULT_WIDTH, LABEL_DEFAULT_HEIGHT);
    }
    public LabelCustom() {
        setSize(LABEL_DEFAULT_WIDTH, LABEL_DEFAULT_HEIGHT);
    }
}
