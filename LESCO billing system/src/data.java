import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class data extends JFrame {
    public data() {
        // Setup second frame
        setTitle("Data");
        setBounds(20, 20, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Data");
        titleLabel.setBounds(0, 30, 800, 40); // Centered title
        titleLabel.setFont(new Font("Impact", Font.PLAIN, 24));
        Color customColor = new Color(121, 87, 87); // RGB for #795757
        titleLabel.setForeground(customColor); // Set font color

        // Load and scale the icon image
        ImageIcon originalIcon = new ImageIcon("src/resources/bulb-icon.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        titleLabel.setIcon(scaledIcon);
        titleLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Set background
        ImageIcon bk = new ImageIcon("src/resources/bulb.jpg");
        Image scaledImage2 = bk.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel backgroundLabel = new JLabel(scaledIcon2);
        backgroundLabel.setBounds(0, 0, 800, 800);

        // Create rounded panel
        JPanel pt1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50);
                g2.setColor(getBackground());
                g2.fill(roundedRectangle);
                g2.dispose();
            }
        };
        pt1.setLayout(null);
        pt1.setBounds(100, 100, 600, 540); // Adjusted size and position
        pt1.setOpaque(false);

        // Background for pt1
        ImageIcon bk1 = new ImageIcon("src/resources/Desktopbg.jpg");
        Image scaledImage1 = bk1.getImage().getScaledInstance(600, 540, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel backgroundLabel1 = new JLabel(scaledIcon1);
        backgroundLabel1.setBounds(0, 0, 600, 540);

        // Create rounded labels
        RoundedLabel actionLabel1 = new RoundedLabel("Employee Details", Color.WHITE, 20, 20);
        actionLabel1.setBounds(50, 50, 300, 40);
        actionLabel1.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel1.setForeground(customColor); // Set the font color

        RoundedLabel actionLabel2 = new RoundedLabel("Update Address", Color.WHITE, 20, 20);
        actionLabel2.setBounds(50, 100, 300, 40);
        actionLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel2.setForeground(customColor);

        RoundedLabel actionLabel3 = new RoundedLabel("Update Contact", Color.WHITE, 20, 20);
        actionLabel3.setBounds(50, 150, 300, 40);
        actionLabel3.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel3.setForeground(customColor);

        RoundedLabel actionLabel4 = new RoundedLabel("View Timesheet", Color.WHITE, 20, 20);
        actionLabel4.setBounds(50, 200, 300, 40);
        actionLabel4.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel4.setForeground(customColor);

        RoundedLabel actionLabel5 = new RoundedLabel("Assign Tasks", Color.WHITE, 20, 20);
        actionLabel5.setBounds(50, 250, 300, 40);
        actionLabel5.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel5.setForeground(customColor);

        RoundedLabel actionLabel6 = new RoundedLabel("Manage Leave", Color.WHITE, 20, 20);
        actionLabel6.setBounds(50, 300, 300, 40);
        actionLabel6.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel6.setForeground(customColor);

        RoundedLabel actionLabel7 = new RoundedLabel("Generate Payroll", Color.WHITE, 20, 20);
        actionLabel7.setBounds(50, 350, 300, 40);
        actionLabel7.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel7.setForeground(customColor);

        RoundedLabel actionLabel8 = new RoundedLabel("Request Assistance", Color.WHITE, 20, 20);
        actionLabel8.setBounds(50, 400, 300, 40);
        actionLabel8.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel8.setForeground(customColor);

        RoundedLabel actionLabel9 = new RoundedLabel("Submit Feedback", Color.WHITE, 20, 20);
        actionLabel9.setBounds(50, 450, 300, 40);
        actionLabel9.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel9.setForeground(customColor);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(239, 500, 110, 25); // Adjusted position
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new Main(); // Open the main page
            }
        });
        backButton.setBackground(customColor);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Impact", Font.PLAIN, 16));
        backButton.setToolTipText("Click here to return!");

        // Add components to panels
        pt1.add(actionLabel1);
        pt1.add(actionLabel2);
        pt1.add(actionLabel3);
        pt1.add(actionLabel4);
        pt1.add(actionLabel5);
        pt1.add(actionLabel6);
        pt1.add(actionLabel7);
        pt1.add(actionLabel8);
        pt1.add(actionLabel9);
        pt1.add(backButton);
        pt1.add(backgroundLabel1); // Add background to pt1

        // Add components to the main panel
        mainPanel.add(titleLabel);
        mainPanel.add(pt1); // Add rounded panel
        mainPanel.add(backgroundLabel); // Full background

        // Revalidate and repaint to ensure proper component visibility
        mainPanel.revalidate();
        mainPanel.repaint();

        // Add main panel to the frame
        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new data();
    }
}