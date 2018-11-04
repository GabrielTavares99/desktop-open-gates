package SistemaDesktop.view.labels;

import SistemaDesktop.model.Pessoa;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.model.dao.AlunoDao;
import SistemaDesktop.model.dao.ProfessorDao;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.TelasUtil;

import java.util.Date;

import static SistemaDesktop.config.ViewSettings.TELA_DEFAULT_WIDTH;

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
        Pessoa pessoa = null;
        if (TipoUsuario.FUNCIONARIO.equals(usuario)) {
            ProfessorDao professorDao = new ProfessorDao();
            pessoa = professorDao.findByEmail(usuario.getEmail());
        } else if (TipoUsuario.ALUNO.equals(usuario.getTipoUsuario())) {
            AlunoDao alunoDao = new AlunoDao();
            pessoa = alunoDao.getByEmail(usuario.getEmail());
        }
        saudacao = String.format(saudacao, pessoa.getNome());
        setText(String.format(saudacao, nome));
        setBounds(TELA_DEFAULT_WIDTH - 200, 0, 200, 30);
    }
}
