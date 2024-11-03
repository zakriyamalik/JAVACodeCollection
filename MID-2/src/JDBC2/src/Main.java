package JDBC2.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    static Input input=new Input();

    public static void main(String[] args) throws SQLException {
        input.getInput();
        return;
    }
}
