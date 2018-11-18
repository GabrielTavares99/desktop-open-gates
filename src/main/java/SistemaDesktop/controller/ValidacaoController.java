package SistemaDesktop.controller;

import SistemaDesktop.controller.dao.ValidacaoDAO;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.util.DataUtil;
import SistemaTerminal.model.Validacao;

import java.util.Date;
import java.util.List;

public class ValidacaoController {

    ValidacaoDAO validacaoDAO = new ValidacaoDAO();

    public List<Validacao> pegarValidacoes(String termoBusca, String usuario, Date dtInicio, Date dtFinal) {
        List<Validacao> validacaos;
        // TODO: 18/11/18 ARRUMAR QUESTÃO DE HORAS NO BETWEEN
        dtFinal = DataUtil.addDays(dtFinal, 1);
        if (usuario == null) {
            validacaos = validacaoDAO.getValidacoes(dtInicio, dtFinal);
        } else {
            validacaos = validacaoDAO.getValidacoesByTipoUsuario(usuario, dtInicio, dtFinal);
        }

        return validacaos;
    }

    public List<Validacao> pegarValidacoesIndividuais(Usuario usuario, Date dtInicio, Date dtFinal) {
        // TODO: 18/11/18 ARRUMAR QUESTÃO DE HORAS NO BETWEEN
        dtFinal = DataUtil.addDays(dtFinal, 1);
        List<Validacao> validacoes = validacaoDAO.getValidacoesIndividuais(usuario, dtInicio, dtFinal);
        return validacoes;
    }
}
