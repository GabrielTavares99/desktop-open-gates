package SistemaDesktop.view.telas;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.botoes.BotaoSubmissao;
import SistemaDesktop.view.camposTexto.CampoSenhaFormulario;
import SistemaDesktop.view.camposTexto.CampoTextoFormulario;
import SistemaDesktop.view.labels.LabelEsqueciSenha;
import SistemaDesktop.view.labels.LabelFormulario;
import SistemaDesktop.view.paineis.PainelFormularioLogin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.Constantes.*;
import static SistemaDesktop.config.ViewSettings.MEIO_TELA_X;

public class TelaLogin extends TelaCustom {

    public static JTextField txtUsername = new CampoTextoFormulario();
    public static JTextField txtPassword = new CampoSenhaFormulario();

    JLabel lblUsername = new LabelFormulario(USERNAME);
    JLabel lblPassword = new LabelFormulario(PASSWORD);

    JButton btnEnviar = new BotaoSubmissao(this, ENTRAR);

    List<JComponent> itensFormularioLogin = new ArrayList<>();

    private JLabel lblOpenGates;
    private JPanel pnFormularioLogin = new PainelFormularioLogin();
    private JLabel lblEsqueciSenha = new LabelEsqueciSenha(this, ESQUECI_SENHA);

    public TelaLogin() {
        super();

        itensFormularioLogin.add(lblUsername);
        itensFormularioLogin.add(txtUsername);
        itensFormularioLogin.add(lblPassword);
        itensFormularioLogin.add(txtPassword);
        itensFormularioLogin.add(lblEsqueciSenha);
        itensFormularioLogin.add(btnEnviar);

        pnFormularioLogin.setLayout(new GridLayout(itensFormularioLogin.size(), 1));
        TelasUtil.addItensToTela(pnFormularioLogin, itensFormularioLogin);

        ImageIcon img = new ImageIcon(tela.getClass().getClassLoader().getResource("image/open-gate-com-texto.png").getPath());


        img.setImage(img.getImage().getScaledInstance(128, 140, 100));
        lblOpenGates = new JLabel(img);
        lblOpenGates.setBounds(MEIO_TELA_X - 64, 30, 128, 140);
        add(lblOpenGates);

        add(pnFormularioLogin);
        setVisible(true);
    }

}
