import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class EmployeeOperation3_2b extends JFrame {
    RoundedField textField1;
    RoundedField textField2;
    RoundedField textField4;
    RoundedField textField5;
    Boolean isSubmitted=false;

    public EmployeeOperation3_2b() {
        // Setup second frame
        setTitle("Employee Desktop");
        setBounds(20, 10, 900, 800); // Increased width of the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Customer Information Input");
        titleLabel.setBounds(40, 5, 800, 40); // Centered title
        titleLabel.setFont(new Font("Impact", Font.PLAIN, 24));
        Color customColor = new Color(121, 87, 87); // RGB for #795757
        titleLabel.setForeground(customColor); // Set font color
        ImageIcon originalIcon = new ImageIcon("src/resources/bulb-icon.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        titleLabel.setIcon(scaledIcon);
        titleLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Set background
        ImageIcon bk = new ImageIcon("src/resources/bulb.jpg");
        Image scaledImage2 = bk.getImage().getScaledInstance(900, 800, Image.SCALE_SMOOTH); // Adjust background size
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel backgroundLabel = new JLabel(scaledIcon2);
        backgroundLabel.setBounds(0, 0, 900, 800);

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
        pt1.setBounds(100, 50, 700, 600); // Increased width of the rounded panel
        pt1.setOpaque(false);

        // Background for pt1
        ImageIcon bk1 = new ImageIcon("src/resources/Desktopbg.jpg");
        Image scaledImage1 = bk1.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH); // Adjusted size
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel backgroundLabel1 = new JLabel(scaledIcon1);
        backgroundLabel1.setBounds(0, 0, 700, 600);

        // Labels and text fields for input (6 pairs)
        RoundedLabel inputLabel1 = new RoundedLabel("Regular Meter Reading", Color.WHITE, 20, 20);
        inputLabel1.setBounds(50, 50, 300, 40); // Increased width to match text field
        inputLabel1.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel1.setForeground(customColor);

        textField1 = new RoundedField(1);
        textField1.setBounds(370, 50, 300, 40); // Placed next to label


        // Labels and text fields for input (6 pairs)
        RoundedLabel inputLabel2 = new RoundedLabel("Peak Meter Reading", Color.WHITE, 20, 20);
        inputLabel2.setBounds(50, 100, 300, 40); // Increased width to match text field
        inputLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel2.setForeground(customColor);

        textField2 = new RoundedField(1);
        textField2.setBounds(370, 100, 300, 40); // Placed next to label



        RoundedLabel inputLabel4 = new RoundedLabel("Reading Entry Date(DD/MM/YYYY):", Color.WHITE, 20, 20);
        inputLabel4.setBounds(50, 150, 300, 40); // Increased width to match text field
        inputLabel4.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel4.setForeground(customColor);

        textField4 = new RoundedField(1);
        textField4.setBounds(370, 150, 300, 40); // Placed next to label

        RoundedLabel inputLabel5 = new RoundedLabel("Status(true/false)", Color.WHITE, 20, 20);
        inputLabel5.setBounds(50, 200, 300, 40); // Increased width to match text field
        inputLabel5.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel5.setForeground(customColor);

        textField5 = new RoundedField(1);
        textField5.setBounds(370, 200, 300, 40); // Placed next to label
        // Submit button
        RoundedButton submitButton = new RoundedButton("Submit");
        submitButton.setBounds(470, 250, 100, 40);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                getPeakUnits();
                getRegUnits();
                getStatus();
                getDate();
                isSubmitted();
                isSubmitted=true;
                JOptionPane.showMessageDialog(null, "Submitted: ");

            }
        });
        submitButton.setBackground(customColor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Impact", Font.PLAIN, 16));

        // Back button
        RoundedButton backButton = new RoundedButton("Back");
        backButton.setBounds(50, 250, 100, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new EmployeeOperation3(); // Assuming 'custDesktop' is the main page
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
        pt1.add(inputLabel4);
        pt1.add(textField4);
        pt1.add(inputLabel5);
        pt1.add(textField5);
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
        new EmployeeOperation3_2b();
    }

    public int getRegUnits()
    {
        int regUnits=Integer.parseInt(textField1.getText());
        return regUnits;
    }
    public int getPeakUnits()
    {
        int peakUnits=Integer.parseInt(textField2.getText());
        return peakUnits;
    }
    public String getDate()
    {
        //int units=Integer.parseInt(textField1.getText());
        return textField4.getText();
    }
    public boolean getStatus()
    {
        boolean status=Boolean.parseBoolean(textField5.getText());
        return status;
    }
    public boolean isSubmitted() {
        return isSubmitted;
    }


}
