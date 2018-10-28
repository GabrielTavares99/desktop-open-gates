package SistemaDesktop.controller;

import SistemaDesktop.util.ControllerUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/redefinicao-senha")
public class RedefinicaoSenhaController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pagina = ControllerUtil.getPagina(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
        requestDispatcher.forward(req, resp);
    }
}
