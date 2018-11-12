package SistemaDesktop.model.enums;

public enum MensagemValidacao {
    ACESSO_LIBERADO("ACESSO LIBERADO"),
    ACESSO_NEGADO("ACESSO NEGADO"),
    ACESSO_EXPIRADO("ACESSO EXPIRADO");

    private String s;

    MensagemValidacao(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
