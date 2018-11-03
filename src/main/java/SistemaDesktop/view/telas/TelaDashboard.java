package SistemaDesktop.view.telas;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelSaudacao;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.listeners.LogoutListener;
import SistemaDesktop.view.paineis.PainelCadastroFuncionario;
import SistemaDesktop.view.paineis.PainelFuncoesDashboard;
import SistemaDesktop.view.paineis.PainelMatricula;
import SistemaDesktop.view.paineis.PainelRelatorio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.Constantes.DASHBOARD;

public class TelaDashboard extends TelaCustom {

    public static int NUMERO_FUNCOES = 0;
    public static int PAINEL_FUNCAO_WIDTH = 0;
    JLabel lblSaudacao = new LabelSaudacao("Fulaninho");
    JLabel lblTitulo = new LabelTitulo(DASHBOARD);
    JPanel pnGeral = new JPanel();
    JPanel pnFuncoesDashboard = new PainelFuncoesDashboard();
    List<JComponent> listaMenuFeature = new ArrayList<>();
    JFrame tela = this;
    JMenuBar menuSuperior = new JMenuBar();

    public TelaDashboard() {
        super();
        TelasUtil.TELA_ANTERIOR = this;
        pnGeral.setLayout(null);
        pnGeral.add(lblSaudacao);
        pnGeral.add(lblTitulo);

        NUMERO_FUNCOES = 3;
        PAINEL_FUNCAO_WIDTH = (600 / NUMERO_FUNCOES);
        listaMenuFeature.add(new PainelMatricula());
        listaMenuFeature.add(new PainelCadastroFuncionario());
        listaMenuFeature.add(new PainelRelatorio());

        pnFuncoesDashboard.setLayout(new GridLayout(1, NUMERO_FUNCOES));
        TelasUtil.addItensToTela(pnFuncoesDashboard, listaMenuFeature);

        JMenu conta = new JMenu("Minha Conta");
        menuSuperior.add(conta);
        JMenuItem trocar_senha = new JMenuItem("Trocar Senha");
        JMenuItem saida = new JMenuItem("SAIR");
        conta.add(trocar_senha);
        conta.add(saida);
        saida.addActionListener(new LogoutListener(tela));

        pnGeral.add(pnFuncoesDashboard);
        setJMenuBar(menuSuperior);
        setContentPane(pnGeral);
        setVisible(true);
    }
}
