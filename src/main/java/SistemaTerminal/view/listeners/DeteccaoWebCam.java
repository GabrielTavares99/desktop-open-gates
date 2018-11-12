package SistemaTerminal.view.listeners;

import SistemaDesktop.controller.dao.AlunoDAO;
import SistemaDesktop.controller.dao.UsuarioDAO;
import SistemaDesktop.controller.dao.ValidacaoDAO;
import SistemaDesktop.model.Funcionario;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.AcaoPortaria;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.telas.TelaStatusValidacao;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Date;

public class DeteccaoWebCam {

    private String codigoLido;

    public DeteccaoWebCam(String codigoLido) {
        this.codigoLido = codigoLido;
    }

    public void run() {
        System.out.println("VALIDACAO VALIDACAO VALIDACAO");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Validacao validacao = new Validacao();
        Usuario usuario = usuarioDAO.getByEmail(codigoLido);
        validacao.setData(new Date());
        if (usuario == null) {
            validacao.setMensagem("ACESSO NEGADO");
            validacao.setAcaoPortaria(AcaoPortaria.DESCONHECIDO);
            validacao.setPermitida(false);
        } else {
            validacao.setPessoa(usuario.getPessoa());
            validacao.setPermitida(true);
            validacao.setMensagem("ACESSO LIBERADO");
            switch (usuario.getTipoUsuario()) {
                case ALUNO:
                    usuario.setPessoa(new AlunoDAO().getByEmail(usuario.getEmail()));
                    break;
                case FUNCIONARIO:
                    usuario.setPessoa(new Funcionario().getByEmail(usuario.getEmail()));
                    break;
            }
            validacao.setImagemBase64(usuario.getPessoa().getFotoBase64());
            validacao.setPessoa(usuario.getPessoa());

            AcaoPortaria ultimaAcaoPortaria = new ValidacaoDAO().getUltimaAcaoByUsuarioId(usuario.getId());
            validacao.setAcaoPortaria(AcaoPortaria.ENTRADA);
            if (AcaoPortaria.ENTRADA.equals(ultimaAcaoPortaria))
                validacao.setAcaoPortaria(AcaoPortaria.SAIDA);
            else if (AcaoPortaria.SAIDA.equals(ultimaAcaoPortaria))
                validacao.setAcaoPortaria(AcaoPortaria.ENTRADA);

        }

        new ValidacaoDAO().salvar(validacao);
        TelaStatusValidacao telaStatusValidacao = new TelaStatusValidacao(validacao);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            FileUtils.deleteQuietly(new File(String.format("/tmp/opengates/%s.jpg", validacao.getUuidImagem())));
            telaStatusValidacao.dispose();
        }
    }


}
