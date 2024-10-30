import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
public class BillSummaryScreen extends JFrame {
    // Declare fields as instance variables
    private RoundedField field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11;

    public BillSummaryScreen() {
        // Setup frame
        setTitle("Employee Desktop");
        setBounds(20, 20, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("View Individual Bill");
        titleLabel.setBounds(0, 10, 800, 40); // Centered title
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
        pt1.setBounds(100, 50, 600, 640); // Adjusted size and position
        pt1.setOpaque(false);

        // Background for pt1
        ImageIcon bk1 = new ImageIcon("src/resources/Desktopbg.jpg");
        Image scaledImage1 = bk1.getImage().getScaledInstance(600, 640, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel backgroundLabel1 = new JLabel(scaledIcon1);
        backgroundLabel1.setBounds(0, 0, 600, 640);

        // Initialize and position rounded labels and fields
        RoundedLabel actionLabel1 = new RoundedLabel("ID", Color.WHITE, 20, 20);
        actionLabel1.setBounds(50, 50, 300, 40);
        actionLabel1.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel1.setForeground(customColor);
        field1 = new RoundedField(20);
        field1.setBounds(360, 50, 200, 40);

        RoundedLabel actionLabel2 = new RoundedLabel("CNIC", Color.WHITE, 20, 20);
        actionLabel2.setBounds(50, 100, 300, 40);
        actionLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel2.setForeground(customColor);
        field2 = new RoundedField(20);
        field2.setBounds(360, 100, 200, 40);

        RoundedLabel actionLabel3 = new RoundedLabel("Address", Color.WHITE, 20, 20);
        actionLabel3.setBounds(50, 150, 300, 40);
        actionLabel3.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel3.setForeground(customColor);
        field3 = new RoundedField(20);
        field3.setBounds(360, 150, 200, 40);

        RoundedLabel actionLabel4 = new RoundedLabel("User Type", Color.WHITE, 20, 20);
        actionLabel4.setBounds(50, 200, 300, 40);
        actionLabel4.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel4.setForeground(customColor);
        field4 = new RoundedField(20);
        field4.setBounds(360, 200, 200, 40);

        RoundedLabel actionLabel5 = new RoundedLabel("Meter Type", Color.WHITE, 20, 20);
        actionLabel5.setBounds(50, 250, 300, 40);
        actionLabel5.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel5.setForeground(customColor);
        field5 = new RoundedField(20);
        field5.setBounds(360, 250, 200, 40);

        RoundedLabel actionLabel6 = new RoundedLabel("Current Reading", Color.WHITE, 20, 20);
        actionLabel6.setBounds(50, 300, 300, 40);
        actionLabel6.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel6.setForeground(customColor);
        field6 = new RoundedField(20);
        field6.setBounds(360, 300, 200, 40);

        RoundedLabel actionLabel7 = new RoundedLabel("Electricity Cost", Color.WHITE, 20, 20);
        actionLabel7.setBounds(50, 350, 300, 40);
        actionLabel7.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel7.setForeground(customColor);
        field7 = new RoundedField(20);
        field7.setBounds(360, 350, 200, 40);

        RoundedLabel actionLabel8 = new RoundedLabel("Tax", Color.WHITE, 20, 20);
        actionLabel8.setBounds(50, 400, 300, 40);
        actionLabel8.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel8.setForeground(customColor);
        field8 = new RoundedField(20);
        field8.setBounds(360, 400, 200, 40);

        RoundedLabel actionLabel9 = new RoundedLabel("Fixed Charges", Color.WHITE, 20, 20);
        actionLabel9.setBounds(50, 450, 300, 40);
        actionLabel9.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel9.setForeground(customColor);
        field9 = new RoundedField(20);
        field9.setBounds(360, 450, 200, 40);

        RoundedLabel actionLabel10 = new RoundedLabel("Due Date", Color.WHITE, 20, 20);
        actionLabel10.setBounds(50, 500, 300, 40);
        actionLabel10.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel10.setForeground(customColor);
        field10 = new RoundedField(20);
        field10.setBounds(360, 500, 200, 40);

        RoundedLabel actionLabel11 = new RoundedLabel("Bill Status", Color.WHITE, 20, 20);
        actionLabel11.setBounds(50, 550, 300, 40);
        actionLabel11.setFont(new Font("Arial", Font.PLAIN, 24));
        actionLabel11.setForeground(customColor);
        field11 = new RoundedField(20);
        field11.setBounds(360, 550, 200, 40);

        // Back button
        RoundedButton backButton = new RoundedButton("Back");
        backButton.setBounds(490, 600, 110, 35);
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
        field1.setEditable(false);
        field2.setEditable(false);
        field3.setEditable(false);
        field4.setEditable(false);
        field5.setEditable(false);
        field6.setEditable(false);
        field7.setEditable(false);
        field8.setEditable(false);
        field9.setEditable(false);
        field10.setEditable(false);
        field11.setEditable(false);


        // Add components to pt1 panel
        pt1.add(actionLabel1);
        pt1.add(field1);
        pt1.add(actionLabel2);
        pt1.add(field2);
        pt1.add(actionLabel3);
        pt1.add(field3);
        pt1.add(actionLabel4);
        pt1.add(field4);
        pt1.add(actionLabel5);
        pt1.add(field5);
        pt1.add(actionLabel6);
        pt1.add(field6);
        pt1.add(actionLabel7);
        pt1.add(field7);
        pt1.add(actionLabel8);
        pt1.add(field8);
        pt1.add(actionLabel9);
        pt1.add(field9);
        pt1.add(actionLabel10);
        pt1.add(field10);
        pt1.add(actionLabel11);
        pt1.add(field11);
        pt1.add(backButton);
        pt1.add(backgroundLabel1);

        // Add components to the main panel
        mainPanel.add(titleLabel);
        mainPanel.add(pt1);
        mainPanel.add(backgroundLabel);

        mainPanel.revalidate();
        mainPanel.repaint();

        // Add main panel to the frame
        add(mainPanel);
        setVisible(true);
    }

    // Setter methods for each field
    public void setId(String id) { field1.setText(id); }
    public void setCnic(String cnic) { field2.setText(cnic); }
    public void setAddress(String address) { field3.setText(address); }
    public void setUserType(String userType) { field4.setText(userType); }
    public void setMeterType(String meterType) { field5.setText(meterType); }
    public void setCurrentReading(String currentReading) { field6.setText(currentReading); }
    public void setElectricityCost(String electricityCost) { field7.setText(electricityCost); }
    public void setTax(String tax) { field8.setText(tax); }
    public void setFixedCharges(String fixedCharges) { field9.setText(fixedCharges); }
    public void setDueDate(String dueDate) { field10.setText(dueDate); }
    public void setBillStatus(String billStatus) { field11.setText(billStatus); }

    public static void main(String[] args) {
        BillSummaryScreen billSummaryScreen = new BillSummaryScreen();
    }
}
