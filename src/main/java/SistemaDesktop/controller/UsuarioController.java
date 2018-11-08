package SistemaDesktop.controller;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.dao.UsuarioDao;
import SistemaDesktop.util.CriptografiaUtil;

public class UsuarioController {
    private UsuarioDao usuarioDao;

    public UsuarioController() {
        usuarioDao = new UsuarioDao();
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

    public void alterarSenha(Usuario usuario, String novaSenha) {

        String novaSenhaCriptografada = CriptografiaUtil.gerarMD5(novaSenha);
        usuario.setSenha(novaSenhaCriptografada);
        usuario.setCodigoEmail(null);


    }
}
