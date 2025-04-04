import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class BMOperation4a extends JFrame {
    public BMOperation4a() {
        // Setup second frame
        setTitle("Employee Desktop");
        setBounds(20, 20, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Employee Desktop");
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
        pt1.setBounds(100, 100, 600, 460); // Adjusted size and position (shrink to account for removed fields)
        pt1.setOpaque(false);

        // Background for pt1
        ImageIcon bk1 = new ImageIcon("src/resources/Desktopbg.jpg");
        Image scaledImage1 = bk1.getImage().getScaledInstance(600, 460, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel backgroundLabel1 = new JLabel(scaledIcon1);
        backgroundLabel1.setBounds(0, 0, 600, 460);

        // Create rounded labels and fields
        RoundedLabel actionLabel1 = new RoundedLabel("Name", Color.WHITE, 20, 20);
        actionLabel1.setBounds(50, 50, 300, 40);
        actionLabel1.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel1.setForeground(customColor);

        RoundedField field1 = new RoundedField(20); // Rounded text field for "Name"
        field1.setBounds(360, 50, 200, 40);

        RoundedLabel actionLabel2 = new RoundedLabel("#Emp No", Color.WHITE, 20, 20);
        actionLabel2.setBounds(50, 100, 300, 40);
        actionLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel2.setForeground(customColor);

        RoundedField field2 = new RoundedField(20); // Rounded text field for "Employee Number"
        field2.setBounds(360, 100, 200, 40);

        RoundedLabel actionLabel3 = new RoundedLabel("Email", Color.WHITE, 20, 20);
        actionLabel3.setBounds(50, 150, 300, 40);
        actionLabel3.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel3.setForeground(customColor);

        RoundedField field3 = new RoundedField(20); // Rounded text field for "Email"
        field3.setBounds(360, 150, 200, 40);

        // Adjusted positions for remaining fields after removing the password field
        RoundedLabel actionLabel5 = new RoundedLabel("Branch Code", Color.WHITE, 20, 20);
        actionLabel5.setBounds(50, 200, 300, 40);
        actionLabel5.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel5.setForeground(customColor);

        RoundedField field5 = new RoundedField(20); // Rounded text field for "Branch Code"
        field5.setBounds(360, 200, 200, 40);

        RoundedLabel actionLabel6 = new RoundedLabel("Salary", Color.WHITE, 20, 20);
        actionLabel6.setBounds(50, 250, 300, 40);
        actionLabel6.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel6.setForeground(customColor);

        RoundedField field6 = new RoundedField(20); // Rounded text field for "Salary"
        field6.setBounds(360, 250, 200, 40);

        // Create Custom Rounded Dropdown (JComboBox)
        RoundedLabel actionLabel7 = new RoundedLabel("Designation", Color.WHITE, 20, 20);
        actionLabel7.setBounds(50, 300, 300, 40);
        actionLabel7.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel7.setForeground(customColor);

        String[] jobTitles = {"Data Entry Operator", "Cashier"};
        JComboBox<String> jobComboBox = new JComboBox<>(jobTitles);
        jobComboBox.setBounds(360, 300, 200, 40); // Position it below the salary field

        // Back button
        RoundedButton backButton = new RoundedButton("Back");
        backButton.setBounds(50, 400, 110, 35); // Adjusted position
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                //new Main(); // Open the main page
            }
        });
        backButton.setBackground(customColor);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Impact", Font.PLAIN, 16));
        backButton.setToolTipText("Click here to return!");

        // Submit button
        RoundedButton submit = new RoundedButton("Submit");
        submit.setBounds(470, 400, 110, 35); // Adjusted position
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                //new Main(); // Open the main page
            }
        });
        submit.setBackground(customColor);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Impact", Font.PLAIN, 16));
        submit.setToolTipText("Click here to submit!");

        // Add components to panels
        pt1.add(actionLabel1);
        pt1.add(field1);
        pt1.add(actionLabel2);
        pt1.add(field2);
        pt1.add(actionLabel3);
        pt1.add(field3);
        pt1.add(actionLabel5);
        pt1.add(field5);
        pt1.add(actionLabel6);
        pt1.add(field6);
        pt1.add(actionLabel7);
        pt1.add(jobComboBox); // Add the dropdown menu
        pt1.add(backButton);
        pt1.add(submit);
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
        new BMOperation4a();
    }
}
