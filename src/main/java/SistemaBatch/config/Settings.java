package SistemaBatch.config;

public class Settings {

    public static final String SENHA_EMAIL_SISTEMA = "";
    public static final String EMAIL_SISTEMA = "";
    public static int MINUTO = 1000 * 60;
    public static int HORA = 1000 * 60 * 600;
    public static String SENHA_BD = System.getenv("BD_SENHA");
    public static String QRCODE_SALT = System.getenv("QRCODE_SALT");
    public static String USER_BD = System.getenv("BD_USUARIO");
    public static String NAME_BD = System.getenv("BD_NOME");
    public static String URL_BD = System.getenv("BD_URL");
    public static String STRING_CONEXAO = String.format("jdbc:mariadb://%s:3306/%s", URL_BD, NAME_BD);
}
