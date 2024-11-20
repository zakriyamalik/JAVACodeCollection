package View;

import Controller.VendorManagementController;
import View.CustomerElements.RoundedButton;
import View.CustomerElements.RoundedField;
import View.CustomerElements.RoundedLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class UpdateVendorView extends JFrame {

    private RoundedField vendorIDField, nameField, contactPersonField, phoneField, addressField, cityField,
            stateProvinceField, countryField;
    VendorManagementController vendorManagementController=new VendorManagementController();

    public UpdateVendorView(int vendorID, String name, String contactPerson, String phone, String email,
                            String address, String city, String stateProvince, String country) {
        // Frame setup
        setTitle("Update Vendor - METRO POS");
        setBounds(20, 20, 800, 1100); // Adjust height for additional fields
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("Update Vendor");
        titleLabel.setBounds(0, 30, 800, 40);
        titleLabel.setFont(new Font("Impact", Font.PLAIN, 24));
        Color customColor = new Color(121, 87, 87);
        titleLabel.setForeground(customColor);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Background image
        ImageIcon bk = new ImageIcon("src/resources/bulb.jpg");
        Image scaledImage = bk.getImage().getScaledInstance(800, 1100, Image.SCALE_SMOOTH); // Adjust size for added fields
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, 800, 1100);

        // Rounded panel setup
        JPanel formPanel = new JPanel() {
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
        formPanel.setLayout(null);
        formPanel.setBounds(100, 100, 600, 900); // Adjust for additional fields
        formPanel.setOpaque(false);

        // Vendor ID label and field
        RoundedLabel vendorIDLabel = new RoundedLabel("Vendor ID", Color.WHITE, 20, 20);
        vendorIDLabel.setBounds(50, 100, 200, 40);
        vendorIDLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        vendorIDLabel.setForeground(customColor);

        vendorIDField = new RoundedField(20);
        vendorIDField.setBounds(295, 100, 300, 40);
        vendorIDField.setText(String.valueOf(vendorID));  // Set vendorID field with the provided value
        vendorIDField.setEditable(false);

        // Vendor Name label and field
        RoundedLabel nameLabel = new RoundedLabel("Name", Color.WHITE, 20, 20);
        nameLabel.setBounds(50, 150, 200, 40);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        nameLabel.setForeground(customColor);

        nameField = new RoundedField(20);
        nameField.setBounds(295, 150, 300, 40);
        nameField.setText(name);  // Set name field with the provided value

        // Contact Person label and field
        RoundedLabel contactPersonLabel = new RoundedLabel("Contact Person", Color.WHITE, 20, 20);
        contactPersonLabel.setBounds(50, 200, 200, 40);
        contactPersonLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        contactPersonLabel.setForeground(customColor);

        contactPersonField = new RoundedField(20);
        contactPersonField.setBounds(295, 200, 300, 40);
        contactPersonField.setText(contactPerson);  // Set contactPerson field with the provided value

        // Phone label and field
        RoundedLabel phoneLabel = new RoundedLabel("Phone", Color.WHITE, 20, 20);
        phoneLabel.setBounds(50, 250, 200, 40);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        phoneLabel.setForeground(customColor);

        phoneField = new RoundedField(20);
        phoneField.setBounds(295, 250, 300, 40);
        phoneField.setText(phone);  // Set phone field with the provided value

        // Address label and field
        RoundedLabel addressLabel = new RoundedLabel("Address", Color.WHITE, 20, 20);
        addressLabel.setBounds(50, 300, 200, 40);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        addressLabel.setForeground(customColor);

        addressField = new RoundedField(20);
        addressField.setBounds(295, 300, 300, 40);
        addressField.setText(address);  // Set address field with the provided value

        // City label and field
        RoundedLabel cityLabel = new RoundedLabel("City", Color.WHITE, 20, 20);
        cityLabel.setBounds(50, 350, 200, 40);
        cityLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        cityLabel.setForeground(customColor);

        cityField = new RoundedField(20);
        cityField.setBounds(295, 350, 300, 40);
        cityField.setText(city);  // Set city field with the provided value

        // State/Province label and field
        RoundedLabel stateProvinceLabel = new RoundedLabel("State/Province", Color.WHITE, 20, 20);
        stateProvinceLabel.setBounds(50, 400, 200, 40);
        stateProvinceLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        stateProvinceLabel.setForeground(customColor);

        stateProvinceField = new RoundedField(20);
        stateProvinceField.setBounds(295, 400, 300, 40);
        stateProvinceField.setText(stateProvince);  // Set state/province field with the provided value

        // Country label and field
        RoundedLabel countryLabel = new RoundedLabel("Country", Color.WHITE, 20, 20);
        countryLabel.setBounds(50, 450, 200, 40);
        countryLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        countryLabel.setForeground(customColor);

        countryField = new RoundedField(20);
        countryField.setBounds(295, 450, 300, 40);
        countryField.setText(country);  // Set country field with the provided value

        // Update button
        RoundedButton updateButton = new RoundedButton("Update");
        updateButton.setBounds(470, 500, 110, 35);
        updateButton.addActionListener(e -> {
            handleUpdate(
                    vendorIDField.getText(),
                    nameField.getText(),
                    contactPersonField.getText(),
                    phoneField.getText(),
                    "example@example.com", // Update email as needed
                    addressField.getText(),
                    cityField.getText(),
                    stateProvinceField.getText(),
                    countryField.getText()
            );
        });
        updateButton.setBackground(customColor);
        updateButton.setForeground(Color.WHITE);

        // Add components to the form panel
        formPanel.add(vendorIDLabel);
        formPanel.add(vendorIDField);
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(contactPersonLabel);
        formPanel.add(contactPersonField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        formPanel.add(addressLabel);
        formPanel.add(addressField);
        formPanel.add(cityLabel);
        formPanel.add(cityField);
        formPanel.add(stateProvinceLabel);
        formPanel.add(stateProvinceField);
        formPanel.add(countryLabel);
        formPanel.add(countryField);
        formPanel.add(updateButton);

        // Add panels to the main panel
        mainPanel.add(titleLabel);
        mainPanel.add(formPanel);
        mainPanel.add(backgroundLabel);

        add(mainPanel);
        setVisible(true);
    }
    public void handleUpdate(String vendorID, String name, String contactPerson, String phone, String email,
                             String address, String city, String stateProvince, String country) {
        // Example: Show a message dialog for now (you can replace this with actual update logic)
        if(vendorManagementController.redirect_Update_Vendors(vendorID, name, contactPerson, phone, email, address, city, stateProvince, country)) {
            dispose();
            JOptionPane.showMessageDialog(this, "Vendor updated successfully!");
        }
        else
        {
            dispose();
            JOptionPane.showMessageDialog(this, "Vendor not updated!");
        }
    }


    public static void main(String[] args) {
      //  new UpdateVendorView();
    }
}
