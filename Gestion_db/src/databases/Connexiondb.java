package databases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexiondb {
    public static Connection connect() {
        String url = Configdb.get("db.url");
        String user = Configdb.get("db.user");
        String password = Configdb.get("db.password");
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données !");
            System.out.println("URL : " + url);
            System.out.println("Utilisateur : " + user);
            e.printStackTrace();
            return null;
        }
    }
}
