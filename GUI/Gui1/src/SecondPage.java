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
        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        fullNameLabel.setForeground(Color.BLACK); // Set text color
        fullNameLabel.setBounds(439, 150, 100, 30); // Set position and size

// Create the JTextField for Full Name input
        final JTextField fullNameField = new JTextField();
        fullNameField.setBounds(439, 180, 150, 30);
        fullNameField.setForeground(Color.GRAY);
        fullNameField.setText("Enter full name"); // Placeholder text

// Create a JLabel for Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        phoneLabel.setForeground(Color.BLACK); // Set text color
        phoneLabel.setBounds(439, 210, 100, 30); // Set position and size

// Create the JTextField for Phone input
        final JTextField phoneField = new JTextField();
        phoneField.setBounds(439, 240, 150, 32);
        phoneField.setForeground(Color.GRAY);
        phoneField.setText("Enter phone number"); // Placeholder text

// Create a JLabel for Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        addressLabel.setForeground(Color.BLACK); // Set text color
        addressLabel.setBounds(439, 272, 100, 30); // Set position and size

// Create the JTextField for Address input
        final JTextField addressField = new JTextField();
        addressField.setBounds(439, 302, 150, 32);
        addressField.setForeground(Color.GRAY);
        addressField.setText("Enter address"); // Placeholder text

// Create a JLabel for Customer Type
        JLabel customerTypeLabel = new JLabel("Customer Type:");
        customerTypeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        customerTypeLabel.setForeground(Color.BLACK); // Set text color
        customerTypeLabel.setBounds(439, 334, 150, 30); // Set position and size

// Create the JTextField for Customer Type input
        final JTextField customerTypeField = new JTextField();
        customerTypeField.setBounds(439, 364, 150, 32);
        customerTypeField.setForeground(Color.GRAY);
        customerTypeField.setText("Enter customer type"); // Placeholder text

// Create a JLabel for Meter Type
        JLabel meterTypeLabel = new JLabel("Meter Type:");
        meterTypeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        meterTypeLabel.setForeground(Color.BLACK); // Set text color
        meterTypeLabel.setBounds(439, 396, 100, 30); // Set position and size

// Create the JTextField for Meter Type input
        final JTextField meterTypeField = new JTextField();
        meterTypeField.setBounds(439, 436, 150, 32);
        meterTypeField.setForeground(Color.GRAY);
        meterTypeField.setText("Enter meter type"); // Placeholder text

// Add focus listeners for placeholders
        fullNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fullNameField.getText().equals("Enter full name")) {
                    fullNameField.setText("");
                    fullNameField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fullNameField.getText().isEmpty()) {
                    fullNameField.setText("Enter full name");
                    fullNameField.setForeground(Color.GRAY);
                }
            }
        });

        phoneField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (phoneField.getText().equals("Enter phone number")) {
                    phoneField.setText("");
                    phoneField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (phoneField.getText().isEmpty()) {
                    phoneField.setText("Enter phone number");
                    phoneField.setForeground(Color.GRAY);
                }
            }
        });

        addressField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (addressField.getText().equals("Enter address")) {
                    addressField.setText("");
                    addressField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (addressField.getText().isEmpty()) {
                    addressField.setText("Enter address");
                    addressField.setForeground(Color.GRAY);
                }
            }
        });

        customerTypeField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (customerTypeField.getText().equals("Enter customer type")) {
                    customerTypeField.setText("");
                    customerTypeField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (customerTypeField.getText().isEmpty()) {
                    customerTypeField.setText("Enter customer type");
                    customerTypeField.setForeground(Color.GRAY);
                }
            }
        });

        meterTypeField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (meterTypeField.getText().equals("Enter meter type")) {
                    meterTypeField.setText("");
                    meterTypeField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (meterTypeField.getText().isEmpty()) {
                    meterTypeField.setText("Enter meter type");
                    meterTypeField.setForeground(Color.GRAY);
                }
            }
        });







        JButton openSecondPageButton = new JButton("Submit");
        openSecondPageButton.setBounds(429,410,110,25);
        openSecondPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                new custDesktop();
            }
        });

        openSecondPageButton.setBackground(customColor);
        openSecondPageButton.setForeground(Color.WHITE);
        openSecondPageButton.setFont(new Font("Impact", Font.PLAIN, 16));
        // openSecondPageButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        openSecondPageButton.setToolTipText("Click here to perform an action!");








        JButton openFirstPageButton = new JButton("Back");
        openFirstPageButton.setBounds(339,486,110,25);
        openFirstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current window and open the second page
                dispose(); // Optional: To close the main page
                new Main();
            }
        });

        openFirstPageButton.setBackground(customColor);
        openFirstPageButton.setForeground(Color.WHITE);
        openFirstPageButton.setFont(new Font("Impact", Font.PLAIN, 16));
        openFirstPageButton.setToolTipText("Click here to perform an action!");


        // Add button to the main frame


        mainPanel.add(fullNameLabel);
        mainPanel.add(fullNameField);
        mainPanel.add(phoneLabel);
        mainPanel.add(phoneField);
        mainPanel.add(addressLabel);
        mainPanel.add(addressField);
        mainPanel.add(customerTypeLabel);
        mainPanel.add(customerTypeField);
        mainPanel.add(meterTypeLabel);
        mainPanel.add(meterTypeField);
        mainPanel.add(titleLabel);
        mainPanel.add(pt1); // Add rounded panel
        pt1.add(openFirstPageButton); // Add the button inside pt1
        pt1.add(openSecondPageButton); // Add the login button inside pt1

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