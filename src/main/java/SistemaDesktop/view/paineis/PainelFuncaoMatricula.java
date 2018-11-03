package SistemaDesktop.view.paineis;

import SistemaDesktop.view.labels.LabelDescricaoFuncaoDashborad;
import SistemaDesktop.view.labels.LabelIconeFuncaoDashboard;
import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaFuncaoMatricula;

public class PainelFuncaoMatricula extends PainelFuncaoDashboard {

    public PainelFuncaoMatricula() {
        super();
        add(new LabelIconeFuncaoDashboard(getClass().getResource("../").getPath() + "images/open-gates-logo.png"));
        add(new LabelDescricaoFuncaoDashborad("MATRICULA"));

        addMouseListener(new PainelFeatureListener(TelaFuncaoMatricula.class));
    }

}
