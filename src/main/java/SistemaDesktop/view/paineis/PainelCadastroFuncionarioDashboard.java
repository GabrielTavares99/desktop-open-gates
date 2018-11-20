package SistemaDesktop.view.paineis;

import SistemaDesktop.view.labels.LabelDescricaoFuncaoDashborad;
import SistemaDesktop.view.labels.LabelIconeFuncaoDashboard;
import SistemaDesktop.view.listeners.PainelFeatureListener;
import SistemaDesktop.view.telas.TelaCadastroFuncionario;

import javax.swing.*;


public class PainelCadastroFuncionarioDashboard extends PainelFuncaoDashboard {

    public PainelCadastroFuncionarioDashboard() {
        super();
        LabelIconeFuncaoDashboard icone = new LabelIconeFuncaoDashboard();
        ImageIcon imageIcon = new ImageIcon(PainelMatriculaDashboard.class.getClassLoader().getResource("image/icone-funcionario.png").getPath());
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(icone.getWidth(), icone.getHeight(), 100));
        icone.setIcon(imageIcon);
        add(icone);
        add(new LabelDescricaoFuncaoDashborad("CADASTRAR FUNCIONÁRIO"));
        addMouseListener(new PainelFeatureListener(TelaCadastroFuncionario.class));
    }

}
