package SistemaDesktop.controller;

import SistemaDesktop.controller.dao.UsuarioDAO;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.CriptografiaUtil;

public class UsuarioController {
    private UsuarioDAO usuarioDao;

    public UsuarioController() {
        usuarioDao = new UsuarioDAO();
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
}
