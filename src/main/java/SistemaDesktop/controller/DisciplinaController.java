package SistemaDesktop.controller;

import SistemaDesktop.controller.dao.DisciplinaDAO;
import SistemaDesktop.model.Curso;

public class DisciplinaController {

    private DisciplinaDAO disciplinaDao;

    public DisciplinaController() {
        disciplinaDao = new DisciplinaDAO();
    }

    public Curso getBySigla(String sigla) {
        return disciplinaDao.findBySigla(sigla);
    }

}
