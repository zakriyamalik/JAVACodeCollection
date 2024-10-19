import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Database {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lab6";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
    static void insertUser(String name,String password) throws SQLException {
        String sql = " insert into users (name,password)"
                + " values (?, ?)";
        PreparedStatement preparedStmt = getConnection().prepareStatement(sql);
        preparedStmt.setString (1, name);
        preparedStmt.setString (2, password);
        int rowsAffected = preparedStmt.executeUpdate();
        System.out.println("Inserted " + rowsAffected + " row(s) into the database.");
    }
    static boolean validateUser(String name,String password) throws SQLException {
        String sql = "Select * from users where name=? AND password=?";
        PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
        preparedStatement.setString(1, name);      // Set the first parameter as 'name'
        preparedStatement.setString(2, password);  // Set the second parameter as 'password'
        ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.next())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

//    public static boolean validateUser(String username, String password) throws SQLException {
//        String query = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
//        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setString(1, username);
//            ps.setString(2, password);
//            ResultSet rs = ps.executeQuery();
//            return rs.next();
//        }
//    }

//    public static void insertUser(String username, String password) throws SQLException {
//        String query = "INSERT INTO Users (Username, Password) VALUES (?, ?)";
//        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setString(1, username);
//            ps.setString(2, password);
//            ps.executeUpdate();
//        }
//    }

    public static ResultSet getUserProfile(String username) throws SQLException {
        String query = "SELECT * FROM Users WHERE name = ?";
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        return ps.executeQuery();
    }

    public static ResultSet getUserMessages(int userId) throws SQLException {
        String query = "SELECT * FROM Messages WHERE UserID = ?";
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        return ps.executeQuery();
    }

    public static ResultSet getUserNotifications(int userId) throws SQLException {
        String query = "SELECT * FROM Notifications WHERE UserID = ?";
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        return ps.executeQuery();
    }

    public static int getUserId(String username) throws SQLException {
        String query = "SELECT ID FROM Users WHERE name = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID"); // Retrieve the ID if found
            } else {
                return -1; // Return -1 if the user is not found
            }
        }
    }

    public static void TableData() {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/lab6"; // Replace with your DB name
        String user = "root";  // Replace with your MySQL username
        String password = "";  // Replace with your MySQL password

        // SQL Query to get all data from the table
        String query = "SELECT * FROM users";  // Replace with your table name

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Step 3: Create a statement
            PreparedStatement stmt = con.prepareStatement(query);

            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery(query);
            String name="";
            String newPassword="";
            // Step 5: Process the result set
            while (rs.next()) {
                // Assuming your table has columns named 'id', 'name', 'age' (replace these with actual columns)
                 name = rs.getString("name");
                 password = rs.getString("password");
                 newPassword="";
                 if(Objects.equals(password, "bitcoin"))
                 {
                     Scanner sc=new Scanner(System.in);
                     System.out.println("Enter new Password\n");
                     newPassword=sc.nextLine();  // Replace with the new password


                     String updateQuery = "UPDATE users SET password = ? WHERE name = ?";  // Modify the condition as necessary
                     PreparedStatement updateStmt = con.prepareStatement(updateQuery);

                     // Set the parameters for the update query
                     updateStmt.setString(1, newPassword);
                     updateStmt.setString(2, name);

                     // Execute the update
                     int rowsUpdated = updateStmt.executeUpdate();
                     if (rowsUpdated > 0) {
                         System.out.println("Password updated for user: " + name);
                     }

                     updateStmt.close();
                     // Print the data
                     System.out.println("Name: " + name+"Updated password: "+newPassword );


                 }
                }

            // Step 6: Close the connections


            String deleteQuery = "DELETE FROM users WHERE name != ? OR password != ?";
            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);

            // Set the parameters for the delete query
            deleteStmt.setString(1, name);
            deleteStmt.setString(2, newPassword);

            // Execute the delete
            int rowsDeleted = deleteStmt.executeUpdate();
            System.out.println(rowsDeleted + " other records deleted.");

            deleteStmt.close();
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
