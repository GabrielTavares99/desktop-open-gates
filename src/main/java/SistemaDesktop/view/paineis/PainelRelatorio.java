package SistemaDesktop.view.paineis;

import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaRelatorioEntradaSaida;

public class PainelRelatorio extends PainelFeature {
    public PainelRelatorio() {
        addMouseListener(new PainelFeatureListener(TelaRelatorioEntradaSaida.class));

    }

}
