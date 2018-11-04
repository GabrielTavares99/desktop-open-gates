package SistemaDesktop.model.dao;

import SistemaDesktop.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements IDao {

    List<Usuario> usuarios = new ArrayList<>();

    public UsuarioDao() {
        Usuario usuario = new Usuario();
        usuario.setEmail("dev@");
        usuario.setSenha("123");
        usuario.setNome("Gabriel");
        usuarios.add(usuario);
    }

    @Override
    public void cadastrar(Object usuario) {
    }

    @Override
    public void listarTudo(Object o) {

    }

    public Usuario getByEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email))
                return usuario;
        }
        return null;
    }
}
