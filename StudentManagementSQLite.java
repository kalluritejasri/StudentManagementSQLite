import java.util.Scanner;

public class StudentManagementSQLite {

    public static void main(String[] args) {

        DBSetup.createTable(); // Ensure table exists
        StudentOperations ops = new StudentOperations();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    ops.addStudent();
                    break;
                case 2:
                    ops.viewStudents();
                    break;
                case 3:
                    ops.deleteStudent();
                    break;
                case 4:
                    System.out.println("🚀 Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
