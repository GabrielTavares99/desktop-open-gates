package SistemaDesktop.view.paineis;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.botoes.BotaoRedefinicaoSenha;
import SistemaDesktop.view.camposTexto.CampoSenhaFormulario;
import SistemaDesktop.view.camposTexto.CampoTextoFormulario;
import SistemaDesktop.view.labels.LabelFormulario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.ViewSettings.MEIO_TELA_X;

public class PainelFormularioRedefinicaoSenha extends PainelCustom {

    CampoSenhaFormulario txtSenhaAtual = new CampoSenhaFormulario();
    CampoSenhaFormulario txtSenhaNova = new CampoSenhaFormulario();
    CampoSenhaFormulario txtConfirmacaoSenhaNova = new CampoSenhaFormulario();
    JTextField txtCodigoEmail = new CampoTextoFormulario();
    LabelFormulario lblSenhaAtual = new LabelFormulario("SENHA ATUAL");
    LabelFormulario lblCodigoEmail = new LabelFormulario("CODIGO EMAIL");
    LabelFormulario lblSenhaNova = new LabelFormulario("NOVA SENHA");
    LabelFormulario lblConfirmacaoSenhaNova = new LabelFormulario("CONFIRMACAO NOVA SENHA");
    BotaoRedefinicaoSenha btnRedefinicaoSenha = new BotaoRedefinicaoSenha();
    List<JComponent> itens = new ArrayList<>();

    public PainelFormularioRedefinicaoSenha(TipoRedefinicaoSenha tipoRedefinicaoSenha) {
        int width = 400;
        setOpaque(true);
        setBackground(new Color(20, 100, 68, 100));
        setBounds(MEIO_TELA_X - (width / 2), 200, width, 300);

        if (tipoRedefinicaoSenha.equals(TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL)){
            itens.add(lblCodigoEmail);
            itens.add(txtCodigoEmail);
        }else {
            itens.add(lblSenhaAtual);
            itens.add(txtSenhaAtual);
        }

        itens.add(lblSenhaNova);
        itens.add(txtSenhaNova);
        itens.add(lblConfirmacaoSenhaNova);
        itens.add(txtConfirmacaoSenhaNova);
        itens.add(btnRedefinicaoSenha);

        setLayout(new GridLayout(itens.size(), 1));
        TelasUtil.addItensToTela(this, itens);
    }

}
