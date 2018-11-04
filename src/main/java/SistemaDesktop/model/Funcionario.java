package SistemaDesktop.model;

import java.util.List;

public class Funcionario extends Usuario {

    private Cargo cargo;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
