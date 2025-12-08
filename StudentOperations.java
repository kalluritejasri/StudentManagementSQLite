import java.sql.*;
import java.util.Scanner;

public class StudentOperations {

    Scanner scanner = new Scanner(System.in);

    // Add a new student
    public void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter Year of Study (1-4): ");
        int year = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        String sql = "INSERT INTO students(name, department, year) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, dept);
            pstmt.setInt(3, year);

            pstmt.executeUpdate();
            System.out.println("✔ Student added successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error adding student!");
            e.printStackTrace();
        }
    }

    // View all students
    public void viewStudents() {
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n----- STUDENT LIST -----");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Name: " + rs.getString("name")
                        + " | Dept: " + rs.getString("department")
                        + " | Year: " + rs.getInt("year"));
            }
            System.out.println("------------------------\n");

        } catch (SQLException e) {
            System.out.println("❌ Error retrieving students!");
            e.printStackTrace();
        }
    }

    // Delete a student by ID
    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0)
                System.out.println("✔ Student deleted successfully!");
            else
                System.out.println("⚠ No student found with that ID.");

        } catch (SQLException e) {
            System.out.println("❌ Error deleting student!");
            e.printStackTrace();
        }
    }
}
