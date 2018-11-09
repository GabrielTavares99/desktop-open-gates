```import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
private static String password = "";
private static String user = "root";
private static String url = "jdbc:mariadb://localhost:3306/bicicletario";

public static void main(String[] args) throws SQLException {
Statement statement;
Connection connection = null;
try {
Class.forName("org.mariadb.jdbc.Driver");
System.out.println("Classes MariaDB UP");
connection = DriverManager.getConnection(url, user, password);
System.out.println("Banco de Dados UP");
statement = connection.createStatement();
String sql = "INSERT INTO locacao(nome_cliente,modelo,data,preco)"
+ "VALUES ('Weverson', 'CROIZINHA','2018-03-14',15.0)";
int i = statement.executeUpdate(sql);
System.out.println("QTD LINHAS INSERIDAS "+i);
sql = "SELECT * FROM locacao";
ResultSet result= statement.executeQuery(sql);
while (result.next()) {
System.out.printf("Cliente %s %s\n", result.getString("nome_cliente"),result.getString("modelo"));
}
} catch (ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
}
finally {
connection.close();
}

}
}

```


prepareted stetament