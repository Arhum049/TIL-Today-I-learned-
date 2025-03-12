import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = DBConnection.getConnection();

        if (conn == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert Data");
            System.out.println("2. Read Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertData(conn, scanner);
                    break;
                case 2:
                    readData(conn);
                    break;
                case 3:
                    updateData(conn, scanner);
                    break;
                case 4:
                    deleteData(conn, scanner);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void insertData(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter student name: ");
            String name = scanner.next();
            System.out.print("Enter student age: ");
            int age = scanner.nextInt();

            String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void readData(Connection conn) {
        try {
            String sql = "SELECT * FROM students";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("ID | Name | Age");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateData(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter student ID to update: ");
            int id = scanner.nextInt();
            System.out.print("Enter new age: ");
            int age = scanner.nextInt();

            String sql = "UPDATE students SET age = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, age);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteData(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter student ID to delete: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
