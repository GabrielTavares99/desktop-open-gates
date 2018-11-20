package SistemaDesktop.view.labels;

import SistemaDesktop.controller.dao.AlunoDAO;
import SistemaDesktop.controller.dao.FuncionarioDAO;
import SistemaDesktop.model.Pessoa;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.TelasUtil;

import java.util.Date;

import static commoms.config.ViewSettings.TELA_DEFAULT_WIDTH;

public class LabelSaudacao extends LabelCustom {
    public LabelSaudacao(String nome) {
        super();
        String saudacao;
        int hours = new Date().getHours();
        if (hours >= 0 && hours < 6)
            saudacao = "Boa Madrugada, %s";
        else if (hours >= 6 && hours < 12)
            saudacao = "Bom Dia, %s";
        else if (hours >= 12 && hours < 18)
            saudacao = "Boa Tarde, %s";
        else
            saudacao = "Boa Noite, %s";
        Usuario usuario = TelasUtil.USUARIO_LOGADO;
        Pessoa pessoa = new Pessoa();
        if (TipoUsuario.FUNCIONARIO.equals(usuario)) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            pessoa = funcionarioDAO.findByEmail(usuario.getEmail());
        } else if (TipoUsuario.ALUNO.equals(usuario.getTipoUsuario())) {
            AlunoDAO alunoDao = AlunoDAO.getInstance();
            pessoa = alunoDao.getByEmail(usuario.getEmail());
        } else {
            // TODO: 08/11/18 ARRUMAR ISSO - BUSCAR PELO PERFIL SECRETARIA - AINDA NÃO TEM NADA
            AlunoDAO alunoDao = AlunoDAO.getInstance();
            pessoa.setNome("TÁ-NULO");
            TelasUtil.USUARIO_LOGADO.setPessoa(pessoa);
        }
        saudacao = String.format(saudacao, pessoa.getNome().split(" ")[0]);
        setText(String.format(saudacao, nome));
        setBounds(TELA_DEFAULT_WIDTH - 200, 0, 200, 30);
    }
}
