import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Input {
    String name;
    String password;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Input()
    {


    }

    void getInput() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Press 1 for Login\nPress 2 for Signup\n");
        int choice=scanner.nextInt();
        if(choice==1)
        {
            System.out.println("Login\n");
            System.out.println("Enter name\n");
            name=scanner.nextLine();
            System.out.println("Enter Password\n");
            password=scanner.nextLine();
            login();
        }
        else
        {
            System.out.println("Signup\n");
            System.out.println("Enter name\n");
            name=scanner.nextLine();
            System.out.println("Enter Password\n");
            password=scanner.nextLine();
            Signup();
        }
    }



    void login() throws SQLException
    {

        String sql = "SELECT * FROM logintable WHERE name = ? AND password = ?";

        connection = SqlOperations.getSQLDriver(connection);

        if (connection == null) {
            System.out.println("Connection is null\n");
        } else {
            try {
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, password);

                var resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login successful! Welcome, " + resultSet.getString("name"));
                } else {
                    System.out.println("Login failed. Invalid username or password.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }
    }



    void Signup() throws SQLException {

        String sql = "INSERT INTO logintable (name,password) VALUES (?, ?)";  // Update 'users' to your table name
        // Prepare statement to prevent SQL injection

        connection=SqlOperations.getSQLDriver(connection);
        System.out.println(connection);
        if(connection==null)
        {
            System.out.println("Connection is null\n");
        }
        else
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
        }
        if(connection!=null)
        {
            connection.close();
        }


    }



}
