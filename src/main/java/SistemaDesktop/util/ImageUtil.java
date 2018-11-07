package SistemaDesktop.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ImageUtil {


    public void fromBaseToImage(String base64, String imageName) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        try {
            FileUtils.writeByteArrayToFile(new File(imageName), decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
