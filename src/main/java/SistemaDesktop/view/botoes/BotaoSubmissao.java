package SistemaDesktop.view.botoes;

import SistemaDesktop.view.listeners.FazerLoginListener;

import javax.swing.*;
import java.awt.*;

public class BotaoSubmissao extends BotaoCustom {
    public BotaoSubmissao(JFrame tela, String descricao) {
        super(descricao);
        FazerLoginListener fazerLoginListener = new FazerLoginListener(tela);
        addMouseListener(fazerLoginListener);
        addActionListener(fazerLoginListener);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 200), 1, true));
        setFont(new Font("Sarif", Font.BOLD, 15));
    }
}
