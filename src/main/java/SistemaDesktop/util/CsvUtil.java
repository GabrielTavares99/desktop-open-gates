package SistemaDesktop.util;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvUtil {

    public static List<Map<String, String>> lerCSV(String pathCSV) {
        List<Map<String, String>> lines = new ArrayList<>();
        String arquivoCSV = pathCSV;
        try {
            //csv file containing data
            String strFile = arquivoCSV;
            CSVReader reader = new CSVReader(new FileReader(strFile));
            String[] linha;
            int lineNumber = 0;
            String[] cabecalho = new String[0];
            while ((linha = reader.readNext()) != null) {
                if (lineNumber == 0) {
                    cabecalho = linha;
                    lineNumber++;
                    continue;
                }
                lineNumber++;
                System.out.println("Line # " + lineNumber);
                Map<String, String> value = new HashMap<>();
                for (int i = 0; i < linha.length; i++) {
                    value.put(cabecalho[i], linha[i]);
                }
                lines.add(value);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return lines;
    }

}
