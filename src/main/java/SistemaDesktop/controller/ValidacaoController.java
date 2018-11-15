package SistemaDesktop.controller;

import SistemaDesktop.controller.dao.ValidacaoDAO;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaTerminal.model.Validacao;

import java.util.Date;
import java.util.List;

public class ValidacaoController {

    ValidacaoDAO validacaoDAO = new ValidacaoDAO();

    public List<Validacao> pegarValidacoes(String termoBusca, TipoUsuario usuario, Date dtInicio, Date dtFinal) {
        List<Validacao> validacaos;
        if (usuario == null) {
            validacaos = validacaoDAO.getValidacoes(dtInicio, dtFinal);
        } else {
            validacaos = validacaoDAO.getValidacoesByTipoUsuario(usuario, dtInicio, dtFinal);
        }

        return validacaos;
    }

    public List<Validacao> pegarValidacoesIndividuais(Usuario usuario, Date date, Date date1) {
        List<Validacao> validacoes = validacaoDAO.getValidacoesIndividuais(usuario, date, date1);
        return validacoes;
    }
}
