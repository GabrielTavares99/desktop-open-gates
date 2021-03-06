package SistemaDesktop.view.paineis;

import SistemaDesktop.view.labels.LabelDescricaoFuncaoDashborad;
import SistemaDesktop.view.labels.LabelIconeFuncaoDashboard;
import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaRelatorioEntradaSaida;

import javax.swing.*;

public class PainelRelatorioDashboard extends PainelFuncaoDashboard {

    public PainelRelatorioDashboard() {
        super();
        LabelIconeFuncaoDashboard icone = new LabelIconeFuncaoDashboard();
        ImageIcon imageIcon = new ImageIcon(PainelMatriculaDashboard.class.getClassLoader().getResource("image/icone-relatorio.png").getPath());
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(icone.getWidth(), icone.getHeight(), 100));
        icone.setIcon(imageIcon);
        add(icone);
        add(new LabelDescricaoFuncaoDashborad("RELATORIO"));
        addMouseListener(new PainelFeatureListener(TelaRelatorioEntradaSaida.class));
    }

}
