import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

class EmployeeSignup extends JFrame {
    public EmployeeSignup() {
        // Setup second frame
        setTitle("Signup Page");
        setBounds(20, 20, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Signup");
        titleLabel.setBounds(379, 100, 300, 40); // Set position and size
        titleLabel.setFont(new Font("Impact", Font.PLAIN, 24));
        Color customColor = new Color(121, 87, 87); // RGB for #795757
        titleLabel.setForeground(customColor); // Set font, style, and size

        ImageIcon originalIcon = new ImageIcon("src/resources/bulb-icon.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        titleLabel.setIcon(scaledIcon);

        titleLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon bk = new ImageIcon("src/resources/bulb.jpg");
        Image scaledImage2 = bk.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel backgroundLabel = new JLabel(scaledIcon2);
        backgroundLabel.setBounds(0, 0, 800, 800);

        JPanel pt1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Create rounded rectangle with RoundRectangle2D
                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50);
                g2.setColor(getBackground());
                g2.fill(roundedRectangle);
                g2.dispose();
            }
        };
        pt1.setLayout(null);
        pt1.setBounds(120, 70, 550, 420);
        pt1.setOpaque(false);

        ImageIcon bk1 = new ImageIcon("src/resources/bulb3.jpg");
        Image scaledImage1 = bk1.getImage().getScaledInstance(270, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel backgroundLabel1 = new JLabel(scaledIcon1);
        backgroundLabel1.setBounds(0, 0, 270, 600);

        // Create a JLabel for Employee ID
        JLabel employeeIdLabel = new JLabel("Name");
        employeeIdLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        employeeIdLabel.setForeground(Color.BLACK); // Set text color
        employeeIdLabel.setBounds(439, 150, 100, 30); // Set position and size

        // Create the JTextField for Employee ID input
        final JTextField employeeIdField = new JTextField();
        employeeIdField.setBounds(439, 180, 150, 30);
        employeeIdField.setForeground(Color.GRAY);
        employeeIdField.setText("Enter Employee Name"); // Placeholder text

        // Create a JLabel for Password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        passwordLabel.setForeground(Color.BLACK); // Set text color
        passwordLabel.setBounds(439, 210, 150, 30); // Set position and size

        // Create the JPasswordField for password input
        final JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(439, 240, 150, 32);
        passwordField.setForeground(Color.GRAY);
        passwordField.setText("Enter Password"); // Placeholder text

        // Create a JLabel for displaying error messages
        final JLabel errorLabel = new JLabel("");
        errorLabel.setBounds(439, 360, 300, 30); // Adjust position and size
        errorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        errorLabel.setForeground(Color.RED);

        // Add focus listeners for placeholders
        employeeIdField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (employeeIdField.getText().equals("Enter Employee Name")) {
                    employeeIdField.setText("");
                    employeeIdField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (employeeIdField.getText().isEmpty()) {
                    employeeIdField.setText("Enter Employee Name");
                    employeeIdField.setForeground(Color.GRAY);
                }
            }
        });

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Enter Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Enter Password");
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });

        // Create a "Submit" button
        RoundedButton openFPage = new RoundedButton("Submit");
        openFPage.setBounds(546, 300, 110, 32);
        openFPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = employeeIdField.getText();
                String password = new String(passwordField.getPassword());
                EmployeeOperations eo=new EmployeeOperations();


                // Clear previous error messages
                errorLabel.setText("");
               // EmployeeOperations eo=new EmployeeOperations();


                if (userName.equals("Enter Employee ID") || userName.isEmpty()) {
                    errorLabel.setText("Employee ID cannot be empty.");
                } else if (password.isEmpty() || password.equals("Enter Password")) {
                    errorLabel.setText("Password cannot be empty.");
                }
                else if(!eo.validateLogin(userName,password)){
                    errorLabel.setText("Wrong Name/Password");
                }
                else
                {
                    new EmployeeDesktop();
                    dispose();
                }
            }
        });

        openFPage.setBackground(customColor);
        openFPage.setForeground(Color.WHITE);
        openFPage.setFont(new Font("Impact", Font.PLAIN, 16));

        // Create a "Back" button
        RoundedButton openLoginPage = new RoundedButton("Back");
        openLoginPage.setBounds(416, 300, 110, 32);
        openLoginPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              dispose();
              new UserSelectionScreen();
            }
        });

        openLoginPage.setBackground(customColor);
        openLoginPage.setForeground(Color.WHITE);
        openLoginPage.setFont(new Font("Impact", Font.PLAIN, 16));

        // Add components to the main panel
        mainPanel.add(employeeIdLabel);
        mainPanel.add(employeeIdField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(errorLabel);
        mainPanel.add(openFPage);
        mainPanel.add(openLoginPage);
        mainPanel.add(titleLabel);
        mainPanel.add(pt1); // Add rounded panel
        pt1.add(backgroundLabel1); // Add background to pt1

        mainPanel.add(backgroundLabel); // Add full background

        // Add main panel to the frame
        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        EmployeeSignup employeeSignup=new EmployeeSignup();
    }
}
