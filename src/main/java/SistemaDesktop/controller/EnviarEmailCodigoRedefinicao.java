package SistemaDesktop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static SistemaDesktop.config.Settings.PAGINAS_HTML;

public class EnviarEmailCodigoRedefinicao implements Tarefa {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ENVIOU CODIGO EMAIL");
        request.getSession().setAttribute("enviou", true);
        return PAGINAS_HTML + "form-envio-email-redefinicao.jsp";

    }
}
