package SistemaDesktop.model;

import java.util.List;

public class Professor extends Pessoa {

    private List<Disciplina> disciplinas;
    private String numMatricula;



    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }
}
