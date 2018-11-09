package SistemaTerminal.view.listeners;

import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.dao.AlunoDao;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.telas.TelaStatusValidacao;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Random;

public class DeteccaoWebCam extends Thread {

    private String codigoLido;

    public DeteccaoWebCam(String codigoLido) {
        this.codigoLido = codigoLido;
    }

    @Override
    public void run() {
        AlunoDao alunoDao = AlunoDao.getInstance();
        Aluno byEmail = alunoDao.getByEmail(codigoLido);
        System.out.println(codigoLido);
        Validacao validacao = new Validacao();
        if (byEmail != null) {
            validacao.setImagemBase64(byEmail.getFotoBase64());
            validacao.setPessoa(byEmail);
            validacao.setEntradaPermitida(true);
            validacao.setMensagem("ENTRADA PERMITIDA");
        } else
            validacao.setMensagem("ENTRADA NEGADA");

        Random random = new Random();
        String uuid = String.valueOf(random.nextInt() + System.currentTimeMillis());
        TelaStatusValidacao telaStatusValidacao = new TelaStatusValidacao(validacao, uuid);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            FileUtils.deleteQuietly(new File("/tmp/"+uuid+".jpg"));
            telaStatusValidacao.dispose();
        }
    }


}
