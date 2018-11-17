package SistemaDesktop.util;

import SistemaDesktop.controller.MatriculaController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    public static String fileToText(String caminhoArquivo) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(caminhoArquivo));
            return new String(bytes, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File getFileFromResource(String caminhoArquivo) {
        URL resource = MatriculaController.class.getClassLoader().getResource(caminhoArquivo);
        return new File(resource.getPath());
    }

    public static String getNomeArquivoFromPath(String path){
        return new File(path).getName();
    }


}
