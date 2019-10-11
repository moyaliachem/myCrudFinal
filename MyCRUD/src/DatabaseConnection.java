import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection myconn;

    public static Connection myConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise", "root", "jiwafu07");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myconn;
    }
}

