package SistemaDesktop.controller;

import SistemaDesktop.model.Disciplina;
import SistemaDesktop.model.dao.DisciplinaDao;

public class DisciplinaController {

    DisciplinaDao disciplinaDao;

    public DisciplinaController() {
        disciplinaDao = new DisciplinaDao();
    }

    public Disciplina getBySigla(String sigla) {

        return disciplinaDao.findBySigla(sigla);

    }

}
