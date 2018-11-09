package SistemaDesktop.view.paineis;

import SistemaDesktop.view.labels.LabelDescricaoFuncaoDashborad;
import SistemaDesktop.view.labels.LabelIconeFuncaoDashboard;
import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaMatricula;

import javax.swing.*;

import static SistemaDesktop.config.ViewSettings.COR_PAINEL_FEATURE_ROXA;

public class PainelMatriculaDashboard extends PainelFuncaoDashboard {

    public PainelMatriculaDashboard() {
        super();
        LabelIconeFuncaoDashboard icone = new LabelIconeFuncaoDashboard();
        ImageIcon imageIcon = new ImageIcon(PainelMatriculaDashboard.class.getClassLoader().getResource("image/logo-matricula.png").getPath());
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(64, 64, 100));
        icone.setIcon(imageIcon);
        add(icone);

        add(new LabelDescricaoFuncaoDashborad("MATRICULA"));
        setBackground(COR_PAINEL_FEATURE_ROXA);
        addMouseListener(new PainelFeatureListener(TelaMatricula.class));
    }

}
