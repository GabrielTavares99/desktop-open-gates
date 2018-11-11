package SistemaTerminal.view.telas;

import SistemaDesktop.view.telas.TelaCustom;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.paineis.PainelValidacao;

public class TelaStatusValidacao extends TelaCustom {

    public TelaStatusValidacao(Validacao validacao) {
        setLayout(null);
        PainelValidacao painelValidacao = new PainelValidacao(this, validacao);
        add(painelValidacao);
        setVisible(true);
    }


}
