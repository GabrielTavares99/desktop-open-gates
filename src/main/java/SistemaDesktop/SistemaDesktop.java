package SistemaDesktop;

import SistemaDesktop.view.telas.TelaLogin;

import static SistemaDesktop.config.Constantes.TITULO_TELA_LOGIN;

public class SistemaDesktop {
    public static void main(String[] args) {
        new TelaLogin(TITULO_TELA_LOGIN);
    }
}
