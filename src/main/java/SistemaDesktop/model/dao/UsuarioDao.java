package SistemaDesktop.model.dao;

import SistemaDesktop.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements IDao {

    private static List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void cadastrar(Object usuario) {
        // TODO: 04/11/18 REMOVER ISSO
        Usuario usuario2 = (Usuario) usuario;
        usuario2.setSenha(String.valueOf(123));
//        ----------------------------------

        usuarios.add((Usuario) usuario2);
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
