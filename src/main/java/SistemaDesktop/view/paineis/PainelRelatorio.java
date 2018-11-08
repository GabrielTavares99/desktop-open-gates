package SistemaDesktop.view.paineis;

import SistemaDesktop.view.labels.LabelDescricaoFuncaoDashborad;
import SistemaDesktop.view.labels.LabelIconeFuncaoDashboard;
import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaRelatorioEntradaSaida;

public class PainelRelatorio extends PainelFuncaoDashboard {

    public PainelRelatorio() {
        super();
        add(new LabelIconeFuncaoDashboard(getClass().getResource("../").getPath() + "images/open-gates-logo.png"));
        add(new LabelDescricaoFuncaoDashborad("RELATORIO"));

        addMouseListener(new PainelFeatureListener(TelaRelatorioEntradaSaida.class));
    }

}
