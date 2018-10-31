package SistemaDesktop.view.paineis;

import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaCadastroFuncionario;

public class PainelCadastroFuncionario extends PainelFeature {

    public PainelCadastroFuncionario() {
        addMouseListener(new PainelFeatureListener(TelaCadastroFuncionario.class));
    }

}
