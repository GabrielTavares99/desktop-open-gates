package SistemaDesktop.controller;

import SistemaDesktop.controller.dao.DisciplinaDAO;
import SistemaDesktop.model.Disciplina;

public class DisciplinaController {

    private DisciplinaDAO disciplinaDao;

    public DisciplinaController() {
        disciplinaDao = new DisciplinaDAO();
    }

    public Disciplina getBySigla(String sigla) {
        return disciplinaDao.findBySigla(sigla);
    }

}
