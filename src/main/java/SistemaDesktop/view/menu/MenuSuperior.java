package SistemaDesktop.view.menu;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.view.listeners.LogoutListener;
import SistemaDesktop.view.listeners.RedefinicaoSenhaListener;
import SistemaDesktop.view.telas.TelaDashboard;

import javax.swing.*;

public class MenuSuperior extends JMenuBar {

    public MenuSuperior(JFrame tela) {
        JMenu conta = new JMenu("Minha Conta");
        add(conta);
        JMenuItem itemMenuVoltarDashboard = new JMenuItem("Voltar");
        JMenuItem itemMenuTrocarSenha = new JMenuItem("Trocar Senha");
        JMenuItem itemMenuSair = new JMenuItem("SAIR");
        conta.add(itemMenuTrocarSenha);
        conta.add(itemMenuSair);
        conta.add(itemMenuVoltarDashboard);
        itemMenuVoltarDashboard.addActionListener(e -> {
            new TelaDashboard().show();
            tela.dispose();
        });
        itemMenuSair.addActionListener(new LogoutListener(tela));
        itemMenuTrocarSenha.addActionListener(new RedefinicaoSenhaListener(tela, TipoRedefinicaoSenha.REDEFINICAO_COM_SENHA));
        itemMenuTrocarSenha.addMouseListener(new RedefinicaoSenhaListener(tela, TipoRedefinicaoSenha.REDEFINICAO_COM_SENHA));

    }
}
