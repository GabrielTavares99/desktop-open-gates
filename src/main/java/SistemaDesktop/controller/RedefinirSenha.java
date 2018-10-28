package SistemaDesktop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static SistemaDesktop.config.Settings.PAGINAS_HTML;

public class RedefinirSenha implements Tarefa {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        return PAGINAS_HTML + "index.jsp";
    }
}
