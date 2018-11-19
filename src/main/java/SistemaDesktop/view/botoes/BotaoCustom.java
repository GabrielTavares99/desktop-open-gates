package SistemaDesktop.view.botoes;

import javax.swing.*;
import java.awt.*;

import static commoms.config.ViewSettings.*;

public abstract class BotaoCustom extends JButton {

    private Cursor cursor;

    public BotaoCustom(String descricao) {
        setText(descricao);
        setSize(BOTAO_DEFAULT_WIDTH, BOTAO_DEFAULT_HEIGHT);
        setBackground(DEFAULT_COLOR_BOTAO);
        setForeground(Color.WHITE);
        setFont(new Font("Serif", Font.BOLD, 14));
        setBorder(BorderFactory.createLineBorder(Color.white, 1, true));

    }

}
