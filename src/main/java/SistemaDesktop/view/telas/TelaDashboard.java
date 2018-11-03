package SistemaDesktop.view.telas;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelMenu;
import SistemaDesktop.view.labels.LabelSaudacao;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.paineis.PainelCadastroFuncionario;
import SistemaDesktop.view.paineis.PainelMatricula;
import SistemaDesktop.view.paineis.PainelRelatorio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.Constantes.DASHBOARD;
import static SistemaDesktop.config.Constantes.VER_RELATORIO;

public class TelaDashboard extends TelaCustom {

    JLabel lblSaudacao = new LabelSaudacao("Fulaninho");
    JLabel lblTitulo = new LabelTitulo(DASHBOARD);
    JLabel lblFeatureFazerMatricula = new LabelMenu("FAZER MATRICULA");
    JLabel lblFeatureCadastrarFuncionario = new LabelMenu("CADASTRAR FUNCIONARIO");
    JLabel lblFeatureVerRelatorio = new LabelMenu(VER_RELATORIO);

    JPanel pnGeral = new JPanel();
    JPanel pnFuncoes = new JPanel();

    JPanel pnMatricula = new PainelMatricula();
    JPanel pnCadastrarFuncionario = new PainelCadastroFuncionario();
    JPanel pnRelatorio = new PainelRelatorio();

    List<JComponent> lista_menu = new ArrayList<>();
    List<JComponent> listaMenuFeature = new ArrayList<>();

    public TelaDashboard() {
        super();
        TelasUtil.TELA_ANTERIOR = this;
        pnGeral.setLayout(null);
        pnGeral.add(lblSaudacao);
        pnGeral.add(lblTitulo);

        pnCadastrarFuncionario.add(lblFeatureCadastrarFuncionario);
        pnMatricula.add(lblFeatureFazerMatricula);
        pnRelatorio.add(lblFeatureVerRelatorio);

        listaMenuFeature.add(pnMatricula);
        listaMenuFeature.add(pnCadastrarFuncionario);
        listaMenuFeature.add(pnRelatorio);

        pnFuncoes.setLayout(new GridLayout(1, listaMenuFeature.size()));
        TelasUtil.addItensToTela(pnFuncoes, listaMenuFeature);

        JMenuBar menuBar = new JMenuBar();
        JMenu conta = new JMenu("Minha Conta");
        menuBar.add(conta);
        JMenuItem trocar_senha = new JMenuItem("Trocar Senha");
        JMenuItem saida = new JMenuItem("SAIR");
        conta.add(trocar_senha);
        conta.add(saida);
        pnGeral.add(pnFuncoes);
        setJMenuBar(menuBar);
        setContentPane(pnGeral);
        setVisible(true);
    }
}
