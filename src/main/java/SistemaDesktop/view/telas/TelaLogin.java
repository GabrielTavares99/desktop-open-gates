package SistemaDesktop.view.telas;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.botoes.BotaoSubmissao;
import SistemaDesktop.view.labels.LabelEsqueciSenha;
import SistemaDesktop.view.labels.LabelFormulario;
import SistemaDesktop.view.labels.LabelLogoLogin;
import SistemaDesktop.view.paineis.PainelFormularioLogin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.Constantes.*;

public class TelaLogin extends TelaCustom {

    JTextField txtUsername = new JTextField();
    JTextField txtPassword = new JTextField();
    JLabel lblUsername = new LabelFormulario(USERNAME);
    JLabel lblPassword = new LabelFormulario(PASSWORD);
    JButton btnEnviar = new BotaoSubmissao(this, ENTRAR);
    List<JComponent> itensFormularioLogin = new ArrayList<>();
    private JLabel lblOpenGates = new LabelLogoLogin(OPEN_GATES);
    private JPanel pnGeral = new JPanel();
    private JPanel pnFormularioLogin = new PainelFormularioLogin();
    private JLabel lblEsqueciSenha = new LabelEsqueciSenha(this, ESQUECI_SENHA);

    public TelaLogin(String title) {

        super(title);
        pnGeral.setLayout(null);
        pnGeral.add(lblOpenGates);

        itensFormularioLogin.add(lblUsername);
        itensFormularioLogin.add(txtUsername);
        itensFormularioLogin.add(lblEsqueciSenha);
        itensFormularioLogin.add(lblPassword);
        itensFormularioLogin.add(txtPassword);
        itensFormularioLogin.add(btnEnviar);

        pnFormularioLogin.setLayout(new GridLayout(itensFormularioLogin.size(), 1));
        TelasUtil.addItensToTela(pnFormularioLogin, itensFormularioLogin);

        pnGeral.add(pnFormularioLogin);
        setContentPane(pnGeral);
        setVisible(true);
    }

}
