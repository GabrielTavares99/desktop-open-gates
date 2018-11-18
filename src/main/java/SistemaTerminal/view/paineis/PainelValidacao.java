package SistemaTerminal.view.paineis;

import SistemaDesktop.util.ImageUtil;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.labels.LabelInformacao;
import SistemaDesktop.view.paineis.PainelCustom;
import SistemaTerminal.model.Validacao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.ViewSettings.*;

public class PainelValidacao extends PainelCustom {

    JLabel lblFoto = new LabelInformacao();
    JLabel lblNome = new LabelInformacao();
    JLabel lblCpf = new LabelInformacao();
    JLabel lblTipoUsuário = new LabelInformacao();
    JLabel lblMensagem;
    List<JComponent> components = new ArrayList<>();
    JPanel pnInformacoes = new JPanel();
    private ImageIcon imageIcon;

    public PainelValidacao(JFrame tela, Validacao validacao) {
        setBounds(0, 0, tela.getWidth(), tela.getHeight());
        setLayout(null);

        if (validacao.getPessoa() != null) {
            pnInformacoes.setLayout(new GridLayout(3, 0, 5, 5));
            pnInformacoes.setBackground(new Color(0, 0, 0, 50));
            pnInformacoes.setBounds(15, 20, 200, 120);

            lblNome.setText(validacao.getPessoa().getNome());
            lblNome.setBounds(50, 530, 400, 30);

            lblCpf.setText(validacao.getPessoa().getUsuario().getCpf());

            lblTipoUsuário.setText(validacao.getPessoa().getUsuario().getTipoUsuario().toString());
            lblTipoUsuário.setBounds(50, 550, 400, 30);

            pnInformacoes.add(lblNome);
            pnInformacoes.add(lblTipoUsuário);
            pnInformacoes.add(lblCpf);
            components.add(pnInformacoes);
        }

        lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        lblFoto.setBounds(MEIO_TELA_X - 175, 20, 350, 450);

        lblMensagem = new JLabel(validacao.getMensagem());
        lblMensagem.setBounds(0, 470, tela.getWidth(), 60);
        lblMensagem.setFont(new Font("Sarif", Font.BOLD, 30));
        lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);

        String imagePath;
        if (validacao.getImagemBase64() != null) {
            imagePath = String.format("/tmp/opengates/%s.jpg", validacao.getUuidImagem());
            ImageUtil.fromBaseToImage(validacao.getImagemBase64(), imagePath);
        } else {
            imagePath = PainelValidacao.class.getClassLoader().getResource("image/logo-x.png").getPath();
        }
        imageIcon = new ImageIcon(imagePath);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
        lblFoto.setIcon(imageIcon);
        lblFoto.setBackground(Color.WHITE);
        lblFoto.setOpaque(true);

        if (validacao.isPermitida())
            setBackground(COR_VERDE_SUCESSO);
        else
            setBackground(COR_VERMELHA_ATENCAO);

        components.add(lblFoto);
        components.add(lblMensagem);
        TelasUtil.addItensToTela(this, components);
    }


}
