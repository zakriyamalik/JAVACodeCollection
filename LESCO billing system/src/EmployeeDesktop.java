import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.text.ParseException;

public class EmployeeDesktop extends JFrame {
    TeriffInfo tf=new TeriffInfo();
    EmployeeOperations em=new EmployeeOperations();
    public EmployeeDesktop() {
        // Setup second frame
        setTitle("Desktop Page");
        setBounds(20, 20, 1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Header Panel
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
        headerPanel.setBounds(0, 0, 1400, 50); // Full width header
        headerPanel.setBackground(new Color(20, 33, 61)); // Customize background color
        //  JLabel headerTitle = new JLabel("Dashboard");
        // headerTitle.setFont(new Font("Impact", Font.PLAIN, 30));
        //  headerTitle.setForeground(Color.WHITE);
        //  headerPanel.add(headerTitle);

        JLabel headerlabel0 = new JLabel("Desktop");
        JLabel headerlabel1=new JLabel("Search");
        JLabel headerlabel2=new JLabel("About Us");
        JLabel headerlabel3=new JLabel("Log out");
        headerlabel1.setFont(new Font("Impact", Font.PLAIN, 24));
        headerlabel2.setFont(new Font("Impact", Font.PLAIN, 24));
        headerlabel3.setFont(new Font("Impact", Font.PLAIN, 24));

        headerlabel0.setBounds(0, 30, 1200, 40); // Centered title
        headerlabel0.setFont(new Font("Impact", Font.PLAIN, 24));
        Color customColor = new Color(121, 87, 87); // RGB for #795757
        headerlabel0.setForeground(customColor); // Set font color
        headerlabel1.setForeground(customColor);
        headerlabel2.setForeground(customColor);
        headerlabel3.setForeground(customColor);



        // Load and scale the icon image
        ImageIcon originalIcon = new ImageIcon("src/resources/bulb-icon.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        headerlabel0.setIcon(scaledIcon);
        headerlabel0.setHorizontalTextPosition(SwingConstants.RIGHT);
        headerlabel0.setHorizontalAlignment(SwingConstants.CENTER);


        // Set background
        ImageIcon bk = new ImageIcon("src/resources/bulb.jpg");
        Image scaledImage2 = bk.getImage().getScaledInstance(1400, 700, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel backgroundLabel = new JLabel(scaledIcon2);
        backgroundLabel.setBounds(0, 0, 1400, 700);









// Create rounded panel with GridLayout to organize 3 cards per row
        JPanel pt1 = new JPanel(new GridLayout(0, 3, 30, 30)) { // 3 columns, dynamic row count
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

        pt1.setBackground(new Color(250, 247, 240));
        pt1.setBounds(0, 50, 1360, 600); // Adjust panel size as needed
        pt1.setBorder(new LineBorder(Color.WHITE, 16)); // Black border with thickness of 2 pixels

// Common properties for labels
        Font labelFont = new Font("Arial", Font.PLAIN, 18); // Further reduced font size
        Color textColor = customColor; // Set your custom color

// Create individual action labels (smaller dimensions)

// Employee Details
        RoundedLabel changePassword = new RoundedLabel("Click Here!",  new Color(34, 34, 59), 20, 20);
        changePassword.setPreferredSize(new Dimension(150, 75)); // Reduced size
        changePassword.setFont(labelFont);
        changePassword.setForeground(textColor);
        pt1.add(changePassword);

        RoundedLabel titleLabel1_1 = new RoundedLabel("Change Password",  new Color(34, 34, 59), 50, 50);
        titleLabel1_1.setBounds(4,0,390,40);
        titleLabel1_1.setFont(new Font("Impact", Font.PLAIN, 24));
        titleLabel1_1.setForeground(customColor);
        changePassword.add(titleLabel1_1);

        changePassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new EmployeeOperation1();
            }
        });



// Update Address
        RoundedLabel updateTerrifLabel = new RoundedLabel("Click Here!",  new Color(34, 34, 59), 20, 20);
        updateTerrifLabel.setPreferredSize(new Dimension(150, 75)); // Reduced size
        updateTerrifLabel.setFont(labelFont);
        updateTerrifLabel.setForeground(textColor);
        pt1.add(updateTerrifLabel);



        RoundedLabel titleLabel2_1 = new RoundedLabel("Update Tariff Info",  new Color(34, 34, 59), 50, 50);
        titleLabel2_1.setBounds(4,0,390,40);
        titleLabel2_1.setFont(new Font("Impact", Font.PLAIN, 24));
        titleLabel2_1.setForeground(customColor);
        updateTerrifLabel.add(titleLabel2_1);


        updateTerrifLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new EmployeeOperation2();
            }
        });


// Update Contact
        RoundedLabel meterOperations = new RoundedLabel("Click Here!",  new Color(34, 34, 59), 20, 20);
        meterOperations.setPreferredSize(new Dimension(150, 75)); // Reduced size
        meterOperations.setFont(labelFont);
        meterOperations.setForeground(textColor);
        pt1.add(meterOperations);
        RoundedLabel titleLabel3_1 = new RoundedLabel("Meter Operations",  new Color(34, 34, 59), 50, 50);
        titleLabel3_1.setBounds(4,0,390,40);
        titleLabel3_1.setFont(new Font("Impact", Font.PLAIN, 24));
        titleLabel3_1.setForeground(customColor);
        meterOperations.add(titleLabel3_1);

        meterOperations.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new EmployeeOperation3();
            }
        });


// View Timesheet
        RoundedLabel viewTimesheetLabel = new RoundedLabel("Click Here!",  new Color(34, 34, 59), 20, 20);
        viewTimesheetLabel.setPreferredSize(new Dimension(150, 75)); // Reduced size
        viewTimesheetLabel.setFont(labelFont);
        viewTimesheetLabel.setForeground(textColor);
        pt1.add(viewTimesheetLabel);
        RoundedLabel titleLabel4_1 = new RoundedLabel("View Paid/Unpaid Bills",  new Color(34, 34, 59), 50, 50);
        titleLabel4_1.setBounds(4,0,390,40);
        titleLabel4_1.setFont(new Font("Impact", Font.PLAIN, 24));
        titleLabel4_1.setForeground(customColor);
        viewTimesheetLabel.add(titleLabel4_1);
        viewTimesheetLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                em.paidUnpaidreport();
            }
        });


// Assign Tasks
        RoundedLabel assignTasksLabel = new RoundedLabel("Click Here!",  new Color(34, 34, 59), 20, 20);
        assignTasksLabel.setPreferredSize(new Dimension(150, 75)); // Reduced size
        assignTasksLabel.setFont(labelFont);
        assignTasksLabel.setForeground(textColor);
        pt1.add(assignTasksLabel);
        RoundedLabel titleLabel5_1 = new RoundedLabel("View Expiring CNIC",  new Color(34, 34, 59), 50, 50);
        titleLabel5_1.setBounds(4,0,390,40);
        titleLabel5_1.setFont(new Font("Impact", Font.PLAIN, 24));
        titleLabel5_1.setForeground(customColor);
        assignTasksLabel.add(titleLabel5_1);
        assignTasksLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    em.viewExpiringCNIC();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


// Manage Leave
        RoundedLabel resetTerrifLabel = new RoundedLabel("Click Here!",  new Color(34, 34, 59), 20, 20);
        resetTerrifLabel.setPreferredSize(new Dimension(150, 75)); // Reduced size
        resetTerrifLabel.setFont(labelFont);
        resetTerrifLabel.setForeground(textColor);
        pt1.add(resetTerrifLabel);
        RoundedLabel titleLabel7_1 = new RoundedLabel("Reset Terrif data",  new Color(34, 34, 59), 50, 50);
        titleLabel7_1.setBounds(4,0,390,40);
        titleLabel7_1.setFont(new Font("Impact", Font.PLAIN, 24));
        titleLabel7_1.setForeground(customColor);
        resetTerrifLabel.add(titleLabel7_1);
        resetTerrifLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    TeriffInfo.TariffTaxSystem("TariffTaxInfo.txt");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Terrif is been reset");
            }
        });


// Generate Payroll
        RoundedLabel viewParticularBill = new RoundedLabel("Click Here!",  new Color(34, 34, 59), 20, 20);
        viewParticularBill.setPreferredSize(new Dimension(150, 75)); // Reduced size
        viewParticularBill.setFont(labelFont);
        viewParticularBill.setForeground(textColor);
        pt1.add(viewParticularBill);
        RoundedLabel titleLabel8_1 = new RoundedLabel("View any particular Bill",  new Color(34, 34, 59), 50, 50);
        titleLabel8_1.setBounds(4,0,390,40);
        titleLabel8_1.setFont(new Font("Impact", Font.PLAIN, 24));
        titleLabel8_1.setForeground(customColor);
        viewParticularBill.add(titleLabel8_1);

        viewParticularBill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new ViewIndividualBill();
            }
        });

// Request Assistance
        RoundedLabel addEmployeeLabel = new RoundedLabel("Click Here!",  new Color(34, 34, 59), 20, 20);
        addEmployeeLabel.setPreferredSize(new Dimension(150, 75)); // Reduced size
        addEmployeeLabel.setFont(labelFont);
        addEmployeeLabel.setForeground(textColor);
        pt1.add(addEmployeeLabel);
        RoundedLabel titleLabel9_1 = new RoundedLabel("Add Employee",  new Color(34, 34, 59), 50, 50);
        titleLabel9_1.setBounds(4,0,390,40);
        titleLabel9_1.setFont(new Font("Impact", Font.PLAIN, 24));
        titleLabel9_1.setForeground(customColor);
        addEmployeeLabel.add(titleLabel9_1);

        addEmployeeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new EmployeeOperation8();

            }
        });

// Submit Feedback
        RoundedLabel submitFeedbackLabel = new RoundedLabel("Click Here!",  new Color(34, 34, 59), 20, 20);
        submitFeedbackLabel.setPreferredSize(new Dimension(150, 75)); // Reduced size
        submitFeedbackLabel.setFont(labelFont);
        submitFeedbackLabel.setForeground(textColor);
        pt1.add(submitFeedbackLabel);
        RoundedLabel titleLabel10_1 = new RoundedLabel("Show All Bills",  new Color(34, 34, 59), 50, 50);
        titleLabel10_1.setBounds(4,0,390,40);
        titleLabel10_1.setFont(new Font("Impact", Font.PLAIN, 24));
        titleLabel10_1.setForeground(customColor);
        submitFeedbackLabel.add(titleLabel10_1);











        // Back button
        RoundedButton openFirstPageButton = new RoundedButton("Back");
        openFirstPageButton.setBounds(0, 0, 110, 40);
        openFirstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main();
            }
        });
        openFirstPageButton.setBackground(customColor);
        openFirstPageButton.setForeground(Color.white);


        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBounds(0, 650, 1400, 50); // Full width footer at the bottom
        footerPanel.setBackground(new Color(20, 33, 61)); // Footer background color
        JLabel footerLabel = new JLabel("Footer Section © 2024");
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        footerPanel.add(openFirstPageButton);

        // Add components to panels
        //mainPanel.add(openFirstPageButton);

        // Add components to the main panel
        mainPanel.add(headerPanel); // Add header
        headerPanel.add(headerlabel0);
        headerPanel.add(headerlabel1);
        headerPanel.add(headerlabel2);
        headerPanel.add(headerlabel3);

        mainPanel.add(pt1); // Add rounded panel
        mainPanel.add(footerPanel); // Add footer
        mainPanel.add(backgroundLabel); // Full background

        // Revalidate and repaint to ensure proper component visibility
        mainPanel.revalidate();
        mainPanel.repaint();

        // Add main panel to the frame
        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeDesktop();
    }
}
