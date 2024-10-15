import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

class SecondPage extends JFrame {
    public SecondPage() {
        // Setup second frame
        setTitle("Signup Page");
        setBounds(20,20,800,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Signup");
        titleLabel.setBounds(379, 100, 300, 40); // Set position and size
        titleLabel.setFont(new Font("Impact",Font.PLAIN, 24));
        Color customColor = new Color(121, 87, 87); // RGB for #795757
        titleLabel.setForeground(customColor);// Set font, style, and size



        ImageIcon originalIcon = new ImageIcon("src/resources/bulb-icon.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        titleLabel.setIcon(scaledIcon);

        titleLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);






        ImageIcon bk=new ImageIcon("src/resources/bulb.jpg");
        Image scaledImage2 = bk.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel backgroundLabel = new JLabel(scaledIcon2);
        backgroundLabel.setBounds(0, 0, 800, 800);





        JPanel pt1=new JPanel() {
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
        pt1.setBounds(120,70,550,520);
        pt1.setOpaque(false);




        ImageIcon bk1=new ImageIcon("src/resources/bulb3.jpg");
        Image scaledImage1 = bk1.getImage().getScaledInstance(270, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel backgroundLabel1 = new JLabel(scaledIcon1);
        backgroundLabel1.setBounds(0, 0, 270, 800);






        // Create a JLabel for Full Name
        JLabel customerIdLabel = new JLabel("Customer ID");
        customerIdLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        customerIdLabel.setForeground(Color.BLACK); // Set text color
        customerIdLabel.setBounds(439, 150, 100, 30); // Set position and size

// Create the JTextField for Full Name input
        final JTextField customerIdField = new JTextField();
        customerIdField.setBounds(439, 180, 150, 30);
        customerIdField.setForeground(Color.GRAY);
        customerIdField.setText("Enter Customer ID"); // Placeholder text

// Create a JLabel for Phone
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        passwordLabel.setForeground(Color.BLACK); // Set text color
        passwordLabel.setBounds(439, 210, 150, 30); // Set position and size

// Create the JTextField for Phone input
        final JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(439, 240, 150, 32);
        passwordField.setForeground(Color.GRAY);
        passwordField.setText("Enter Password"); // Placeholder text


        // Create a JLabel for Phone
        JLabel CpasswordLabel = new JLabel("Confirm Password");
        CpasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        CpasswordLabel.setForeground(Color.BLACK); // Set text color
        CpasswordLabel.setBounds(439, 280, 150, 30); // Set position and size

// Create the JTextField for Phone input
        final JPasswordField CpasswordField = new JPasswordField();
        CpasswordField.setBounds(439, 310, 150, 32);
        CpasswordField.setForeground(Color.GRAY);
        CpasswordField.setText("Enter Confirm Password"); // Placeholder text


// Add focus listeners for placeholders
        customerIdField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (customerIdField.getText().equals("Enter Customer ID")) {
                    customerIdField.setText("");
                    customerIdField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (customerIdField.getText().isEmpty()) {
                    customerIdField.setText("Enter Customer ID");
                    customerIdField.setForeground(Color.GRAY);
                }
            }
        });

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Enter Customer CNIC")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Enter Customer CNIC");
                    passwordField.setForeground(Color.GRAY);
                }
            }

        });


        RoundedButton openFPage = new RoundedButton("Submit");
        openFPage.setBounds(439, 340, 110, 32);
        openFPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new EmployeeOperation3();
                dispose();
            }
        });

        openFPage.setBackground(customColor);
        openFPage.setForeground(Color.WHITE);
        openFPage.setFont(new Font("Impact", Font.PLAIN, 16));
        // openFPage.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        openFPage.setToolTipText("Click here to perform an action!");





        RoundedButton openLoginPage = new RoundedButton("Back");
        openLoginPage.setBounds(300, 340, 110, 32);
        openLoginPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main();
            }
        });

        openLoginPage.setBackground(customColor);
        openLoginPage.setForeground(Color.WHITE);
        openLoginPage.setFont(new Font("Impact", Font.PLAIN, 16));
        openLoginPage.setToolTipText("Click here to perform an action!");


        // Add button to the main frame


        mainPanel.add(customerIdLabel);
        mainPanel.add(customerIdField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(CpasswordLabel);
        mainPanel.add(CpasswordField);
        mainPanel.add(titleLabel);
        mainPanel.add(pt1); // Add rounded panel
        pt1.add(openLoginPage); // Add the button inside pt1
        pt1.add(openFPage); // Add the login button inside pt1

        pt1.add(backgroundLabel1); // Add background to pt1

// Add the labels and text fields to the main panel


        // Add full background to the main panel
        mainPanel.add(backgroundLabel);

        // Revalidate and repaint to ensure proper component visibility
        mainPanel.revalidate();
        mainPanel.repaint();

        // Add main panel to the frame
        add(mainPanel);
        setVisible(true);
    }
}