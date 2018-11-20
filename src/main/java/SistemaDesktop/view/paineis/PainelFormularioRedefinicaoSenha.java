package SistemaDesktop.view.paineis;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.botoes.BotaoRedefinicaoSenha;
import SistemaDesktop.view.camposTexto.CampoSenhaFormulario;
import SistemaDesktop.view.camposTexto.CampoTextoFormulario;
import SistemaDesktop.view.labels.LabelFormulario;
import SistemaDesktop.view.listeners.AlterarSenhaListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static commoms.config.ViewSettings.MEIO_TELA_X;
import static commoms.config.ViewSettings.VERMELHO_PADRAO;

public class PainelFormularioRedefinicaoSenha extends PainelCustom {

    public static CampoSenhaFormulario txtSenhaAtual = new CampoSenhaFormulario();
    public static CampoSenhaFormulario txtSenhaNova = new CampoSenhaFormulario();
    public static CampoSenhaFormulario txtConfirmacaoSenhaNova = new CampoSenhaFormulario();
    public static JTextField txtCodigoEmail = new CampoTextoFormulario();

    LabelFormulario lblSenhaAtual = new LabelFormulario("SENHA ATUAL");
    LabelFormulario lblCodigoEmail = new LabelFormulario("CODIGO EMAIL");
    LabelFormulario lblSenhaNova = new LabelFormulario("NOVA SENHA");
    LabelFormulario lblConfirmacaoSenhaNova = new LabelFormulario("CONFIRMACAO NOVA SENHA");

    BotaoRedefinicaoSenha btnRedefinicaoSenha = new BotaoRedefinicaoSenha();
    List<JComponent> itens = new ArrayList<>();

    public PainelFormularioRedefinicaoSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha, Usuario usuario) {
        int width = 400;
        setOpaque(true);
        setBackground(VERMELHO_PADRAO);
        setBounds(MEIO_TELA_X - (width / 2), 150, width, 300);

        if (tipoRedefinicaoSenha.equals(TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL)) {
            itens.add(lblCodigoEmail);
            itens.add(txtCodigoEmail);
        } else {
            itens.add(lblSenhaAtual);
            itens.add(txtSenhaAtual);
        }

        itens.add(lblSenhaNova);
        itens.add(txtSenhaNova);
        itens.add(lblConfirmacaoSenhaNova);
        itens.add(txtConfirmacaoSenhaNova);
        itens.add(btnRedefinicaoSenha);

        btnRedefinicaoSenha.addActionListener(new AlterarSenhaListener(usuario, tipoRedefinicaoSenha, this));

        setLayout(new GridLayout(itens.size(), 1, 2, 4));
        setBorder(new EmptyBorder(5, 3, 5, 3));
        TelasUtil.addItensToTela(this, itens);
    }

}
