package SistemaDesktop.view.labels;

import SistemaDesktop.util.TelasUtil;

import java.util.Date;

import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_WIDTH;

public class LabelSaudacao extends LabelCustom {
    public LabelSaudacao(String nome) {
        super();
        String saudacao;
        int hours = new Date().getHours();
        if (hours >= 0 && hours < 6)
            saudacao = "Boa Madrugada, %s";
        else if (hours >= 6 && hours < 12)
            saudacao = "Bom Dia, %s";
        else if (hours >= 12 && hours < 18)
            saudacao = "Boa Tarde, %s";
        else
            saudacao = "Boa Noite, %s";
        saudacao = String.format(saudacao, TelasUtil.USUARIO_LOGADO.getNome());
        setText(String.format(saudacao, nome));
        setBounds(TELA_DEFAULT_WIDTH-200,0,200,30);
    }
}
