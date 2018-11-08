package SistemaDesktop.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaUtil {

    public static String gerarMD5(String texto) {
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(texto.getBytes(), 0, texto.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return texto;
    }

}
