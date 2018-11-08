package SistemaTerminal.view.telas;

import SistemaDesktop.util.ImageUtil;
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
    List<JComponent> components = new ArrayList<>();

    public PainelValidacao(JFrame tela, Validacao validacao) {
        setBounds(0, 0, tela.getWidth(), tela.getHeight());
        setLayout(null);

        if (validacao.getImagemBase64() != null) {
            ImageUtil.fromBaseToImage(validacao.getImagemBase64(), "/tmp/abaa.jpg");
            lblFoto = new JLabel(new ImageIcon("/tmp/abaa.jpg"));
        } else {
            lblFoto = new JLabel("X");
            lblFoto.setBackground(Color.WHITE);
        }

        lblMensagem = new JLabel(validacao.getMensagem());
        if (validacao.getPessoa() != null)
            lblNome = new JLabel(validacao.getPessoa().getNome());
        else
            lblNome = new JLabel("");
        lblFoto.setBounds(MEIO_TELA_X - 150, 50, 300, 400);
        lblFoto.setOpaque(true);
        lblFoto.setBackground(Color.WHITE);
        lblMensagem.setBounds(MEIO_TELA_X - 150, 460, 400, 60);
        lblNome.setBounds(50, 530, 400, 30);

        if (validacao.isEntradaPermitida())
            setBackground(Color.green);
        else
            setBackground(Color.RED);

        components.add(lblNome);
        components.add(lblFoto);
        components.add(lblMensagem);
        TelasUtil.addItensToTela(this, components);
    }


}
