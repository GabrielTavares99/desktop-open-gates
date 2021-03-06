package SistemaDesktop.model;

public class Cargo {

    private int id;
    private String descricao;

    public Cargo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Cargo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
