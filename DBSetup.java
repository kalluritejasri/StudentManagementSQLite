import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DBSetup {

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "department TEXT NOT NULL, "
                + "year INTEGER NOT NULL"
                + ");";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("✔ Students table is ready.");

        } catch (SQLException e) {
            System.out.println("❌ Error creating table!");
            e.printStackTrace();
        }
    }
}
