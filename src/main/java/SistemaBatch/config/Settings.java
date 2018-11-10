package SistemaBatch.config;

public class Settings {

    public static final String SENHA_EMAIL_SISTEMA = "";
    public static final String EMAIL_SISTEMA = "";
    public static int MINUTO = 1000 * 60;
    public static int HORA = 1000 * 60 * 600;
    public static String SENHA_BD = System.getenv("SENHA_BD");
    public static String USER_BD = "root";
    public static String NAME_BD = "opengates";
    public static String URL_BD = "jdbc:mariadb://localhost:3306/" + NAME_BD;
}
