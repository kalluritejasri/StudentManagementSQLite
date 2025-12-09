# Student Management System (Java + SQLite)

This is a simple **Command Line based Student Management System** built using **Java** and **SQLite**.  
The system allows storing and managing student records locally using a lightweight SQL database.
Features
- Add new student
- View all students
- Delete a student by ID
- Automatic table creation on first run
- Data stored locally in `student_db.db`
  
Technologies Used
| Component | Technology |
|----------|-------------|
| Programming Language | Java |
| Database | SQLite |
| JDBC Driver | sqlite-jdbc |

Project Structure
StudentManagementSQLite/
├── DBConnection.java
├── DBSetup.java
├── StudentOperations.java
├── StudentManagementSQLite.java
├── sqlite-jdbc-3.42.0.0.jar
├── student_db.db (auto-generated)
 How to Run
1. Make sure Java is installed  
2. Download the project and open the folder
3. Compile the project:
javac -cp ".;sqlite-jdbc-3.42.0.0.jar" *.java
4. Run the project:
java -cp ".;sqlite-jdbc-3.42.0.0.jar" StudentManagementSQLite
