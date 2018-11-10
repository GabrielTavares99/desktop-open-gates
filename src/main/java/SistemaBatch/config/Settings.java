package SistemaBatch.config;

public class Settings {

    public static final String SENHA_EMAIL_SISTEMA = "";
    public static final String EMAIL_SISTEMA = "";
    public static int MINUTO = 1000 * 60;
    public static int HORA = 1000 * 60 * 600;
    private static String SENHA_BD = "";
    private static String USER_BD = "root";
    private static String NAME_BD = "opengates";
    private static String URL_BD = "jdbc:mariadb://localhost:3306/" + NAME_BD;
}
