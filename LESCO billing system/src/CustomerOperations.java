import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerOperations {
    private int Name;
    private int cusType;
    private int regularUnits;
    private int peakUnits;
    private String customerType;
    MeterOperations mt=new MeterOperations(null);

    public int getName() {
        return Name;
    }

    public void setName(int name) {
        Name = name;
    }

    public int getCusType() {
        return cusType;
    }

    public void setCusType(int cusType) {
        this.cusType = cusType;
    }

    public int getRegularUnits() {
        return regularUnits;
    }

    public void setRegularUnits(int regularUnits) {
        this.regularUnits = regularUnits;
    }

    public int getPeakUnits() {
        return peakUnits;
    }

    public void setPeakUnits(int peakUnits) {
        this.peakUnits = peakUnits;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public MeterOperations getMt() {
        return mt;
    }

    public void setMt(MeterOperations mt) {
        this.mt = mt;
    }

    CustomerOperations(MeterOperations mt)
    {

    }

    public void showAllCustomers() throws FileNotFoundException {
        String fileName = "CustomerInfo.txt";
        String line = "";
        ArrayList<String[]> dataList = new ArrayList<>();
        File inputFile = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            // Reading data from file and adding to dataList
            dataList = readFile(fileName, dataList, line);

            // Create a frame for the table
            JFrame frame = new JFrame("Customer Information");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800, 400);

            // Column names
            String[] columnNames = {"ID", "CNIC", "Address", "Phone no", "Customer Type", "Meter Type", "Date", "Regular Units", "Peak Units", "Update", "Delete", "Save"};

            // Create 2D array for table data
            String[][] tableData = new String[dataList.size()][columnNames.length];

            // Fill the table data by splitting each line
            for (int i = 0; i < dataList.size(); i++) {
                String[] rowData = dataList.get(i);
                int numberOfColumnsToCopy = Math.min(rowData.length, columnNames.length - 3);
                System.arraycopy(rowData, 0, tableData[i], 0, numberOfColumnsToCopy);
                tableData[i][9] = "Update"; // Update button column
                tableData[i][10] = "Delete"; // Delete button column
                tableData[i][11] = "Save";   // Save button column
            }

            // Create a table model with the extracted data and column names
            DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);
            JTable table = new JTable(tableModel);

            // Set preferred size for the table
            table.setPreferredScrollableViewportSize(new Dimension(750, 300));
            table.setFillsViewportHeight(true);

            // Make the table cells editable only when "Update" is clicked
            table.setDefaultEditor(Object.class, null); // Disable default editing for all cells

            // Add update button functionality
            table.getColumn("Update").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
                @Override
                public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                    JButton updateButton = new JButton("Update");

                    updateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Update clicked for row: " + row);

                            // Enable editing for the entire row
                            for (int col = 0; col < 9; col++) {
                                table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(new JTextField()));
                            }

                            // Show the Save button after enabling editing
                            tableModel.setValueAt("Save", row, 11);
                        }
                    });
                    return updateButton;
                }
            });

            // Add delete button functionality
            ArrayList<String[]> finalDataList = dataList;
            table.getColumn("Delete").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
                @Override
                public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                    JButton deleteButton = new JButton("Delete");

                    deleteButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Delete clicked for row: " + row);

                            // Remove the row from dataList and the table
                            finalDataList.remove(row);
                            tableModel.removeRow(row);

                            // Write updated data to the temporary file
                            writeDataListToTempFile(finalDataList);
                        }
                    });
                    return deleteButton;
                }
            });

            // Add save button functionality
            ArrayList<String[]> finalDataList1 = dataList;
            table.getColumn("Save").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
                @Override
                public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                    JButton saveButton = new JButton("Save");

                    saveButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // After editing, save the data to dataList
                            for (int col = 0; col < 9; col++) {
                                finalDataList1.get(row)[col] = tableModel.getValueAt(row, col).toString();
                            }

                            System.out.println("Saved changes for row: " + row);

                            // Write updated data to the temporary file
                            writeDataListToTempFile(finalDataList1);

                            // Make the row non-editable again after saving
                            table.setDefaultEditor(Object.class, null);
                        }
                    });
                    return saveButton;
                }
            });

            // Add table to a scroll pane
            JScrollPane scrollPane = new JScrollPane(table);

            // Add the scroll pane to the frame and display it
            frame.add(scrollPane);
            frame.setVisible(true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private static void writeDataListToTempFile(ArrayList<String[]> dataList) {
        try {
            // Create a temporary file
            File tempFile = new File("CustomerInfo.txt");

            // Write dataList to the file
            FileWriter writer = new FileWriter(tempFile, false);
            for (String[] data : dataList) {
                writer.write(String.join(",", data) + "\n");
            }

            // Close the writer
            writer.close();

            // Print the path of the temp file
            System.out.println("Data written to temp file: " + tempFile.getAbsolutePath());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private ArrayList<String[]> readFile(String fileName, ArrayList<String[]> dataList, String line) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                dataList.add(line.split(","));
            }
        }
        return dataList;
    }
    public int changePassword(String name,String oldPassword,String newPassword) throws IOException {

        String fileName="EmployeesData.txt";
        System.out.println("In changePassword function\n");


        File inputFile = new File(fileName);
        File tempFile = new File("temp_" + fileName);


        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                Scanner scanner1 = new Scanner(System.in)
        )
        {

//            String name = "";
//            String password = "";
//            String newPassword = "";
            String line;
            boolean userFound = false;


//            System.out.println("Enter the userName of the Employee:");
//            name = scanner1.nextLine();
//            System.out.println("Enter the password of the Employee:");
//            oldPassword = scanner1.nextLine();


            while ((line = reader.readLine()) != null) {


                String[] userData = line.split(",", 2);


                if (userData.length == 2 && name.equals(userData[0])) {
                    if (oldPassword.equals(userData[1])) {
//                        System.out.println("Enter New Password of the Employee:");
//                        newPassword = scanner1.nextLine();

                        line = name + "," + newPassword;
                        System.out.println(line);
                        userFound = true;
                    }
                }


                writer.write(line + System.lineSeparator());


            }

            if (!userFound) {
                System.out.println("User not found or old password incorrect.");
                JOptionPane.showMessageDialog(null, "User not found or old password incorrect.");
            }
            else {
                System.out.println("Password updated successfully.");
                JOptionPane.showMessageDialog(null, "Password updated successfully.");

            }


        }


        if (!inputFile.delete()) {
            System.out.println("Could not delete the original file.");
            return 1;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename the temporary file.");
            return 1;
        }


        return 0;


    }

    public boolean checkUserName( String fileName,String name) throws FileNotFoundException {


        String line="";
        char character='\u0000';
        String []userName;


        File file = new File(fileName);
        Scanner scanner = new Scanner(file);


        // Iterate over each line in the file
        while (scanner.hasNextLine()) {


            line = scanner.nextLine();
            // System.out.println("Line: " + line);
            userName=line.split(",",2);


            if(name.equals(userName[0])) {
                System.out.println("\nIn If statement Name:"+name+" userName: "+userName[0]+"\n");
                return false;
            }
            else
            {
                System.out.println("\nIn Else statement Name:"+name+" userName: "+userName[0]+"\n");
                continue;
            }

//            // Iterate over each character in the line
//            for (int index = 0; index < line.length(); index++) {
//                 character = line.charAt(index);
//                if(character==',')
//                {
//                    break;
//                }
//                System.out.println("Index " + index + ": " + character);
//            }
//
//            System.out.println();  // New line for clarity after each row
        }

        scanner.close();
        return true;
    }


    public int generateCustomerId()
    {

        Random random = new Random();
        // Generate a number between 1000 and 9999 (inclusive)
        return 1000 + random.nextInt(9000);

    }


    public int customerInfo(String cnic,String address,long phoneNo,String cusType,String meterType) throws FileNotFoundException {

        String fileName="CustomerInfo.txt";
        int id=generateCustomerId();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String formattedDate = currentDate.format(formatter);
        int choice=0;
        int regUnitConsumed=0;
        int peakUnitConsumed=0;
        String userInput = "";

        Scanner scanner = new Scanner(System.in);

        FileOperations.checkCnic(cnic);
        while (!FileOperations.checkCnic(cnic))
        {
            System.out.println("Invalid CNIC\n");
            System.out.println("Enter 13-digit number without dashes:\n");
            cnic=scanner.nextLine();
        }



        try {


            FileWriter myWriter = new FileWriter(fileName, true);
            if(Objects.equals(meterType, "3-phase"))
            {
                System.out.println("Enter Regular Units Consumed:\n");
                regUnitConsumed=scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Peak Units Consumed:\n");
                peakUnitConsumed=scanner.nextInt();
                scanner.nextLine();
                System.out.println(id + "," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed+"\n");
                myWriter.write(id + "," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed + System.lineSeparator());
                mt.nadOperation(cnic);
            }
            else
            {

                peakUnitConsumed=-1;
                System.out.println(id + "," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed+"\n");
                myWriter.write(id +"," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed + System.lineSeparator());
                mt.nadOperation(cnic);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            showAllCustomers();

        }

        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return 0;
    }
    public boolean validateCustomerLogin(String customerId, String customerCNIC) {
        String filePath = "CustomerInfo.txt";  // Replace with the correct file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] customerData = line.split(",");

                if (customerData.length >= 2) {
                    String fileId = customerData[0].trim();
                    String fileCnic = customerData[1].trim();

                    if (fileId.equals(customerId) && fileCnic.equals(customerCNIC)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

public static void main(String[] args) throws FileNotFoundException {
        CustomerOperations cs=new CustomerOperations(null);
        cs.showAllCustomers();


}

}


