package SistemaTerminal.view.telas;

import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.paineis.PainelCustom;
import SistemaTerminal.model.Validacao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.ViewSettings.MEIO_TELA_X;

public class PainelValidacao extends PainelCustom {

    JLabel lblFoto;
    JLabel lblNome;
    JLabel lblMensagem;
    List<JComponent> components= new ArrayList<>();
    public PainelValidacao(JFrame tela, Validacao validacao) {
        setBounds(0, 0, tela.getWidth(), tela.getHeight());
        setLayout(null);

        lblFoto = new JLabel(validacao.getImagemBase64());
        lblMensagem = new JLabel(validacao.getMensagem());
        lblNome = new JLabel(validacao.getPessoa().getNome());

        lblFoto.setBounds(MEIO_TELA_X-150, 50,300,400);
        lblFoto.setOpaque(true);
        lblFoto.setBackground(Color.WHITE);
        lblMensagem.setBounds(MEIO_TELA_X-150,460,400,60);
        lblNome.setBounds(50, 530, 400,30);

        if (validacao.isEntradaPermitida())
            setBackground(Color.green);
        else
            setBackground(Color.RED);

        components.add(lblNome);
        components.add(lblFoto);
        components.add(lblMensagem);
        TelasUtil.addItensToTela(this,components);
    }


}