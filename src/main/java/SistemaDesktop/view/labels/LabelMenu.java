package SistemaDesktop.view.labels;

import SistemaDesktop.view.listeners.LogOutListener;

public class LabelMenu extends LabelCustom {
    public LabelMenu(String descricao) {
        super(descricao);
        setBounds(0,0,100,200);
        addMouseListener(new LogOutListener());
    }
}
