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
        lblFoto = new JLabel();
        lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        lblFoto.setBackground(Color.WHITE);
        lblFoto.setOpaque(true);
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);

        if (validacao.getImagemBase64() != null) {
            ImageUtil.fromBaseToImage(validacao.getImagemBase64(), "/tmp/abaa.jpg");
            lblFoto.setIcon(new ImageIcon("/tmp/abaa.jpg"));
        } else {
            ImageIcon imageIcon = new ImageIcon(PainelValidacao.class.getClassLoader().getResource("image/logo-x.png").getPath());
            lblFoto.setIcon(imageIcon);
        }

        lblMensagem = new JLabel(validacao.getMensagem());

        if (validacao.getPessoa() != null)
            lblNome = new JLabel(validacao.getPessoa().getNome());
        else
            lblNome = new JLabel("");
        lblFoto.setBounds(MEIO_TELA_X - 150, 50, 300, 400);
        lblFoto.setOpaque(true);
        lblFoto.setBackground(Color.WHITE);
        lblMensagem.setBounds(0, 460, tela.getWidth(), 60);
        lblMensagem.setFont(new Font("Sarif", Font.BOLD, 30));
        lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
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
