import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.Objects;

public class EmployeeOperation2 extends JFrame {
    TeriffInfo tf=new TeriffInfo();
    public EmployeeOperation2() {
        // Setup second frame
        setTitle("Terrif Update");
        setBounds(20, 10, 900, 800); // Increased width of the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Terrif Update");
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

        // ComboBox for "Meter type"
        RoundedLabel inputLabel1 = new RoundedLabel("Meter type:", Color.WHITE, 20, 20);
        inputLabel1.setBounds(50, 50, 300, 40); // Increased width to match dropdown
        inputLabel1.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel1.setForeground(customColor);

        // ComboBox options for "Meter type"
        String[] meterTypeOptions = {"1-phase", "3-phase"};
        JComboBox<String> meterTypeComboBox = new JComboBox<>(meterTypeOptions);
        meterTypeComboBox.setBounds(370, 50, 300, 40);
        meterTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font for ComboBox
        meterTypeComboBox.setForeground(customColor);

        // ComboBox for "Customer Type"
        RoundedLabel inputLabel2 = new RoundedLabel("Customer Type:", Color.WHITE, 20, 20);
        inputLabel2.setBounds(50, 120, 300, 40); // Increased width to match dropdown
        inputLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel2.setForeground(customColor);

        // ComboBox options for "Customer Type"
        String[] customerTypeOptions = {"Domestic", "Commercial"};
        JComboBox<String> customerTypeComboBox = new JComboBox<>(customerTypeOptions);
        customerTypeComboBox.setBounds(370, 120, 300, 40);
        customerTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font for ComboBox
        customerTypeComboBox.setForeground(customColor);

        // Data type label and ComboBox
        RoundedLabel inputLabel3 = new RoundedLabel("Data Type:", Color.WHITE, 20, 20);
        inputLabel3.setBounds(50, 190, 300, 40); // Increased width to match dropdown
        inputLabel3.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel3.setForeground(customColor);

        String[] options = {"Peak Units","Regular Units", "Tax Percentage", "Fixed Charges"};
        JComboBox<String> dropdownMenu = new JComboBox<>(options);
        dropdownMenu.setBounds(370, 190, 300, 40); // Placed next to label
        dropdownMenu.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font for dropdown
        dropdownMenu.setForeground(customColor);

        // "No of Units" label and text field
        RoundedLabel inputLabel4 = new RoundedLabel("Data:", Color.WHITE, 20, 20);
        inputLabel4.setBounds(50, 260, 300, 40); // Increased width to match text field
        inputLabel4.setFont(new Font("Arial", Font.PLAIN, 24));
        inputLabel4.setForeground(customColor);

        RoundedField textField4 = new RoundedField(1);
        textField4.setBounds(370, 260, 300, 40); // Placed next to label

        // Submit button
        RoundedButton submitButton = new RoundedButton("Submit");
        submitButton.setBounds(170, 500, 100, 40);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int regularUnits=0;
                int peakUnits=0;
                float taxPercentage=0;
                int fixedCharges=0;
                String meterType = (String) meterTypeComboBox.getSelectedItem();
                String customerType = (String) customerTypeComboBox.getSelectedItem();
                String dataType= (String) dropdownMenu.getSelectedItem();
                String data=textField4.getText();
                if(Objects.equals(dataType, "Regular Units"))
                {
                    regularUnits=Integer.parseInt(data);
                    peakUnits=-1;
                    taxPercentage=-1;
                    fixedCharges=-1;


                } else if (Objects.equals(dataType, "Peak Units")) {
                    peakUnits= Integer.parseInt(data);
                    regularUnits=-1;
                    taxPercentage=-1;
                    fixedCharges=-1;
                } else if (Objects.equals(dataType, "Tax Percentage")) {
                    taxPercentage=Float.parseFloat(data);
                    peakUnits=-1;
                    regularUnits=-1;
                    fixedCharges=-1;
                } else if (Objects.equals(dataType, "Fixed Charges")) {
                    fixedCharges=Integer.parseInt(data);
                    peakUnits=-1;
                    taxPercentage=-1;
                    regularUnits=-1;
                }
                else
                {

                }
                System.out.println( meterType+" "+ customerType+" "+regularUnits+" "+peakUnits+" "+ taxPercentage+" "+fixedCharges);
                try {
                    tf.processData(meterType,customerType,regularUnits,peakUnits,taxPercentage,fixedCharges);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                // JOptionPane.showMessageDialog(null, "Submitted: Meter Type - " + meterType + ", Customer Type - " + customerType);
            }
        });
        submitButton.setBackground(customColor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Impact", Font.PLAIN, 16));

        // Back button
        RoundedButton backButton = new RoundedButton("Back");
        backButton.setBounds(50, 500, 100, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new EmployeeDesktop(); // Assuming 'custDesktop' is the main page
            }
        });
        backButton.setBackground(customColor);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Impact", Font.PLAIN, 16));

        // Add components to panels
        pt1.add(inputLabel1);
        pt1.add(meterTypeComboBox); // Added ComboBox
        pt1.add(inputLabel2);
        pt1.add(customerTypeComboBox); // Added ComboBox
        pt1.add(inputLabel3);
        pt1.add(dropdownMenu); // Added dropdown menu
        pt1.add(inputLabel4);
        pt1.add(textField4);
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
        new EmployeeOperation2();
    }
}