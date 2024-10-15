import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Main extends JFrame {
    public Main() {
        // Setup main frame

        setTitle("Main Page");
        setBounds(50,50,800,600);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);


        JLabel titleLabel = new JLabel("QuickBill");
        titleLabel.setBounds(379, 100, 300, 40); // Set position and size
        titleLabel.setFont(new Font("Impact",Font.PLAIN, 24));
        Color customColor = new Color(121, 87, 87); // RGB for #795757
        titleLabel.setForeground(customColor);// Set font, style, and size


// Load and scale the icon image
        ImageIcon originalIcon = new ImageIcon("src/resources/bulb-icon.png"); // Load the image
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Scale the image
        ImageIcon scaledIcon = new ImageIcon(scaledImage); // Create new ImageIcon from the scaled image

        titleLabel.setIcon(scaledIcon); // Set the scaled icon

// Position icon to the right of the text
        titleLabel.setHorizontalTextPosition(SwingConstants.RIGHT); // Text on the left, icon on the right

// Optionally set alignment to center the text and icon together
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);



        ImageIcon bk=new ImageIcon("src/resources/bulb.jpg");
        Image scaledImage2 = bk.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

        // mainPanel.setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel backgroundLabel = new JLabel(scaledIcon2);
        backgroundLabel.setBounds(0, 0, 800, 600); // Set bounds to fit the frame



        JPanel pt1=new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Create rounded rectangle with RoundRectangle2D
                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50);
                g2.setColor(getBackground());
                g2.fill(roundedRectangle); // Fill the rounded rectangle with background color
                g2.dispose();
            }
        };






        ImageIcon bk1=new ImageIcon("src/resources/bulb3.jpg");
        Image scaledImage1 = bk1.getImage().getScaledInstance(270, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);

        // mainPanel.setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel backgroundLabel1 = new JLabel(scaledIcon1);
        backgroundLabel1.setBounds(0, 0, 270, 600); // Set bounds to fit the frame


        pt1.setLayout(null);
        pt1.setBounds(120,70,550,420);
        pt1.setOpaque(false);

//
//        // Button to link to second page
        JButton openFirstPageButton = new JButton("SignUp") {
            private static final int ARC_WIDTH = 30; // Width of the arc for rounding
            private static final int ARC_HEIGHT = 30; // Height of the arc for rounding

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), ARC_WIDTH, ARC_HEIGHT); // Draw rounded rectangle
                g2d.setColor(getForeground());
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ARC_WIDTH, ARC_HEIGHT); // Draw border
                g2d.dispose();

                // Now call super to ensure the text is painted
                super.paintComponent(g);
            }
        };


        openFirstPageButton.setBounds(339,320,110,25);
        openFirstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current window and open the second page
                dispose(); // Optional: To close the main page
                new SecondPage();
            }
        });

        openFirstPageButton.setBackground(customColor);
        openFirstPageButton.setForeground(Color.WHITE);
        openFirstPageButton.setFont(new Font("Impact", Font.PLAIN, 16));
       // openFirstPageButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        openFirstPageButton.setToolTipText("Click here to perform an action!");


        // Button to link to second page
        JButton openSecondPageButton = new JButton("Login");
        openSecondPageButton.setBounds(339,250,110,25);
        openSecondPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current window and open the second page
                dispose(); // Optional: To close the main page
                new SecondPage();
            }
        });

        openSecondPageButton.setBackground(customColor);
        openSecondPageButton.setForeground(Color.WHITE);
        openSecondPageButton.setFont(new Font("Impact", Font.PLAIN, 16));
        // openSecondPageButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        openSecondPageButton.setToolTipText("Click here to perform an action!");


        // setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        nameLabel.setForeground(customColor); // Set text color
        nameLabel.setBounds(339, 100, 100, 30);

        // Set position and size

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font style and size
        passwordLabel.setForeground(customColor); // Set text color
        passwordLabel.setBounds(339, 165, 150, 32); // Set position and size



        final JTextField tf1 = new JTextField();
        final JPasswordField tf2 = new JPasswordField();

        tf1.setBounds(339, 130, 150, 32);
        tf1.setText("Enter name");
        tf1.setForeground(Color.GRAY);

        tf2.setBounds(339, 200, 150, 32);
        tf2.setText("Enter Password");
        tf2.setForeground(Color.GRAY);


        tf1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf1.getText().equals("Enter name")) {

                    tf1.setText("");
                    tf1.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tf1.getText().isEmpty()) {
                    tf1.setText("Enter name");
                    tf1.setForeground(Color.GRAY);
                }
            }
        });


        tf2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf2.getText().equals("Enter Password")) {
                    tf2.setText("");
                    tf2.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tf2.getText().isEmpty()) {
                    tf2.setText("Enter Password");
                    tf2.setForeground(Color.GRAY);
                }
            }
        });
        JLabel or=new JLabel();
        or.setText("or");
        or.setBounds(389,290,110,13);
        or.setForeground(Color.GRAY);
        or.setFont(new Font("Arial", Font.PLAIN, 16));








        // Add button to the main frame
        mainPanel.add(titleLabel);
        mainPanel.add(pt1); // Add rounded panel
        pt1.add(openFirstPageButton); // Add the button inside pt1
        pt1.add(openSecondPageButton); // Add the login button inside pt1

        pt1.add(backgroundLabel1); // Add background to pt1

        // Add text fields outside the inner panel (pt1)
        pt1.add(nameLabel);
        pt1.add(tf1);
        pt1.add(passwordLabel);
        pt1.add(tf2);
        pt1.add(or);

        // Add full background to the main panel
        mainPanel.add(backgroundLabel);

        // Revalidate and repaint to ensure proper component visibility
        mainPanel.revalidate();
        mainPanel.repaint();

        // Add main panel to the frame
        add(mainPanel);
        setVisible(true);
    }





    public static void main(String[] args) {
        new Main();
    }
}
