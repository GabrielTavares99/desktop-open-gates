package SistemaDesktop.view.telas;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelMenu;
import SistemaDesktop.view.labels.LabelSaudacao;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.paineis.PainelCadastroFuncionario;
import SistemaDesktop.view.paineis.PainelMatricula;
import SistemaDesktop.view.paineis.PainelMenu;
import SistemaDesktop.view.paineis.PainelRelatorio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.Constantes.*;

public class TelaDashboard extends TelaCustom {

    JLabel lblSaudacao = new LabelSaudacao("BOA ???");
    JLabel lblTitulo = new LabelTitulo(DASHBOARD);
    JLabel lblSair = new LabelMenu("LOG OUT");
    JLabel lblTrocarSenha = new LabelMenu(PASSWORD);
    JLabel lblFeatureFazerMatricula = new LabelMenu("FAZER MATRICULA");
    JLabel lblFeatureCadastrarFuncionario = new LabelMenu("CADASTRAR FUNCIONARIO");
    JLabel lblFeatureVerRelatorio = new LabelMenu(VER_RELATORIO);

    JPanel pnGeral = new JPanel();
    JPanel pnFuncoes = new JPanel();
    JPanel pnMenu = new PainelMenu();

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

        pnGeral.add(pnFuncoes);
        pnGeral.add(pnMenu);
        setContentPane(pnGeral);
        setVisible(true);
    }
}
