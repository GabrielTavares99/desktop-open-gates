package SistemaDesktop.view.paineis;

import SistemaDesktop.view.labels.LabelDescricaoFuncaoDashborad;
import SistemaDesktop.view.labels.LabelIconeFuncaoDashboard;
import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaMatricula;
import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;

public class PainelMatricula extends PainelFuncaoDashboard {

    public PainelMatricula() {
        super();
        add(new LabelIconeFuncaoDashboard(getClass().getResource("../").getPath() + "images/open-gates-logo.png"));
        add(new LabelDescricaoFuncaoDashborad("MATRICULA"));

        addMouseListener(new PainelFeatureListener(TelaMatricula.class));
    }

}
