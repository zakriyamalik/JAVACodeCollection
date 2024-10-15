import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeOperations {
    public MeterOperations mt=new MeterOperations(null);

    void showExpiringEmpCNIC(ArrayList<String> dataList)
    {
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,500, 400);
        // id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
        // Column headers for the table
        String[] columnNames = {"CNIC","Allotment Date","Expiry Date"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }



    void showAllBill(ArrayList<String> dataList)
    {
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,500,500, 400);
        // id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
        // Column headers for the table
        String[] columnNames = {"ID", "Month","Regular Units","Peak Units","Entry Date","costOfElectricity","Sales Tax","fixed Charge","Total","Due Date","Status"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    void showAllPaid(ArrayList<String> dataList)
    {
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,500, 400);
       // id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
        // Column headers for the table
        String[] columnNames = {"ID", "Month","Regular Units","Peak Units","Entry Date","costOfElectricity","Sales Tax","fixed Charge","Total","Due Date","Status"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    void showAllUnPaid(ArrayList<String> dataList)
    {
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600,0,500, 400);
        // id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
        // Column headers for the table
        String[] columnNames = {"ID", "Month","Regular Units","Peak Units","Entry Date","costOfElectricity","Sales Tax","fixed Charge","Total","Due Date","Status"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }


    void showALlEmployees(ArrayList<String> dataList)
    {
        // Frame for the table
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Column headers for the table
        String[] columnNames = {"Name", "Passwrod"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    void showExpiryDateTable( ArrayList<String> dataList)
    {
        // Frame for the table
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Column headers for the table
        String[] columnNames = {"CNIC", "Start Date", "Expiry Date"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void addEmployee(String name,String password) throws FileNotFoundException {
        String employeeFile="EmployeesData.txt";
        System.out.println("Add New Employee");

        Scanner scanner = new Scanner(System.in);

        // Get employee name and password from user input
//        System.out.println("Enter Employee Name:");
//        String name = scanner.nextLine();
//
//        System.out.println("Enter Employee Password:");
//        String password = scanner.nextLine();

        // Construct the employee data in the required format (comma-separated)
        String employeeInfo = name + "," + password;

        // Read the existing file to check for duplicate name
        boolean isEmployeeExist = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(employeeFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] existingEmployeeData = line.split(",", 2);
                if (existingEmployeeData.length > 1 && existingEmployeeData[0].equals(name)) {
                    isEmployeeExist = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the employee file: " + e.getMessage());
        }

        // If the employee exists, ask the user if they still want to add

        // Add the new employee to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(employeeFile, true))) {
            writer.write(employeeInfo);
            writer.newLine();
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to the employee file: " + e.getMessage());
        }
        ArrayList<String> dataList=new ArrayList<>();
        String line="";
        dataList=mt.readFile("EmployeesData.txt",dataList,line);
        System.out.println("Data in Employee File\n");
        for(String s:dataList)
        {
            System.out.println(s+"\n");
        }
        showALlEmployees(dataList);
    }

    public void updateExpiry(String cnic,String expiryDate)
    {

        System.out.println("WellCome to Update Expiry");

        String fileName="CustomerInfo.txt";
        String line="";
        String line1="";
        String customerCNIC="";
        ArrayList<String> dataList = new ArrayList<>();
       // String expiryDate="";


        Scanner scan = new Scanner(System.in);
       // System.out.println("Enter CNIC");
      //  String cnic = scan.nextLine();
        boolean isUserFound=false;

        File inputFile = new File(fileName);
       // File tempFile = new File("temp_" + fileName);
        //BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        )
        {


            while ((line1 = reader.readLine()) != null) {


                String[] userData = line1.split(",");
                customerCNIC = userData[1];

               // System.out.println("data\t"+customerCNIC+"\n");
                if (cnic.equals(customerCNIC)) {
                    isUserFound=true;
                    System.out.println("User Found\n");



                    try (
                            BufferedReader readerBill = new BufferedReader(new FileReader("NADRADB.txt"));

                    ) {


                        while ((line = readerBill.readLine()) != null) {

                          //  System.out.println("Line:"+line);
                            String[] dateData = line.split(",");
//                                System.out.println("Date Data is :\n");
//                                for(int i=0; i<dateData.length; i++) {
//                                    System.out.println("dateData["+i+"] : "+dateData[i]);
//                                }
                            customerCNIC=dateData[0];

                            if (cnic.equals(customerCNIC))
                            {

                                System.out.println("CNIC Found\n");
                               // expiryDate=dateData[2];
                                System.out.println("CNIC:"+customerCNIC+" UpdatedDate: "+expiryDate+"\n");

                              //  System.out.println("Expiry Date : "+expiryDate);
                                Scanner scanner1 = new Scanner(System.in);
//                                System.out.println("Enter updated Expiry Date(YYYY-MM-DD)\n");
//                                expiryDate=scanner1.nextLine();

                                dateData[dateData.length-1]= String.valueOf(expiryDate);
                              //  System.out.println("dateData["+dateData.length+"] : "+dateData[dateData.length-1]);
                                line = String.join(",", dateData);
                                System.out.println("Update Record:\n"+line);
                               // System.out.println("line:\t"+line);
                                dataList.add(line);
                            }
                            else
                            {
                               // System.out.println(line);
                                dataList.add(line);

                            }

                        }
                        showExpiryDateTable(dataList);
                       for(int i=0;i<dataList.size();i++)
                       {
                           System.out.println("DataList["+i+"] "+dataList.get(i));
                       }
                        mt.writeFile("NADRADB.txt", dataList);
//                        BufferedWriter writer1 = new BufferedWriter(new FileWriter("NADRADB.txt"));
//                        for (String s : dataList) {
//                            writer1.write(s+System.lineSeparator());
//                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }






//                    if(userData.length==9)
//                    {
//                        System.out.println("In famouse If User datta\n"+userData[userData.length-1]);
//                        meterCounter=1;
//                        line1=line1+","+meterCounter;
//                    }
//                    else {
//                        System.out.println("In famouse If User datta\n"+userData[userData.length-1]);
//
//                        meterCounter= Integer.parseInt(userData[userData.length-1]);
//                        meterCounter++;
//                        System.out.println("In famouse else\n"+meterCounter);
//                        userData[userData.length-1]= String.valueOf(meterCounter);
//                        line1 = String.join(",", userData);
//
//                    }
//                    System.out.println("Data in the list after modification");
//                    for (String data : dataList) {
//                        System.out.println(data);
//                    }
//
//                    writeFile(dataList);

//                    System.out.println("\n\nin if\n\n ");
//                   flag=true;
//
//                    System.out.println("Updated line is "+line1);
//                    //System.out.println("\nCounter:"+coutner+"dataList.size()"+dataList.size());
//                    if (coutner >= 0 && coutner < dataList.size()) {
//                        dataList.set(coutner, line1);
//                        System.out.println(coutner + "\n" + line1);
//                    } else {
//                        System.out.println("Index out of bounds: " + coutner);
//                    }
//                    break;
//                    dataList.set(coutner-1,line);
//
//                    System.out.println(coutner+"\n"+line);



                    //   writer.write(line + System.lineSeparator());

                }



            }
            if(isUserFound)
            {
                System.out.println("User found\n");

            }
            else
            {
                System.out.println("User not Found");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

}

    public void paidUnpaidreport() {
        System.out.println("Paid Unpaid Report");

        boolean status = false;
        String line;
        boolean userFound = false;
        ArrayList<String> unPaid=new ArrayList<>();
        ArrayList<String> paid=new ArrayList<>();
        ArrayList<String> totalBills=new ArrayList<>();


            try (
                    BufferedReader readerBill = new BufferedReader(new FileReader("BillingInfo.txt"));
                    Scanner scannerBill = new Scanner(System.in)
            ) {

                while ((line = readerBill.readLine()) != null) {
                    totalBills.add(line);


                    String[] dbData = line.split(",");
                    System.out.println("Data is :\n");
                    for(int i=0; i<dbData.length; i++) {
                        System.out.println("dbData["+i+"] : "+dbData[i]);
                    }
                    status=Boolean.parseBoolean(dbData[10]);
                    if (status) {
                        paid.add(line);
                    }
                    else if(status==false)
                    {
                        unPaid.add(line);
                    }
                    else
                    {
                        System.out.println("In else\n");
                    }


                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(totalBills.isEmpty())
            {
                System.out.println("No Bill");
            }
            else {
                System.out.println("Total Bills\n");
                for(int i=0;i<totalBills.size();i++)
                {
                    System.out.println(totalBills.get(i));
                }
                showAllBill(totalBills);
            }

            if(paid.isEmpty())
            {
                System.out.println("No paid Bill");
            }
            else {
                System.out.println("Paid\n");
                for(int i=0;i<paid.size();i++)
                {
                    System.out.println(paid.get(i));
                }
                showAllPaid(paid);

            }
            if(unPaid.isEmpty())
            {
                System.out.println("No unpaid Bill");
            }
            else {
                System.out.println("Unpaid Bill\n");
                for(int i=0;i<unPaid.size();i++)
                {
                    System.out.println(unPaid.get(i));
                }
                showAllUnPaid(unPaid);
            }

    }

    public void viewExpiringCNIC() throws ParseException {
        System.out.println("In view Expiring CNIC");


        String name = "";
        String password = "";
        String line;
        boolean userFound = false;
        String expiryDate="";
        String currDate = "";
        String datePlus30Days = "";
        Date d1 = null;
        Date d2 = null;
        Date d3 = null;
        boolean flage=false;
        ArrayList<String> datalist=new ArrayList<>();




        LocalDate currentDate = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        currDate = currentDate.toString();
        d1 = sdf.parse(currDate);


        LocalDate futureDate = currentDate.plusDays(30);
        datePlus30Days = futureDate.toString();
        d2 = sdf.parse(datePlus30Days);




                        try (
                                BufferedReader readerBill = new BufferedReader(new FileReader("NADRADB.txt"));
                        ) {

                            while ((line = readerBill.readLine()) != null) {

                                String[] dbData = line.split(",");
                                expiryDate=dbData[2];
                                d3=sdf.parse(expiryDate);
//
                                if (d2.compareTo(d3) > 0 && d1.compareTo(d3) < 0)
                                {
                                    flage=true;
                                   // System.out.println(sdf.format(d2) + " (d1 + 30 days) is after " + expiryDate);
                                    System.out.println(line);
                                    datalist.add(line);
                                }


                            }
                            if(flage==false)
                            {
                                System.out.println("No User Found\n");
                                JOptionPane.showMessageDialog(null,"No User Found");
                            }
                            else
                            {
                                showExpiringEmpCNIC(datalist);
                            }

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        userFound = true;
                    }
}
