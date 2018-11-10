package SistemaTerminal.view.telas;

import SistemaDesktop.view.telas.TelaCustom;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.paineis.PainelValidacao;

public class TelaStatusValidacao extends TelaCustom {

    public TelaStatusValidacao(Validacao validacao, String uuid) {
        setLayout(null);
        PainelValidacao painelValidacao = new PainelValidacao(this, validacao, uuid);
        add(painelValidacao);
        setVisible(true);
    }


}
