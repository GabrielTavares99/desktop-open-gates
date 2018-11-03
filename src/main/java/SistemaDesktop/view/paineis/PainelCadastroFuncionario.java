package SistemaDesktop.view.paineis;

import SistemaDesktop.view.labels.LabelDescricaoFuncaoDashborad;
import SistemaDesktop.view.labels.LabelIconeFuncaoDashboard;
import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaCadastroFuncionario;

public class PainelCadastroFuncionario extends PainelFuncaoDashboard {

    public PainelCadastroFuncionario() {
        super();
        add(new LabelIconeFuncaoDashboard(getClass().getResource("../").getPath() + "images/open-gates-logo.png"));
        add(new LabelDescricaoFuncaoDashborad("CADASTRAR FUNCIONARIO"));
        addMouseListener(new PainelFeatureListener(TelaCadastroFuncionario.class));
    }

}
