package SistemaDesktop.model;

public class Funcionario extends Pessoa {

    private Cargo cargo;
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
