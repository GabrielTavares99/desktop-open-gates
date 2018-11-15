package SistemaDesktop.controller;

import SistemaDesktop.controller.dao.ValidacaoDAO;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaTerminal.model.Validacao;

import java.util.Date;
import java.util.List;

public class ValidacaoController {

    ValidacaoDAO validacaoDAO = new ValidacaoDAO();

    public List<Validacao> pegarValidacoes(String termoBusca, TipoUsuario usuario, Date dtInicio, Date dtFinal) {
        if (usuario == null) {
            return validacaoDAO.getValidacoes(dtInicio, dtFinal);
        } else {
            return validacaoDAO.getValidacoesByTipoUsuario(usuario, dtInicio, dtFinal);
        }
    }

}
