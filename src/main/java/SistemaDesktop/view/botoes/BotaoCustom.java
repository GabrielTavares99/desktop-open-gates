package SistemaDesktop.view.botoes;

import javax.swing.*;

import static SistemaDesktop.config.ViewSettings.*;

public abstract class BotaoCustom extends JButton {

    public BotaoCustom(String descricao) {
        setText(descricao);
        setSize(BOTAO_DEFAULT_WIDTH, BOTAO_DEFAULT_HEIGHT);
        setBackground(BOTAO_DEFAULT_COLOR);

    }

}
