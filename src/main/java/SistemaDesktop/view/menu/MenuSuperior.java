package SistemaDesktop.view.menu;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.view.listeners.LogoutListener;
import SistemaDesktop.view.listeners.RedefinicaoSenhaListener;
import SistemaDesktop.view.telas.TelaDashboard;

import javax.swing.*;

public class MenuSuperior extends JMenuBar {

    public MenuSuperior(JFrame tela) {
        JMenu navegacao = new JMenu("Navegação");
        JMenu conta = new JMenu("Minha Conta");

        add(navegacao);
        add(conta);

        JMenuItem itemMenuVoltarDashboard = new JMenuItem("Voltar");
        JMenuItem itemMenuTrocarSenha = new JMenuItem("Trocar Senha");
        JMenuItem itemMenuSair = new JMenuItem("SAIR");

        conta.add(itemMenuTrocarSenha);

        navegacao.add(itemMenuVoltarDashboard);
        navegacao.add(itemMenuSair);

        itemMenuVoltarDashboard.addActionListener(e -> {
            new TelaDashboard();
            tela.dispose();
        });

        itemMenuSair.addActionListener(new LogoutListener(tela));
        itemMenuTrocarSenha.addActionListener(new RedefinicaoSenhaListener(tela, TipoRedefinicaoSenha.REDEFINICAO_COM_SENHA));
        itemMenuTrocarSenha.addMouseListener(new RedefinicaoSenhaListener(tela, TipoRedefinicaoSenha.REDEFINICAO_COM_SENHA));

    }
}
