package SistemaDesktop.controller;

import SistemaDesktop.controller.dao.EmailDAO;
import SistemaDesktop.controller.dao.UsuarioDAO;
import SistemaDesktop.model.Email;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaDesktop.util.FileUtil;

import java.io.File;

public class UsuarioController {
    private UsuarioDAO usuarioDao = new UsuarioDAO();

    public UsuarioController() {
    }

    public boolean podeLogar(String email, String senha) {
        Usuario usuario = usuarioDao.getByEmail(email);
        if (usuario == null || !usuario.isSenhasIguais(senha))
            return false;
        return true;
    }

    public Usuario findByEmail(String email) {
        return usuarioDao.getByEmail(email);
    }

    public Usuario alterarSenha(Usuario usuario, String novaSenha) {
        String novaSenhaCriptografada = CriptografiaUtil.gerarMD5(novaSenha);
        usuario.setSenha(novaSenhaCriptografada);
        usuario.setCodigoEmail(null);
        usuario = (Usuario) usuarioDao.update(usuario);
        return usuario;
    }

    private Email fazerEmailEsqueciSenha(Usuario usuario) {
        Email email = new Email();
        email.setAssunto("Redefinição de Senha");
        email.setDestinatario(usuario.getEmail());
        File file = FileUtil.getFileFromResource("html/esqueci-senha.html");
        String htmlEmTexto = FileUtil.fileToText(file.getAbsolutePath());
        String novoCodigoEmail = CriptografiaUtil.generateUUID().substring(0, 5);
        usuario.setCodigoEmail(novoCodigoEmail);
        htmlEmTexto = String.format(htmlEmTexto, novoCodigoEmail);
        email.setHmtl(htmlEmTexto);
        return email;
    }

    public void enviarCodigoEsqueciSenha(Usuario usuario) {

        Email emailEsqueciSenha = fazerEmailEsqueciSenha(usuario);
        EmailDAO emailDAO = new EmailDAO();
        emailDAO.salvar(emailEsqueciSenha);
        usuarioDao.update(usuario);

    }
}
