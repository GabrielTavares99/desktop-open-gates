package SistemaDesktop.util;

import SistemaDesktop.controller.Tarefa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static SistemaDesktop.config.Settings.PAGINAS_HTML;

public class ControllerUtil {

    public static String getPagina(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String tarefa = req.getParameter("tarefa");
        if (tarefa == null)
            return PAGINAS_HTML + req.getParameter("service")+".jsp";

        String nomeClasse = "SistemaDesktop.controller." + tarefa;

        try {
            Class type = Class.forName(nomeClasse);
            Tarefa instancia = (Tarefa) type.newInstance();
            return instancia.executa(req, resp);
        } catch (Exception e) {
            throw new ServletException();
        }
    }

}
