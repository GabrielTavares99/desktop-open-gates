package SistemaDesktop.model;

import SistemaDesktop.model.enums.Periodo;

import java.util.Date;

public class CredenciamentoAluno {

    private int id;
    private Aluno aluno;
    private Curso curso;
    private Date dataCredenciamento;
    private Date validoAte;
    private int semestre;
    private Periodo periodo;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getDataCredenciamento() {
        return dataCredenciamento;
    }

    public void setDataCredenciamento(Date dataCredenciamento) {
        this.dataCredenciamento = dataCredenciamento;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getValidoAte() {
        return validoAte;
    }

    public void setValidoAte(Date validoAte) {
        this.validoAte = validoAte;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
