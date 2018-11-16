package SistemaDesktop.controller;

import SistemaBatch.controller.EmailController;
import SistemaDesktop.controller.dao.EmailDAO;
import SistemaDesktop.controller.dao.FuncionarioDAO;
import SistemaDesktop.model.Cargo;
import SistemaDesktop.model.Email;
import SistemaDesktop.model.Funcionario;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaDesktop.view.telas.TelaCadastroFuncionario;

public class FuncionarioController {

    public void cadastrar() {

        String nome = TelaCadastroFuncionario.txtNome.getText();
        String cpf = TelaCadastroFuncionario.txtCPF.getText();
        String email = TelaCadastroFuncionario.txtEmail.getText();
        boolean isAtivo = TelaCadastroFuncionario.rdAtivo.isSelected();
        Cargo cargo = (Cargo) TelaCadastroFuncionario.comboBoxCargo.getSelectedItem();
        // TODO: 16/11/18 FOTO BASE64 FUNCIONÁRIO

        Usuario usuario = new Usuario();
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(cargo);
        funcionario.setNome(nome);
//        funcionario.setFotoBase64();

        String uuid = CriptografiaUtil.generateUUID();
        usuario.setCodigoEmail(uuid.substring(0, 5));
        usuario.setPessoa(funcionario);
        usuario.setTipoUsuario(TipoUsuario.FUNCIONARIO);
        usuario.setCpf(cpf);
        usuario.setSenha(uuid);
        usuario.setEmail(email);
        usuario.setAcessaSistema(true);
        usuario.setAtivo(isAtivo);
        funcionario.setUsuario(usuario);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.salvar(funcionario);

        String path;
        Email email1 = EmailController.fazerEmailBoasVindas(funcionario);
        Email email2 = EmailController.fazerEmailQrCode(funcionario, "/tmp/opengates/" + uuid + ".jpg");
        EmailDAO emailDAO = new EmailDAO();
        emailDAO.salvar(email1);
        emailDAO.salvar(email2);
    }


}
