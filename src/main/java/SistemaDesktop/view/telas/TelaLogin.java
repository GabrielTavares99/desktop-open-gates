package SistemaDesktop.view.telas;
//TESTE GIT

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.botoes.BotaoSubmissao;
import SistemaDesktop.view.labels.LabelEsqueciSenha;
import SistemaDesktop.view.labels.LabelFormulario;
import SistemaDesktop.view.labels.LabelLogoLogin;
import SistemaDesktop.view.listeners.FazerLoginListener;
import SistemaDesktop.view.paineis.PainelFormularioLogin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaLogin extends TelaCustom {

    JTextField txtUsername, txtpassword;
    JLabel lblUsername = new LabelFormulario("USERNAME");
    JLabel lblPassword = new LabelFormulario("Password");
    JButton btnEnviar;
    List<JComponent> itensFormularioLogin = new ArrayList<>();
    private JLabel lblOpenGates = new LabelLogoLogin("OPEN GATES");
    private JPanel pnGeral = new JPanel();
    private JPanel pnFormularioLogin;
    private JLabel lblEsqueciSenha = new LabelEsqueciSenha(this, "Esqueci Senha");

    public TelaLogin(String title) {

        super(title);
        pnGeral.setLayout(null);

        pnGeral.add(lblOpenGates);

        pnFormularioLogin = new PainelFormularioLogin();
        pnFormularioLogin.setBounds(200, 60, 400, 400);

        itensFormularioLogin.add(lblUsername);

        txtUsername = new JTextField();
        itensFormularioLogin.add(txtUsername);

        itensFormularioLogin.add(lblEsqueciSenha);

        itensFormularioLogin.add(lblPassword);

        txtpassword = new JTextField();
        itensFormularioLogin.add(txtpassword);

        btnEnviar = new BotaoSubmissao("SUBMETER");
        btnEnviar.addActionListener(new FazerLoginListener(this));
        itensFormularioLogin.add(btnEnviar);

        pnFormularioLogin.setLayout(new GridLayout(itensFormularioLogin.size(), 1));
        TelasUtil.addItensToTela(pnFormularioLogin, itensFormularioLogin);

        pnGeral.add(pnFormularioLogin);
        setContentPane(pnGeral);
        setVisible(true);
    }

}
