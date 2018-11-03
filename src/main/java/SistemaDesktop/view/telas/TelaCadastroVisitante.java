package SistemaDesktop.view.telas;

import SistemaDesktop.view.MenuBar;

public class TelaCadastroVisitante extends TelaCustom {
    public TelaCadastroVisitante() {
        super();

        setJMenuBar(new MenuBar(tela));
        setVisible(true);
    }
}
