package SistemaTerminal.view.telas;

import SistemaDesktop.view.telas.TelaCustom;
import SistemaTerminal.model.Validacao;

public class TelaStatusValidacao extends TelaCustom {

    public TelaStatusValidacao(Validacao validacao, String uuid) {
        setLayout(null);
        PainelValidacao painelValidacao = new PainelValidacao(this, validacao, uuid);
        add(painelValidacao);
        setVisible(true);
    }


}
