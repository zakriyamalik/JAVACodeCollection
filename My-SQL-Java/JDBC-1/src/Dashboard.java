import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Dashboard {
    public Dashboard(String username) {
        JFrame frame = new JFrame("Dashboard");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton profileBtn = new JButton("Profile");
        JButton messagesBtn = new JButton("Messages");
        JButton notificationsBtn = new JButton("Notifications");

        profileBtn.addActionListener(e -> showProfile(username));
        messagesBtn.addActionListener(e -> showMessages(username));
        notificationsBtn.addActionListener(e -> showNotifications(username));

        panel.add(profileBtn);
        panel.add(messagesBtn);
        panel.add(notificationsBtn);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showProfile(String username) {
        try {
            ResultSet rs = Database.getUserProfile(username);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Profile: " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMessages(String username) {
        try {
            ResultSet rs = Database.getUserMessages(Database.getUserId(username));
            StringBuilder messages = new StringBuilder();
            while (rs.next()) {
                messages.append(rs.getString("MessageContent")).append("\n");
            }
            JOptionPane.showMessageDialog(null, "Messages: " + messages.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showNotifications(String username) {
        try {
            ResultSet rs = Database.getUserNotifications(Database.getUserId(username));
            StringBuilder notifications = new StringBuilder();
            while (rs.next()) {
                notifications.append(rs.getString("NotificationText")).append("\n");
            }
            JOptionPane.showMessageDialog(null, "Notifications: " + notifications.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
