import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.FileNotFoundException;

public class EmployeeOperation1 extends JFrame {
    EmployeeOperations employeeOperations=new EmployeeOperations();
    public EmployeeOperation1() {
        // Setup second frame
        setTitle("Employee Desktop");
        setBounds(20, 20, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Employee Password Update");
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

        // Create rounded labels and text fields for input
        RoundedLabel inputLabel1 = new RoundedLabel("User Name: ", Color.WHITE, 20, 20);
        inputLabel1.setBounds(50, 50, 410, 40);
        inputLabel1.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel1.setForeground(customColor); // Set the font color

        RoundedField textField1 = new RoundedField(1);
        textField1.setBounds(50, 100, 410, 40);
        textField1.setFont(new Font("Arial", Font.PLAIN, 18));

        RoundedLabel inputLabel2 = new RoundedLabel("Password: ", Color.WHITE, 20, 20);
        inputLabel2.setBounds(50, 150, 410, 40);
        inputLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel2.setForeground(customColor);


        RoundedField textField2 = new RoundedField(1);
        textField2.setBounds(50, 200, 410, 40);
        textField2.setFont(new Font("Arial", Font.PLAIN, 18));


        // Submit button
        RoundedButton submitButton = new RoundedButton("Submit");
        submitButton.setBounds(370, 300, 110, 40);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String id = textField2.getText();
                JOptionPane.showMessageDialog(null, "Submitted: " + name + " - " + id);

            }
        });
        submitButton.setBackground(customColor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Impact", Font.PLAIN, 16));

        // Back button
        RoundedButton backButton = new RoundedButton("Back");
        backButton.setBounds(50, 300, 110, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new EmployeeDesktop(); // Assuming 'Main' is the main page
            }
        });
        backButton.setBackground(customColor);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Impact", Font.PLAIN, 16));

        // Add components to panels
        pt1.add(inputLabel1);
        pt1.add(textField1);
        pt1.add(inputLabel2);
        pt1.add(textField2);
        pt1.add(submitButton);
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
        new EmployeeOperation1();
    }
}
