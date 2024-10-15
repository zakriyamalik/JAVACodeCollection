import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class custDesktop extends JFrame {
    public custDesktop() {
        // Setup second frame
        setTitle("Desktop Page");
        setBounds(20, 20, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Customer Desktop");
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
        pt1.setBounds(100, 100, 600, 500); // Adjusted size and position
        pt1.setOpaque(false);

        // Background for pt1
        ImageIcon bk1 = new ImageIcon("src/resources/Desktopbg.jpg");
        Image scaledImage1 = bk1.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel backgroundLabel1 = new JLabel(scaledIcon1);
        backgroundLabel1.setBounds(0, 0, 600, 500);


        // Create rounded labels
        RoundedLabel titleLabel1 = new RoundedLabel("Show Bill", Color.WHITE, 20, 20);
        titleLabel1.setBounds(50, 50, 300, 40);
        titleLabel1.setFont(new Font("Arial", Font.PLAIN, 24));
        titleLabel1.setForeground(customColor); // Set the font color

        RoundedLabel titleLabel2 = new RoundedLabel("Update CNIC Date", Color.WHITE, 20, 20);
        titleLabel2.setBounds(50, 100, 300, 40);
        titleLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
        titleLabel2.setForeground(customColor);

        RoundedLabel titleLabel3 = new RoundedLabel("Show Meter", Color.WHITE, 20, 20);
        titleLabel3.setBounds(50, 150, 300, 40);
        titleLabel3.setFont(new Font("Arial", Font.PLAIN, 24));
        titleLabel3.setForeground(customColor); // Set the font color

        RoundedLabel titleLabel4 = new RoundedLabel("Other actions", Color.WHITE, 20, 20);
        titleLabel4.setBounds(50, 200, 300, 40);
        titleLabel4.setFont(new Font("Arial", Font.PLAIN, 24));
        titleLabel4.setForeground(customColor);




// Add rounded labels to your panel



        // Back button
        JButton openFirstPageButton = new JButton("Back");
        openFirstPageButton.setBounds(239, 450, 110, 25); // Adjusted position
        openFirstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new Main(); // Open the main page
            }
        });
        openFirstPageButton.setBackground(customColor);
        openFirstPageButton.setForeground(Color.WHITE);
        openFirstPageButton.setFont(new Font("Impact", Font.PLAIN, 16));
        openFirstPageButton.setToolTipText("Click here to return!");

        // Add components to panels
        mainPanel.add(titleLabel1);
        mainPanel.add(titleLabel2);
        mainPanel.add(titleLabel3);
        mainPanel.add(titleLabel4);
        pt1.add(titleLabel1);
        pt1.add(titleLabel2);
        pt1.add(titleLabel3);
        pt1.add(titleLabel4);
        pt1.add(openFirstPageButton);
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

    // Helper method to create action labels
    private JLabel createActionLabel(String text, int y, Color color) {
        JLabel label = new JLabel(text);
        label.setBounds(50, y, 400, 40); // Position for alignment
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        label.setForeground(color);
        return label;
    }

    public static void main(String[] args) {
        new custDesktop();
    }
}

