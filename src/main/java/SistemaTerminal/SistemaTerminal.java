package SistemaTerminal;

import SistemaDesktop.model.Aluno;
import SistemaDesktop.model.Pessoa;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.dao.AlunoDao;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaTerminal.model.Validacao;
import SistemaTerminal.view.telas.TelaStatusValidacao;
import SistemaTerminal.view.telas.TelaValidacao;

public class SistemaTerminal {
    public static void main(String[] args) {

        new TelaValidacao();

    }
}
