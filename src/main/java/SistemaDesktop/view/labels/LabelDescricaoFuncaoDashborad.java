package SistemaDesktop.view.labels;

import javax.swing.*;
import java.awt.*;

import static SistemaDesktop.view.telas.TelaDashboard.PAINEL_FUNCAO_WIDTH;

public class LabelDescricaoFuncaoDashborad extends JLabel {

    public LabelDescricaoFuncaoDashborad(String descricao) {
        setText(descricao);
        setBounds(0, 100, PAINEL_FUNCAO_WIDTH, 30);
        setHorizontalAlignment(SwingConstants.CENTER);
        setForeground(Color.WHITE);
    }

}
