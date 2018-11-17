package SistemaDesktop.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

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

    public static String generateUUID() {
        // Creating a random UUID (Universally unique identifier).
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

//        System.out.println("Random UUID String = " + randomUUIDString);
//        System.out.println("UUID version       = " + uuid.version());
//        System.out.println("UUID variant       = " + uuid.variant());
        return randomUUIDString;
    }

    public static String decrypt(String encstr, String salt) {
        byte[] decodedBytes = Base64.getDecoder().decode(encstr);
        encstr = new String(decodedBytes);
        encstr = encstr.replace(salt, "").replace(new StringBuilder(salt).reverse().toString(), "");
        return encstr;
    }

    public static String encriptarBase64(String str, String salt) {
        String format = String.format("%s%s%s", salt, str, new StringBuilder(salt).reverse().toString());
        return Base64.getEncoder().encodeToString(format.getBytes());
    }

}
