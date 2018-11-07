package SistemaDesktop.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class ZipUtil {
    private static final String OUTPUT_FOLDER = "/tmp";

    public static void unzip(String zip, String dest) {
        String source = zip;
        String destination = dest;
        String password = "password";

        try {
            ZipFile zipFile = new ZipFile(source);
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(password);
            }
            zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();

        }
    }

}



