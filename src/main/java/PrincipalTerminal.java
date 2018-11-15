import SistemaTerminal.view.telas.TelaLeituraCarteirinha;

public class PrincipalTerminal {
    public static void main(String[] args) {
        new Thread(() -> new TelaLeituraCarteirinha()).start();
    }
}
