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

    JLabel lbl_saudacao = new LabelSaudacao("BOA ???");
    JLabel lbl_titulo = new LabelTitulo("DASHBOARD");
    JLabel lbl_sair = new LabelMenu("LOG OUT");
    JLabel lbl_trocar_senha = new LabelMenu("PASSWORD");
    JLabel lbl_feature_fazer_matricula = new LabelMenu("FAZER MATRICULA");
    JLabel lbl_feature_cadastrar_funcionario = new LabelMenu("CADASTRAR FUNCIOPNARIO");
    JLabel lbl_feature_ver_relatorio = new LabelMenu("VER RELATORIO");

    JPanel pn_geral = new JPanel();
    JPanel pn_funcoes = new JPanel();
    JPanel pn_menu = new PainelMenu();

    JPanel pn_matricula = new PainelMatricula();
    JPanel pn_cadastrar_funcionario = new PainelCadastroFuncionario();
    JPanel pn_relatorio = new PainelRelatorio();

    List<JComponent> lista_menu = new ArrayList<>();
    List<JComponent> lista_menu_feature = new ArrayList<>();

    public TelaDashboard(String title) {
        super(title);
        TELA_ANTERIOR = this;
        pn_geral.setLayout(null);
        pn_geral.add(lbl_saudacao);
        pn_geral.add(lbl_titulo);

        pn_menu.setLayout(new GridLayout(2, 1));
        lista_menu.add(lbl_sair);
        lista_menu.add(lbl_trocar_senha);
        TelasUtil.addItensToTela(pn_menu, lista_menu);

        pn_cadastrar_funcionario.add(lbl_feature_cadastrar_funcionario);
        pn_cadastrar_funcionario.addMouseListener(new PainelFeatureListener(TelaCadastroFuncionario.class));

        pn_matricula.add(lbl_feature_fazer_matricula);
        pn_matricula.addMouseListener(new PainelFeatureListener(TelaMatricula.class));

        pn_relatorio.add(lbl_feature_ver_relatorio);
        pn_relatorio.addMouseListener(new PainelFeatureListener(TelaRelatorioEntradaSaida.class));

        lista_menu_feature.add(pn_matricula);
        lista_menu_feature.add(pn_cadastrar_funcionario);
        lista_menu_feature.add(pn_relatorio);
        pn_funcoes.setLayout(new GridLayout(1, lista_menu_feature.size()));
        pn_funcoes.setBounds(100, 120, 600, 300);
        TelasUtil.addItensToTela(pn_funcoes, lista_menu_feature);

        pn_geral.add(pn_funcoes);
        pn_geral.add(pn_menu);
        setContentPane(pn_geral);
        setVisible(true);
    }
}
