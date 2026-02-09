package DbManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DbManager {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String USUARIO = dotenv.get("DB_USER");
    private static final String PASS = dotenv.get("DB_PASS");
    private static final String URL = dotenv.get("DB_URL");
    private static Connection conexion;

    public static void main(String[] args) {


        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASS);
            System.out.println("Conexion exitosa");
            conexion.close();
            System.out.println("Cerrada correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
