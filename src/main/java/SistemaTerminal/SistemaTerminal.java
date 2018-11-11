package SistemaTerminal;

import SistemaDesktop.controller.dao.AlunoDAO;
import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.view.telas.TelaLogin;
import SistemaDesktop.view.telas.TelaRelatorioEntradaSaida;
import SistemaTerminal.view.telas.TelaLeituraCarteirinha;

public class SistemaTerminal {
    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        aluno.setUsuario(new Usuario());
        aluno.getUsuario().setSenha(("123"));
        aluno.setNome("SUPER ADM");
        aluno.getUsuario().setEmail("adm");
        aluno.getUsuario().setTipoUsuario(TipoUsuario.SECRETARIA);
        AlunoDAO.getInstance().salvar(aluno);
        new Thread(() -> new TelaLogin()).start();
        new Thread(() -> new TelaLeituraCarteirinha()).start();
//        try {
//            List<String> emails = new ArrayList<>();
//            Email email = new Email();
//            email.setAssunto("Ummm é tardinha - OPEN GATES & VC");
//            email.setHmtl("<h1>PORTOES ABERTOS PARA VOCÊ TOMAR AQUELE LANCHINHO DA TARDE...</h1>");
//            email.setDestinatarios(emails);
//            new EmailController().sendEmailComAnexo(email);
//        } catch (EmailException e) {
//            e.printStackTrace();
//        }
    }
}
