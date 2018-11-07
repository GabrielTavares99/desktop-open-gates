package SistemaTerminal.view.listeners;

import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.dao.AlunoDao;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.telas.TelaStatusValidacao;

public class DeteccaoWebCam {


    public static void consulta(String codigo) {
        AlunoDao alunoDao = new AlunoDao();
        Aluno byEmail = alunoDao.getByEmail(codigo);
        Validacao validacao = new Validacao();
        if (byEmail != null) {
            validacao.setImagemBase64(byEmail.getFotoBase64());
            validacao.setPessoa(byEmail);
            validacao.setEntradaPermitida(true);
            validacao.setMensagem("ENTRADA PERMITIDA");
        } else {
            System.out.println("NEGADA");
            validacao.setMensagem("ENTRADA NEGADA");
        }
        new TelaStatusValidacao(validacao);
    }

}
