package commoms.config;

public class Settings {

    public static final String EMAIL_SISTEMA = System.getenv("EMAIL_SISTEMA_SENHA");
    public static final String SENHA_EMAIL_SISTEMA = System.getenv("EMAIL_SISTEMA");
    public static final int MINUTO = 1000 * 60;
    public static final String SENHA_BD = System.getenv("BD_SENHA");
    public static final String QRCODE_SALT = System.getenv("QRCODE_SALT");
    public static final String USER_BD = System.getenv("BD_USUARIO");
    public static final String NAME_BD = System.getenv("BD_NOME");
    public static final String URL_BD = System.getenv("BD_URL");
    public static final String STRING_CONEXAO = String.format("jdbc:mariadb://%s:3306/%s", URL_BD, NAME_BD);
}
