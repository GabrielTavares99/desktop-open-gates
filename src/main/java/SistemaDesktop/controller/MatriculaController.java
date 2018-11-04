package SistemaDesktop.controller;

import SistemaDesktop.model.*;
import SistemaDesktop.model.dao.AlunoDao;
import SistemaDesktop.model.dao.DisciplinaDao;
import SistemaDesktop.model.dao.ProfessorDao;
import SistemaDesktop.model.dao.UsuarioDao;
import SistemaDesktop.model.enums.Periodo;
import SistemaDesktop.model.enums.TipoUsuario;
import SistemaDesktop.util.CsvUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MatriculaController {

    DisciplinaDao disciplinaDao;
    UsuarioDao usuarioDao;
    AlunoDao alunoDao;
    ProfessorDao professorDao;
    MatriculaDao matriculaDao;

    public MatriculaController() {
        disciplinaDao = new DisciplinaDao();
        usuarioDao = new UsuarioDao();
        alunoDao = new AlunoDao();
        professorDao = new ProfessorDao();
        matriculaDao = new MatriculaDao();
    }

    public void fazerMatricula(String csvPath) {
        List<Matricula> matriculas = new ArrayList<>();
        List<Map<String, String>> lines = CsvUtil.lerCSV(csvPath);
        for (Map<String, String> line : lines) {
            System.out.println(line);
            Matricula matricula = new Matricula();

            String sigla = line.get("sigla_disciplina");
            Disciplina disciplina = disciplinaDao.findBySigla(sigla);
            matricula.setDisciplina(disciplina);

            String ra_aluno = line.get("ra_aluno");
            Aluno aluno = alunoDao.getByRa(Integer.parseInt(ra_aluno));
            if (aluno == null){
                Aluno aluno1 = new Aluno();
                aluno1.setRa(Integer.parseInt(ra_aluno));
                aluno1.getUsuario().setEmail(line.get("e-mail"));
                aluno1.getUsuario().setTipoUsuario(TipoUsuario.ALUNO);
                aluno1.setNome(line.get("nome_aluno"));
                alunoDao.cadastrar(aluno1);
            }
            matricula.setAluno(aluno);

            String matricula_professor = line.get("matricula_professor");
            Professor professor = professorDao.findByMatricula(matricula_professor);
            matricula.setProfessor(professor);

            matricula.setSemestre(Integer.parseInt(line.get("semestre")));

            matricula.setAno(Integer.parseInt(line.get("ano")));

            matricula.setPeriodo(Periodo.valueOf(line.get("periodo")));

            matricula.setDataRealizacao(new Date());

            matriculaDao.cadastrar(matricula);
        }


    }

}
