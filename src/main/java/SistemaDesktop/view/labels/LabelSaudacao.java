package SistemaDesktop.view.labels;

import java.util.Date;

import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_WIDTH;

public class LabelSaudacao extends LabelCustom {
    public LabelSaudacao(String nome) {
        super();
        String saudacao;
        int hours = new Date().getHours();
        if (hours >= 18 && hours < 6)
            saudacao = "Boa Noite, %s";
        else if (hours >= 6 && hours < 12)
            saudacao = "Bom Dia, %s";
        else
            saudacao = "Boa Tarde, %s";
        setText(String.format(saudacao, nome));
        setBounds(TELA_DEFAULT_WIDTH-200,0,200,30);
    }
}
