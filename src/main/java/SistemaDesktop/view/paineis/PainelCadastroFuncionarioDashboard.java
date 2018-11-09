package SistemaDesktop.view.paineis;

import SistemaDesktop.view.labels.LabelDescricaoFuncaoDashborad;
import SistemaDesktop.view.labels.LabelIconeFuncaoDashboard;
import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaCadastroFuncionario;

import javax.swing.*;

import static SistemaDesktop.config.ViewSettings.COR_PAINEL_FEATURE_VERDE;


public class PainelCadastroFuncionarioDashboard extends PainelFuncaoDashboard {

    public PainelCadastroFuncionarioDashboard() {
        super();
        LabelIconeFuncaoDashboard icone = new LabelIconeFuncaoDashboard();
        ImageIcon imageIcon = new ImageIcon(PainelMatriculaDashboard.class.getClassLoader().getResource("image/icone-funcionario.png").getPath());
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(64, 64, 100));
        icone.setIcon(imageIcon);
        add(icone);
        add(new LabelDescricaoFuncaoDashborad("CADASTRAR FUNCIONARIO"));
        setBackground(COR_PAINEL_FEATURE_VERDE);
        addMouseListener(new PainelFeatureListener(TelaCadastroFuncionario.class));
    }

}
