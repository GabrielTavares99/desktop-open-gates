package SistemaDesktop.model.dao;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.CriptografiaUtil;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements IDao {

    private static List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void cadastrar(Object o) {
        Usuario usuario = (Usuario) o;
        if (usuario.getSenha() == null)
            usuario.setSenha(String.valueOf(System.currentTimeMillis()));
        String s = CriptografiaUtil.gerarMD5(usuario.getSenha());
        usuario.setSenha(s);
        usuarios.add(usuario);
    }

    @Override
    public void pegarTodas(Object o) {

    }

    public Usuario getByEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email))
                return usuario;
        }
        return null;
    }

}
