import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/autos";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "352178000Kdi!";

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}