package SistemaDesktop.view.listeners;

import SistemaDesktop.model.enums.TipoRedefinicaoSenha;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VoltarRedefinicaoSenhaListener implements MouseListener {
    private TipoRedefinicaoSenha tipoRedefinicaoSenha;

    public VoltarRedefinicaoSenhaListener(TipoRedefinicaoSenha tipoRedefinicaoSenha){
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

        }else {

        }
    }
}
