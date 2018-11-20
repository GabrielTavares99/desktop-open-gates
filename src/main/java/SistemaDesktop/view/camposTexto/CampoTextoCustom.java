package SistemaDesktop.view.camposTexto;

import javax.swing.*;

import static commoms.config.ViewSettings.CAMPO_TEXTO_DEFAULT_HEIGHT;
import static commoms.config.ViewSettings.CAMPO_TEXTO_DEFAULT_WIDTH;

public class CampoTextoCustom extends JTextField {

    public CampoTextoCustom() {
        setSize(CAMPO_TEXTO_DEFAULT_WIDTH, CAMPO_TEXTO_DEFAULT_HEIGHT);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

}
