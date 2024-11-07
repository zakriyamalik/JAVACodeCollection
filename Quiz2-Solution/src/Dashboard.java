import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Dashboard {
    String un; // Username of the current user
    JTextField recipientField;
    JTextField messageField;
    JButton sendButton;
    JPanel sendMessagePanel;

    Dashboard(String un) {
        this.un = un;
        showDashboard(un);
    }

    void showDashboard(String un) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(100, 100, 600, 600);

        // Main panel setup
        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("Welcome " + un);
        panel1.add(label1);

        // Tabbed pane for Inbox, Sent Box, and Send Message tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        // Inbox and Sent Box panels (simplified for brevity)
        JPanel inboxPanel = new JPanel(new BorderLayout());
        JTextArea inboxArea = new JTextArea();
        inboxArea.setEditable(false);
        inboxPanel.add(new JScrollPane(inboxArea), BorderLayout.CENTER);
        tabbedPane.addTab("Inbox", inboxPanel);

        JPanel sentBoxPanel = new JPanel(new BorderLayout());
        JTextArea sentBoxArea = new JTextArea();
        sentBoxArea.setEditable(false);
        sentBoxPanel.add(new JScrollPane(sentBoxArea), BorderLayout.CENTER);
        tabbedPane.addTab("Sent Box", sentBoxPanel);

        // Send Message panel
        sendMessagePanel = new JPanel(new GridLayout(3, 2));
        recipientField = new JTextField();
        messageField = new JTextField();
        sendMessagePanel.add(new JLabel("Recipient Username:"));
        sendMessagePanel.add(recipientField);
        sendMessagePanel.add(new JLabel("Message:"));
        sendMessagePanel.add(messageField);

        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        sendMessagePanel.add(sendButton);
        tabbedPane.addTab("Send Message", sendMessagePanel);

        jf.add(tabbedPane);
        jf.setVisible(true);
    }

    private void sendMessage() {
        String recipientName = recipientField.getText();
        String messageContent = messageField.getText();

        try {
            int result = Database.insertMessage(un, recipientName, messageContent);
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Message sent successfully!");
                recipientField.setText("");
                messageField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to send message.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error sending message. Please try again.");
        }
    }

    public static void main(String[] args) {
        new Dashboard("John");
    }
}
