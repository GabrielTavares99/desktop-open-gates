package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.CriptografiaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsuarioDAO implements IDao {

    private static List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void salvar(Object o) {
        Usuario usuario = (Usuario) o;
        if (usuario.getSenha() == null)
            usuario.setSenha(String.valueOf(System.currentTimeMillis()));
        String s = CriptografiaUtil.gerarMD5(usuario.getSenha());
        usuario.setSenha(s);
        Random random = new Random();
        int r = random.nextInt();
        String codigo = String.valueOf(r * r).substring(0, 5);
        usuario.setCodigoEmail(codigo);
        System.out.println("CODIGO EMAIL " + usuario.getCodigoEmail());
        usuarios.add(usuario);
    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }

    public Usuario getByEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email))
                return usuario;
        }
        return null;
    }

}
