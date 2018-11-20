package SistemaDesktop.controller;

import SistemaBatch.controller.EmailController;
import SistemaDesktop.controller.dao.EmailDAO;
import SistemaDesktop.controller.dao.FuncionarioDAO;
import SistemaDesktop.controller.dao.UsuarioDAO;
import SistemaDesktop.model.Cargo;
import SistemaDesktop.model.Email;
import SistemaDesktop.model.Funcionario;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaDesktop.util.ImageUtil;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.telas.TelaCadastroFuncionario;

public class FuncionarioController {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void cadastrar() {
        Funcionario funcionario = criarFuncionario();
        Usuario usuario = criarUsuario(funcionario);
        funcionario.setUsuario(usuario);

        if (TelaCadastroFuncionario.ID_FUNCIONARIO == null) {
            System.out.println("NOVO FUNCIONARIO");
            funcionarioDAO.salvar(funcionario);

            Email emailBoasVindas = EmailController.fazerEmailBoasVindas(funcionario);
            Email emailQRCode = EmailController.fazerEmailQrCode(funcionario, "/tmp/opengates/qrcode/" + usuario.getSenha() + ".jpg");

            EmailDAO emailDAO = new EmailDAO();
            emailDAO.salvar(emailBoasVindas);
            emailDAO.salvar(emailQRCode);
        } else {
            System.out.println("UPDATE DE FUNCIONARIO");
            atualizar();
        }
    }

    public void atualizar(){
        Funcionario funcionario = criarFuncionario();
        Usuario usuario = criarUsuario(funcionario);
        funcionario.setUsuario(usuario);

        if(mudouEmail(usuario))
            salvarEmailAtualizacaoEmail(funcionario);

        funcionarioDAO.update(funcionario);
    }

    private boolean mudouEmail(Usuario userFuncionario){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.getByEmail(userFuncionario.getEmail()) == null)
            return true;
        return false;
    }


    private void salvarEmailAtualizacaoEmail(Funcionario funcionario){
        Email emailAtualizacaoDeEmail = EmailController.fazerEmailAtualizacaoEmail(funcionario);
        EmailDAO emailDAO = new EmailDAO();
        emailDAO.salvar(emailAtualizacaoDeEmail);
    }

    private Funcionario criarFuncionario(){
        String nome = TelaCadastroFuncionario.txtNome.getText();
        Cargo cargo = (Cargo) TelaCadastroFuncionario.comboBoxCargo.getSelectedItem();
        String fotoBase64 = ImageUtil.fromImageToBase64(TelasUtil.URL_FOTO_FUNCIONARIO);

        Funcionario funcionario = new Funcionario();

        funcionario.setCargo(cargo);
        funcionario.setNome(nome);
        funcionario.setFotoBase64(fotoBase64);
        funcionario.setId(TelaCadastroFuncionario.ID_FUNCIONARIO);

        return funcionario;
    }

    private Usuario criarUsuario(Funcionario funcionario){
        Usuario usuario = new Usuario();

        String nome = TelaCadastroFuncionario.txtNome.getText();
        String cpf = TelaCadastroFuncionario.txtCPF.getText().replace(".", "").replace("-", "");
        String email = TelaCadastroFuncionario.txtEmail.getText();
        boolean isAtivo = TelaCadastroFuncionario.rdAtivo.isSelected();
        Cargo cargo = (Cargo) TelaCadastroFuncionario.comboBoxCargo.getSelectedItem();
        String fotoBase64 = ImageUtil.fromImageToBase64(TelasUtil.URL_FOTO_FUNCIONARIO);
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

        return usuario;
    }
}
