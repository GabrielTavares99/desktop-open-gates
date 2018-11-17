package SistemaDesktop.model;

public class Aluno extends Pessoa {

    private int ra;

    public Aluno() {
        setUsuario(new Usuario());
    }

    public int getRa() {
        return ra;
    }

    //alteração
    public void setRa(int ra) {
        this.ra = ra;
    }
}
