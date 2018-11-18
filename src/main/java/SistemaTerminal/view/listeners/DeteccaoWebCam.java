package SistemaTerminal.view.listeners;

import SistemaDesktop.controller.dao.AlunoDAO;
import SistemaDesktop.controller.dao.FuncionarioDAO;
import SistemaDesktop.controller.dao.UsuarioDAO;
import SistemaDesktop.controller.dao.ValidacaoDAO;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.AcaoPortaria;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.telas.TelaStatusValidacao;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Date;

import static SistemaBatch.config.Settings.QRCODE_SALT;

public class DeteccaoWebCam {

    private String codigoLido;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private ValidacaoDAO validacaoDAO = new ValidacaoDAO();

    public DeteccaoWebCam(String codigoLido) {
        this.codigoLido = codigoLido;
    }

    public void run() {
        Validacao validacao = new Validacao();

        Usuario usuario = null;
        validacao.setData(new Date());

        codigoLido = CriptografiaUtil.decrypt(codigoLido, QRCODE_SALT);
        if (codigoLido != null)
            usuario = usuarioDAO.getByEmail(codigoLido);

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
                default:
                    usuario.setPessoa(new FuncionarioDAO().findByEmail(usuario.getEmail()));
                    break;
            }
            validacao.setImagemBase64(usuario.getPessoa().getFotoBase64());
            validacao.setPessoa(usuario.getPessoa());

            AcaoPortaria ultimaAcaoPortaria = validacaoDAO.getUltimaAcaoByUsuarioId(usuario.getId());
            validacao.setAcaoPortaria(AcaoPortaria.ENTRADA);
            if (AcaoPortaria.ENTRADA.equals(ultimaAcaoPortaria))
                validacao.setAcaoPortaria(AcaoPortaria.SAIDA);
            else if (AcaoPortaria.SAIDA.equals(ultimaAcaoPortaria))
                validacao.setAcaoPortaria(AcaoPortaria.ENTRADA);
        }

        validacaoDAO.salvar(validacao);
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
