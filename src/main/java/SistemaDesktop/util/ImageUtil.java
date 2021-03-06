package SistemaDesktop.util;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ImageUtil {

    public static Image getImagemProporcional(String path, int width, int heigth) {
        ImageIcon imageIcon = new ImageIcon(ImageUtil.class.getClassLoader().getResource(path).getPath());
        return imageIcon.getImage().getScaledInstance(width, heigth, 100);
    }

    public static void fromBaseToImage(String base64, String imageName) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        try {
            FileUtils.writeByteArrayToFile(new File(imageName), decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fromImageToBase64(String filePath) {
        byte[] fileContent;
        try {
            fileContent = FileUtils.readFileToByteArray(new File(filePath));
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
