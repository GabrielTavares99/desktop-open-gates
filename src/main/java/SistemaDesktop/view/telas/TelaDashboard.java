package SistemaDesktop.view.telas;
//TESTE GIT

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelMenu;
import SistemaDesktop.view.labels.LabelSaudacao;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.paineis.PainelCadastroFuncionario;
import SistemaDesktop.view.paineis.PainelMatricula;
import SistemaDesktop.view.paineis.PainelMenu;
import SistemaDesktop.view.paineis.PainelRelatorio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.util.TelasUtil.TELA_ANTERIOR;

public class TelaDashboard extends TelaCustom {

    JLabel lblSaudacao = new LabelSaudacao("BOA ???");
    JLabel lblTitulo = new LabelTitulo("DASHBOARD");
    JLabel lblSair = new LabelMenu("LOG OUT");
    JLabel lblTrocarSenha = new LabelMenu("PASSWORD");
    JLabel lblFeatureFazerMatricula = new LabelMenu("FAZER MATRICULA");
    JLabel lblFeatureCadastrarFuncionario = new LabelMenu("CADASTRAR FUNCIOPNARIO");
    JLabel lblFeatureVerRelatorio = new LabelMenu("VER RELATORIO");

    JPanel pnGeral = new JPanel();
    JPanel pnFuncoes = new JPanel();
    JPanel pnMenu = new PainelMenu();

    JPanel pnMatricula = new PainelMatricula();
    JPanel pnCadastrarFuncionario = new PainelCadastroFuncionario();
    JPanel pnRelatorio = new PainelRelatorio();

    List<JComponent> lista_menu = new ArrayList<>();
    List<JComponent> listaMenuFeature = new ArrayList<>();

    public TelaDashboard(String title) {
        super(title);
        TELA_ANTERIOR = this;
        pnGeral.setLayout(null);
        pnGeral.add(lblSaudacao);
        pnGeral.add(lblTitulo);


        pnCadastrarFuncionario.add(lblFeatureCadastrarFuncionario);
        pnCadastrarFuncionario.addMouseListener(new PainelFeatureListener(TelaCadastroFuncionario.class));

        pnMatricula.add(lblFeatureFazerMatricula);
        pnMatricula.addMouseListener(new PainelFeatureListener(TelaMatricula.class));

        pnRelatorio.add(lblFeatureVerRelatorio);
        pnRelatorio.addMouseListener(new PainelFeatureListener(TelaRelatorioEntradaSaida.class));

        listaMenuFeature.add(pnMatricula);
        listaMenuFeature.add(pnCadastrarFuncionario);
        listaMenuFeature.add(pnRelatorio);
        pnFuncoes.setLayout(new GridLayout(1, listaMenuFeature.size()));
        pnFuncoes.setBounds(100, 120, 600, 300);
        TelasUtil.addItensToTela(pnFuncoes, listaMenuFeature);

        pnGeral.add(pnFuncoes);
        pnGeral.add(pnMenu);
        setContentPane(pnGeral);
        setVisible(true);
    }
}
