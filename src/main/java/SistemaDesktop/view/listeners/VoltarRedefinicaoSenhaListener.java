package SistemaDesktop.view.listeners;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;
import SistemaDesktop.view.telas.TelaDashboard;
import SistemaDesktop.view.telas.TelaLogin;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VoltarRedefinicaoSenhaListener implements MouseListener {
    private JFrame tela;
    private TipoRedefinicaoSenha tipoRedefinicaoSenha;

    public VoltarRedefinicaoSenhaListener(JFrame tela, TipoRedefinicaoSenha tipoRedefinicaoSenha){
        this.tela = tela;
        this.tipoRedefinicaoSenha = tipoRedefinicaoSenha;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (tipoRedefinicaoSenha.equals(TipoRedefinicaoSenha.REDEFINICAO_CODIGO_EMAIL)){
            new TelaLogin();
        }else {
            new TelaDashboard();
        }
        tela.dispose();
    }
}
