package SistemaDesktop.view.telas;

import SistemaDesktop.view.MenuBar;
import SistemaDesktop.view.labels.LabelTitulo;

import javax.swing.*;

import static SistemaDesktop.config.Constantes.TITULO_TELA_CADASTRO_FUNCIONARIO;

public class TelaCadastroFuncionario extends TelaCustom {

    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_CADASTRO_FUNCIONARIO);

    public TelaCadastroFuncionario() {
        super();
        add(lblTitulo);
        setJMenuBar(new MenuBar(tela));
        setVisible(true);
    }
}
