import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

public class EmployeeOperation3_2 extends JFrame {
    MeterOperations mt = new MeterOperations(null);
    private JComboBox<String> meterTypeDropdown;

    public EmployeeOperation3_2() {
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
        RoundedLabel inputLabel1 = new RoundedLabel("Customer ID:", Color.WHITE, 20, 20);
        inputLabel1.setBounds(50, 50, 200, 40); // Adjusted width
        inputLabel1.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel1.setForeground(customColor);

        RoundedField textField1 = new RoundedField(1);
        textField1.setBounds(270, 50, 300, 40); // Adjusted to match label

        RoundedLabel inputLabel2 = new RoundedLabel("Customer CNIC:", Color.WHITE, 20, 20);
        inputLabel2.setBounds(50, 120, 200, 40); // Adjusted width
        inputLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel2.setForeground(customColor);

        RoundedField textField2 = new RoundedField(1);
        textField2.setBounds(270, 120, 300, 40);

        String[] meterTypes = {"1-phase", "3-phase"};
        meterTypeDropdown = new JComboBox<>(meterTypes);
        meterTypeDropdown.setBounds(270, 170, 300, 40);
        meterTypeDropdown.setForeground(customColor);

        RoundedLabel MeterLabel = new RoundedLabel("Meter Type:", Color.WHITE, 20, 20);
        MeterLabel.setBounds(50, 170, 150, 40);
        MeterLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        MeterLabel.setForeground(customColor);

        // Label for peak units
        RoundedLabel peakUnitsLabel = new RoundedLabel("Peak Units:", Color.WHITE, 20, 20);
        peakUnitsLabel.setBounds(50, 220, 150, 40);
        peakUnitsLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        peakUnitsLabel.setForeground(customColor);

        // Text field to display peak units
        RoundedField peakUnitsField = new RoundedField(1);
        peakUnitsField.setBounds(270, 220, 300, 40);

        // Dropdown action listener to update peak units field
        meterTypeDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMeter = (String) meterTypeDropdown.getSelectedItem();
                if (selectedMeter.equals("1-phase meter")) {
                    peakUnitsField.setText("-1");
                    peakUnitsField.setEditable(false);
                } else {
                    peakUnitsField.setText("");
                    peakUnitsField.setEditable(true);
                }
            }
        });

        // Label for regular units
        RoundedLabel regularUnitsLabel = new RoundedLabel("Regular Units:", Color.WHITE, 20, 20);
        regularUnitsLabel.setBounds(50, 270, 200, 40);
        regularUnitsLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        regularUnitsLabel.setForeground(customColor);

        // Text field for regular units
        RoundedField regularUnitsField = new RoundedField(1);
        regularUnitsField.setBounds(270, 270, 300, 40);

        // Date label and field
        RoundedLabel dateLabel = new RoundedLabel("Date:", Color.WHITE, 20, 20);
        dateLabel.setBounds(50, 320, 200, 40);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        dateLabel.setForeground(customColor);

        RoundedField dateField = new RoundedField(1);
        dateField.setBounds(270, 320, 300, 40);

        // Status Date label and field
        RoundedLabel statusDateLabel = new RoundedLabel("Status :", Color.WHITE, 20, 20);
        statusDateLabel.setBounds(50, 370, 200, 40);
        statusDateLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        statusDateLabel.setForeground(customColor);

        RoundedField statusDateField = new RoundedField(1);
        statusDateField.setBounds(270, 370, 300, 40);

        // Submit button
        RoundedButton submitButton = new RoundedButton("Submit");
        submitButton.setBounds(470, 450, 100, 40);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ID = Integer.parseInt(textField1.getText());
                long CNIC = Long.parseLong(textField2.getText());
                String meterType = (String) meterTypeDropdown.getSelectedItem();
                int peakUnits = Integer.parseInt(peakUnitsField.getText());
                int regularUnits = Integer.parseInt(regularUnitsField.getText());
                String date = dateField.getText();
                boolean statusDate = Boolean.parseBoolean(statusDateField.getText());

                try {
                    mt.meterReading(ID,CNIC,meterType,peakUnits,regularUnits,date,statusDate);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(null,
                        "Submitted: \nID: " + ID +
                                "\nCNIC: " + CNIC +
                                "\nMeter Type: " + meterType +
                                "\nPeak Units: " + peakUnits +
                                "\nRegular Units: " + regularUnits +
                                "\nDate: " + date +
                                "\nStatus Date: " + statusDate);
            }
        });
        submitButton.setBackground(customColor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Impact", Font.PLAIN, 16));

        // Back button
        RoundedButton backButton = new RoundedButton("Back");
        backButton.setBounds(50, 450, 100, 40);
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

        // Add components to pt1
        pt1.add(inputLabel1);
        pt1.add(textField1);
        pt1.add(inputLabel2);
        pt1.add(textField2);
        pt1.add(MeterLabel);
        pt1.add(meterTypeDropdown);
        pt1.add(peakUnitsLabel);
        pt1.add(peakUnitsField);
        pt1.add(regularUnitsLabel);
        pt1.add(regularUnitsField);
        pt1.add(dateLabel);
        pt1.add(dateField);
        pt1.add(statusDateLabel);
        pt1.add(statusDateField);
        pt1.add(submitButton);
        pt1.add(backButton);
        pt1.add(backgroundLabel1);

        mainPanel.add(titleLabel);
        mainPanel.add(pt1);
        mainPanel.add(backgroundLabel);

        add(mainPanel);
        setVisible(true);
    }


public static void main(String[] args) {
        new EmployeeOperation3_2();
    }
}
