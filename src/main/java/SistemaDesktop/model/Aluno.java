package SistemaDesktop.model;

public class Aluno extends Pessoa {

    public Aluno(){
        setUsuario(new Usuario());
    }

    private int ra;

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
}
