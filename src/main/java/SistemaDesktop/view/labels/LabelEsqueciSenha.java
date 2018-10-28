package SistemaDesktop.view.labels;

import SistemaDesktop.view.listeners.RedefinicaoSenhaListener;

import javax.swing.*;

public class LabelEsqueciSenha extends LabelCustom {


    public LabelEsqueciSenha(JFrame frame, String descricao) {
        super(descricao);
        addMouseListener(new RedefinicaoSenhaListener(frame));
    }


}
