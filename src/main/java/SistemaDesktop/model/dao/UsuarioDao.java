package SistemaDesktop.model.dao;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.CriptografiaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsuarioDao implements IDao {

    private static List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void cadastrar(Object o) {
        Usuario usuario = (Usuario) o;
        if (usuario.getSenha() == null)
            usuario.setSenha(String.valueOf(System.currentTimeMillis()));
        String s = CriptografiaUtil.gerarMD5(usuario.getSenha());
        usuario.setSenha(s);
        Random random = new Random();
        String codigo = String.valueOf(random.nextInt()).substring(0, 5);
        usuario.setCodigoEmail(codigo);
        System.out.println("CODIGO EMAIL " + usuario.getCodigoEmail());
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
