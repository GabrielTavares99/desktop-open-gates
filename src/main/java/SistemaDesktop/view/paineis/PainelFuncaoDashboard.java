package SistemaDesktop.view.paineis;

import java.awt.*;
import java.util.Random;

public class PainelFuncaoDashboard extends PainelCustom {
    Random random = new Random();

    public PainelFuncaoDashboard() {
        setOpaque(true);
        setBackground(new Color(random.nextInt(243 + 1), random.nextInt(243 + 1), random.nextInt(243 + 1)));
        setLayout(null);
    }

}
