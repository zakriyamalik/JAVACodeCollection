import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

class CustomerSignup extends JFrame {
    public CustomerSignup() {
        // Setup frame
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
        Image scaledImage1 = bk1.getImage().getScaledInstance(270, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel backgroundLabel1 = new JLabel(scaledIcon1);
        backgroundLabel1.setBounds(0, 0, 270, 800);

        JLabel customerIdLabel = new JLabel("Customer ID");
        customerIdLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        customerIdLabel.setForeground(Color.BLACK);
        customerIdLabel.setBounds(439, 150, 100, 30);

        final JTextField customerIdField = new JTextField();
        customerIdField.setBounds(439, 180, 150, 30);
        customerIdField.setForeground(Color.GRAY);
        customerIdField.setText("Enter Customer ID");

        JLabel passwordLabel = new JLabel("CNIC");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(439, 210, 150, 30);

        final JTextField passwordField = new JTextField();
        passwordField.setBounds(439, 240, 150, 32);
        passwordField.setForeground(Color.GRAY);
        passwordField.setText("Enter CNIC");

        // Error message label (initially hidden)
        final JLabel errorLabel = new JLabel("Wrong ID/CNIC");
        errorLabel.setBounds(439, 340, 150, 30);
        errorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false); // Set to hidden initially

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
                if (passwordField.getText().equals("Enter CNIC")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Enter CNIC");
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });

        RoundedButton openFPage = new RoundedButton("Submit");
        openFPage.setBounds(416, 240, 110, 32);
        openFPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = customerIdField.getText();
                String password = passwordField.getText();

                CustomerOperations co = new CustomerOperations(null);
                if (co.validateCustomerLogin(ID, password)) {
                    new custDesktop();
                    dispose();
                 //   JOptionPane.showMessageDialog(null, "Matched");
                } else {
                    errorLabel.setVisible(true); // Show error message
                }
            }
        });

        openFPage.setBackground(customColor);
        openFPage.setForeground(Color.WHITE);
        openFPage.setFont(new Font("Impact", Font.PLAIN, 16));

        RoundedButton openLoginPage = new RoundedButton("Back");
        openLoginPage.setBounds(295, 240, 110, 32);
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

        mainPanel.add(customerIdLabel);
        mainPanel.add(customerIdField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(errorLabel); // Add the error message label
        mainPanel.add(titleLabel);
        mainPanel.add(pt1); // Add rounded panel
        pt1.add(openLoginPage); // Add the Back button inside pt1
        pt1.add(openFPage); // Add the Submit button inside pt1
        pt1.add(backgroundLabel1); // Add background to pt1

        mainPanel.add(backgroundLabel); // Add full background to the main panel

        mainPanel.revalidate();
        mainPanel.repaint();

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        CustomerSignup sc=new CustomerSignup();

    }
}
