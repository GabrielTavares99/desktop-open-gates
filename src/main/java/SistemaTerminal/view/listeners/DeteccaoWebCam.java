package SistemaTerminal.view.listeners;

import SistemaDesktop.controller.dao.AlunoDAO;
import SistemaDesktop.model.Aluno;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.telas.TelaStatusValidacao;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class DeteccaoWebCam {

    private String codigoLido;

    public DeteccaoWebCam(String codigoLido) {
        this.codigoLido = codigoLido;
    }

    public void run() {
        System.out.println("VALIDACAO VALIDACAO VALIDACAO");
        AlunoDAO alunoDao = AlunoDAO.getInstance();
        Aluno byEmail = alunoDao.getByEmail(codigoLido);
        System.out.println(codigoLido);
        Validacao validacao = new Validacao();
        if (byEmail != null) {
            validacao.setImagemBase64(byEmail.getFotoBase64());
            validacao.setPessoa(byEmail);
            validacao.setPermitida(true);
            validacao.setMensagem("ENTRADA PERMITIDA");
        } else
            validacao.setMensagem("ENTRADA NEGADA");

        String uuid = String.valueOf(CriptografiaUtil.generateUUID());
        validacao.setUuidImagem(uuid);
        TelaStatusValidacao telaStatusValidacao = new TelaStatusValidacao(validacao);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            FileUtils.deleteQuietly(new File("/tmp/opengates/" + uuid + ".jpg"));
            telaStatusValidacao.dispose();
        }
    }


}
