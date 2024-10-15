import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

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

    void showAllCustomers() throws FileNotFoundException {
        String fileName = "CustomerInfo.txt";
        String line = "";
        ArrayList<String> dataList = new ArrayList<>();

        File inputFile = new File(fileName);

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile))
        ) {
            // Reading data from file and adding to dataList
            dataList = mt.readFile(fileName, dataList, line);

            // Create a frame for the table
            JFrame frame = new JFrame("Customer Information");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800, 400);

            // Updated column names with "Name" before "CNIC"
            String[] columnNames = {"ID", "Name", "CNIC", "Address", "Phone no", "Customer Type", "Meter Type","Date", "Regular Units","Peak Units"};

            // Create 2D array for table data
            String[][] tableData = new String[dataList.size()][columnNames.length];

            // Fill the table data by splitting each line
            for (int i = 0; i < dataList.size(); i++) {
                String[] rowData = dataList.get(i).split(",");
                int numberOfColumnsToCopy = Math.min(rowData.length, columnNames.length);
                System.arraycopy(rowData, 0, tableData[i], 0, numberOfColumnsToCopy);
            }

            // Create a table model with the extracted data and column names
            DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);
            JTable table = new JTable(tableModel);
            table.setPreferredScrollableViewportSize(table.getPreferredSize());
            table.setFillsViewportHeight(true);

            // Add table to a scroll pane
            JScrollPane scrollPane = new JScrollPane(table);

            // Add the scroll pane to the frame and display it
            frame.add(scrollPane);
            frame.setVisible(true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public int changePassword(String fileName) throws IOException {


        System.out.println("In changePassword function\n");


        File inputFile = new File(fileName);
        File tempFile = new File("temp_" + fileName);


        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                Scanner scanner1 = new Scanner(System.in)
        )
        {

            String name = "";
            String password = "";
            String newPassword = "";
            String line;
            boolean userFound = false;


            System.out.println("Enter the userName of the Employee:");
            name = scanner1.nextLine();
            System.out.println("Enter the password of the Employee:");
            password = scanner1.nextLine();


            while ((line = reader.readLine()) != null) {


                String[] userData = line.split(",", 2);


                if (userData.length == 2 && name.equals(userData[0])) {
                    if (password.equals(userData[1])) {
                        System.out.println("Enter New password of the Employee:");
                        newPassword = scanner1.nextLine();
                        line = name + "," + newPassword;
                        userFound = true;
                    }
                }


                writer.write(line + System.lineSeparator());


            }

            if (!userFound) {
                System.out.println("User not found or old password incorrect.");
            } else {
                System.out.println("Password updated successfully.");
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


    public int customerInfo(String cnic,String address,long phoneNo,String name,String cusType,String meterType) throws FileNotFoundException {

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
                System.out.println(id + ","+name+"," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed+"\n");
                myWriter.write(id + ","+name+"," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed + System.lineSeparator());
                mt.nadOperation(cnic);
            }
            else
            {

                peakUnitConsumed=-1;
                System.out.println(id + ","+name+"," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed+"\n");
                myWriter.write(id + ","+name+"," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed + System.lineSeparator());
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



}
