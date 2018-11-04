package SistemaDesktop.controller;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.dao.UsuarioDao;

public class UsuarioController {
    private UsuarioDao usuarioDao;
    public UsuarioController(){
        usuarioDao = new UsuarioDao();
    }

    public boolean podeLogar(String email, String senha){
        Usuario byEmail = usuarioDao.getByEmail(email);
        if (byEmail == null || !senha.equals(byEmail.getSenha()))
            return false;
        return true;
    }

    public Usuario findByEmail(String email){
        return usuarioDao.getByEmail(email);
    }


}
