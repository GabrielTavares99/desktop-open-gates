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
import SistemaDesktop.util.ImageUtil;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.telas.TelaCadastroFuncionario;

import static SistemaDesktop.view.telas.TelaCadastroFuncionario.limparCampos;

public class FuncionarioController {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void cadastrar() {

        String nome = TelaCadastroFuncionario.txtNome.getText();
        String cpf = TelaCadastroFuncionario.txtCPF.getText().replace(".", "").replace("-", "");
        String email = TelaCadastroFuncionario.txtEmail.getText();
        boolean isAtivo = TelaCadastroFuncionario.rdAtivo.isSelected();
        Cargo cargo = (Cargo) TelaCadastroFuncionario.comboBoxCargo.getSelectedItem();
        String fotoBase64 = ImageUtil.fromImageToBase64(TelasUtil.URL_FOTO_FUNCIONARIO);

        Usuario usuario = new Usuario();
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(cargo);
        funcionario.setNome(nome);
        funcionario.setFotoBase64(fotoBase64);
        funcionario.setId(TelaCadastroFuncionario.ID_FUNCIONARIO);

        String uuid = CriptografiaUtil.generateUUID();
        usuario.setCodigoEmail(uuid.substring(0, 5));
        usuario.setId(TelaCadastroFuncionario.ID_USUARIO);
        usuario.setPessoa(funcionario);
        if (cargo.getDescricao().equalsIgnoreCase("secretaria"))
            usuario.setTipoUsuario(TipoUsuario.SECRETARIA);
        else
            usuario.setTipoUsuario(TipoUsuario.FUNCIONARIO);
        usuario.setCpf(cpf);
        usuario.setSenha(uuid);
        usuario.setEmail(email);
        usuario.setAcessaSistema(true);
        usuario.setAtivo(isAtivo);
        funcionario.setUsuario(usuario);

        if (TelaCadastroFuncionario.ID_FUNCIONARIO == null) {
            System.out.println("NOVO FUNCIONARIO");
            funcionarioDAO.salvar(funcionario);
            Email email1 = EmailController.fazerEmailBoasVindas(funcionario);
            Email email2 = EmailController.fazerEmailQrCode(funcionario, "/tmp/opengates/qrcode/" + uuid + ".jpg");
            EmailDAO emailDAO = new EmailDAO();
            emailDAO.salvar(email1);
            emailDAO.salvar(email2);
        } else {
            System.out.println("UPDATE DE FUNCIONARIO");
            funcionarioDAO.update(funcionario);
        }
    }


}
