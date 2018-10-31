package SistemaDesktop.view.telas;

import javax.swing.*;

public class TelaEnvioCodigoRedefinicaoSenha {


    public TelaEnvioCodigoRedefinicaoSenha() {
        String emailRecuperacao = JOptionPane.showInputDialog(null, "Preencha com seu email para receber seu código de segurança", "Recuperar Senha", JOptionPane.QUESTION_MESSAGE);
    }
}