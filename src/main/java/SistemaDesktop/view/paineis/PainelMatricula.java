package SistemaDesktop.view.paineis;

import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaMatricula;

public class PainelMatricula extends PainelFeature {


    public PainelMatricula() {
        addMouseListener(new PainelFeatureListener(TelaMatricula.class));
    }

}
