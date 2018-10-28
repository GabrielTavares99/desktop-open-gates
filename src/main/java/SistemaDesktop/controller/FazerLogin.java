package SistemaDesktop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static SistemaDesktop.config.Settings.PAGINAS_HTML;

public class FazerLogin implements Tarefa {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        if (!email.equalsIgnoreCase("user")) {
            request.setAttribute("mensagemLogin", "CREDENCIAIS INVÁLIDAS");
            return "/?badCredentials=true";
        }
        return (PAGINAS_HTML + "dashboard.jsp");
    }
}
