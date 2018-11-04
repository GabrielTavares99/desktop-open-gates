package SistemaDesktop.model;

import java.util.List;

public class Professor extends Usuario {

    private List<Disciplina> disciplinas;
    private String ra;

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
}
