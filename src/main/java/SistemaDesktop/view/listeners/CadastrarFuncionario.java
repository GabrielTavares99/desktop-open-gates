package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.FuncionarioController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarFuncionario implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        FuncionarioController funcionarioController = new FuncionarioController();
        funcionarioController.cadastrar();
    }
}
