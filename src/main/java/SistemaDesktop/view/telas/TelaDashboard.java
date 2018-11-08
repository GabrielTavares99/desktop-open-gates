package SistemaDesktop.view.telas;

import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelSaudacao;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.view.paineis.PainelCadastroFuncionario;
import SistemaDesktop.view.paineis.PainelFuncaoMatricula;
import SistemaDesktop.view.paineis.PainelFuncoesDashboard;
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

    public TelaDashboard() {
        super();
        TelasUtil.TELA_DASHBOARD = this;
        pnGeral.setLayout(null);
        pnGeral.add(lblSaudacao);
        pnGeral.add(lblTitulo);

        NUMERO_FUNCOES = 3;
        PAINEL_FUNCAO_WIDTH = (600 / NUMERO_FUNCOES);

        if (TipoUsuario.SECRETARIA.equals(TelasUtil.USUARIO_LOGADO.getTipoUsuario())) {
            listaMenuFeature.add(new PainelFuncaoMatricula());
            listaMenuFeature.add(new PainelCadastroFuncionario());
        }
        listaMenuFeature.add(new PainelRelatorio());
        pnFuncoesDashboard.setSize(200 * listaMenuFeature.size(), pnFuncoesDashboard.getHeight());
        TelasUtil.centralizar(pnFuncoesDashboard);

        pnFuncoesDashboard.setLayout(new GridLayout(1, NUMERO_FUNCOES));
        TelasUtil.addItensToTela(pnFuncoesDashboard, listaMenuFeature);

        setJMenuBar(new MenuSuperior(tela));
        pnGeral.add(pnFuncoesDashboard);
        setContentPane(pnGeral);
        setVisible(true);
    }
}
