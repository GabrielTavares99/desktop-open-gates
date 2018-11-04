package SistemaDesktop.controller;

import SistemaDesktop.model.Matricula;
import SistemaDesktop.util.CsvUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatriculaController {


    public void fazerMatricula(String csvPath) {
        List<Matricula> matriculas = new ArrayList<>();
        List<Map<String, String>> lines = CsvUtil.lerCSV(csvPath);
        for (Map<String, String> line : lines) {
            System.out.println(line);
            Matricula matricula = new Matricula();

        }

    }


}
