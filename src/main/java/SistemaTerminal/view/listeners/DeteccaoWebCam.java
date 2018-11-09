package SistemaTerminal.view.listeners;

import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.dao.AlunoDao;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.telas.TelaStatusValidacao;

public class DeteccaoWebCam extends Thread {

    private String codigoLido;

    public DeteccaoWebCam(String codigoLido) {
        this.codigoLido = codigoLido;
    }

    @Override
    public void run() {
        AlunoDao alunoDao = new AlunoDao();
        Aluno byEmail = alunoDao.getByEmail(codigoLido);
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
        TelaStatusValidacao telaStatusValidacao = new TelaStatusValidacao(validacao);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            telaStatusValidacao.dispose();
        }
    }


}
