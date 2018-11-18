package SistemaDesktop.view.listeners;

import SistemaDesktop.controller.FuncionarioController;
import SistemaDesktop.controller.modelosTabela.ModeloTabelaCadastroFuncionario;
import SistemaDesktop.view.telas.TelaCadastroFuncionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static SistemaDesktop.view.telas.TelaCadastroFuncionario.limparCampos;

public class CadastrarFuncionarioListener implements ActionListener {

    private ModeloTabelaCadastroFuncionario modeloTabelaCadastroFuncionario;

    public CadastrarFuncionarioListener(ModeloTabelaCadastroFuncionario modeloTabelaCadastroFuncionario) {
        this.modeloTabelaCadastroFuncionario = modeloTabelaCadastroFuncionario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FuncionarioController funcionarioController = new FuncionarioController();
        funcionarioController.cadastrar();
        if (TelaCadastroFuncionario.ID_FUNCIONARIO == null) {
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário Atualizado com sucesso!");
        }
        modeloTabelaCadastroFuncionario.atualizar();
        limparCampos();

    }
}
