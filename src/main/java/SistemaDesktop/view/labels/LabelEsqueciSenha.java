package SistemaDesktop.view.labels;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.view.listeners.RedefinicaoSenhaListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LabelEsqueciSenha extends LabelCustom {


    public LabelEsqueciSenha(JFrame frame, String descricao) {
        super(descricao);
        setText("<html><u>" + getText() + "</ul></html>");
        addMouseListener(new RedefinicaoSenhaListener(frame, TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL));

        setForeground(new Color(255, 255, 255, 180));
        setBorder(new EmptyBorder(0, 6, 0, 0));//top,left,bottom,right
    }


}
