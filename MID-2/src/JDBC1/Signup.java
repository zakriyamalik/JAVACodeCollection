import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signup {
    public Signup() {
        JFrame frame = new JFrame("Signup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton signupButton = new JButton("Signup");

        signupButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            // Insert into database
            try {
                Database.insertUser(username, password);
                JOptionPane.showMessageDialog(frame, "Signup successful!");
                frame.dispose();
                new login().showlogin();  // Redirect to login
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Signup failed!");
            }
        });

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(signupButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
