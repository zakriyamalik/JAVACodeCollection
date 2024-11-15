package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.ConnectionConfigurator;
import com.mysql.cj.protocol.Message;

public class EmployeeDao {
    public EmployeeDao() {
    }
    public void insertEmployee(String name, String empNo, String email, String branchCode, String salary, String designation) {

        String insertSQL = "INSERT INTO Employee (emp_no, name, email, branch_code, salary, designation) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionConfigurator.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {


            // Set parameters for the prepared statement
            pstmt.setString(1, empNo);            // emp_no
            pstmt.setString(2, name);             // name
            pstmt.setString(3, email);            // email
            pstmt.setString(4, branchCode);       // branch_code
            pstmt.setBigDecimal(5, new java.math.BigDecimal(salary)); // salary
            pstmt.setString(6, designation);      // designation

            // Execute the insert operation
            int rowsInserted = pstmt.executeUpdate();

            // Check if the insertion was successful
            if (rowsInserted > 0) {

                System.out.println("Employee inserted successfully!");
            } else {
                System.out.println("Failed to insert employee.");
            }
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid salary format.");
            e.printStackTrace();
        }
    }
}
