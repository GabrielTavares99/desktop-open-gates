package SistemaDesktop.view.telas;

import SistemaDesktop.view.menu.MenuSuperior;

public class TelaCadastroVisitante extends TelaCustom {
    public TelaCadastroVisitante() {
        super();

        setJMenuBar(new MenuSuperior(tela));
        setVisible(true);
    }
}
