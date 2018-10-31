package SistemaDesktop.view.botoes;

import SistemaDesktop.view.listeners.FazerLoginListener;

import javax.swing.*;

public class BotaoSubmissao extends BotaoCustom {
    public BotaoSubmissao(JFrame tela, String descricao) {
        super(descricao);
        addActionListener(new FazerLoginListener(tela));
    }
}
