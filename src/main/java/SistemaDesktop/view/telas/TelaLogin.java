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

    JTextField txt_username, txt_password;
    JLabel lbl_username, lbl_password;
    JButton btn_enviar;
    List<JComponent> itens_formulario_login = new ArrayList<>();
    private JLabel lblOpenGates = new LabelLogoLogin("OPEN GATES");
    private JPanel pn_geral = new JPanel();
    private JPanel pn_formulario_login;
    private JLabel lbl_esqueci_senha = new LabelEsqueciSenha(this, "Esqueci Senha");

    public TelaLogin(String title) {
        super(title);
        pn_geral.setLayout(null);

//        LOGO
        pn_geral.add(lblOpenGates);

//        FORMULÁRIO CADASTRO
        pn_formulario_login = new PainelFormularioLogin();
        pn_formulario_login.setBounds(200, 60, 400, 400);

        lbl_username = new LabelFormulario("USERNAME");
        itens_formulario_login.add(lbl_username);

        txt_username = new JTextField();
        itens_formulario_login.add(txt_username);

        itens_formulario_login.add(lbl_esqueci_senha);

        lbl_password = new LabelFormulario("SENHA");
        itens_formulario_login.add(lbl_password);

        txt_password = new JTextField();
        itens_formulario_login.add(txt_password);

        btn_enviar = new BotaoSubmissao("SUBMETER");
        btn_enviar.addActionListener(new FazerLoginListener(this));
        itens_formulario_login.add(btn_enviar);

        pn_formulario_login.setLayout(new GridLayout(itens_formulario_login.size(), 1));
        TelasUtil.addItensToTela(pn_formulario_login, itens_formulario_login);

        pn_geral.add(pn_formulario_login);
        setContentPane(pn_geral);
        setVisible(true);
    }

}
