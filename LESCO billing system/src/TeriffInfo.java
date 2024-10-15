import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class TeriffInfo {
    static TeriffInfo tf=new TeriffInfo();
//    String meterType="";
//    int choice=0;
//    int regUnitPrice=0;
//    int peakUnitPrice=0;
//    float taxPercentage=0;
//    int fixedCharge=0;
//    int counter=0;
//    String line1="";

//    public String getMeterType() {
//        return meterType;
//    }
//
//    public int getChoice() {
//        return choice;
//    }

//    public int getRegUnitPrice() {
//        return regUnitPrice;
//    }
//
//    public int getPeakUnitPrice() {
//        return peakUnitPrice;
//    }
//
//    public float getTaxPercentage() {
//        return taxPercentage;
//    }
//
//    public int getFixedCharge() {
//        return fixedCharge;
//    }
//
//    public int getCounter() {
//        return counter;
//    }
//
//    public String getLine1() {
//        return line1;
//    }

    TeriffInfo()
    {

    }
    public void showAllTerrifRecord(String [] dataList)
    {
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(3);
        frame.setSize(500, 400);
        String[] columnNames = new String[]{"Meter type", "Regular unit price", "Peak unit price","Tax percentage", "Fixed charges"};
        String[][] data = new String[dataList.length][];

        for(int i = 0; i < dataList.length; ++i) {
            data[i] = (dataList[i]).split(",");
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, "Center");
        frame.setVisible(true);
    }
    public void  writeFile(String fileName,String [] lines,int index)
    {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));  // Create writer instance for the file
        } catch (IOException e) {
            System.out.println("Error initializing BufferedWriter for file: " + fileName);
            e.printStackTrace();
            return;  // Exit method if file cannot be written
        }
        System.out.println("Data in files are:\n");
            for(int i=0;i<lines.length;i++)
            {
                System.out.println("Lines[" + i + "]: " + lines[i]);
            }
        try {
            for (String line : lines) {
                writer.write(line);  // Write each array element to the file
                writer.newLine();    // Move to the next line
            }
            System.out.println("File populated successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file.");
            e.printStackTrace();
        } finally {
            // Ensure that the BufferedWriter is closed properly, even if an exception occurs
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the BufferedWriter.");
                e.printStackTrace();
            }
        }
        showAllTerrifRecord(lines);


    }
    public void processData(String meterType,String customerType,int regUnitPrice,int peakUnitPrice,float taxPercentage,int fixedCharge) throws IOException {

        String fileName="TariffTaxInfo.txt";
        System.out.println("\nTerrif\n");
        System.out.println( meterType+" "+ customerType+" "+regUnitPrice+" "+peakUnitPrice+" "+ taxPercentage+" "+fixedCharge);

        // String meterType="";
        int choice=0;
      //  int regUnitPrice=0;
      //  int peakUnitPrice=0;
      //  float taxPercentage=0;
      //  int fixedCharge=0;
        int counter=0;
        String line1="";

        Scanner scannerInput = new Scanner(System.in);
        FileWriter myWriter = new FileWriter(fileName, true);
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNextLine()) {

            counter++;
            System.out.println("Counter"+counter);
            scanner.nextLine();
        }
        scanner.close();
        scanner = new Scanner(new FileReader(fileName));
        String [] lines=new String[counter];
        counter=0;
        while (scanner.hasNextLine()) {
           line1=scanner.nextLine();
            System.out.println("Line\t"+line1+"\n");
            lines[counter++]=line1;
           // scanner.nextLine();
        }

        System.out.println("Final Data is :\n");
        for(int i=0;i<counter;i++)
        {
            System.out.println(lines[i]+"\n");
        }


//        System.out.println("Enter the Meter Type \nClick(1) for 1-Phase\nClick(2) for 3-phase\n");
//        choice=scannerInput.nextInt();
//        scannerInput.nextLine();

        // Start
        if(Objects.equals(meterType, "1-phase"))
        {
            choice=1;

        }
        else if(Objects.equals(meterType, "3-phase"))
        {
            choice=2;
        }
        else
        {
            choice=-1;
            System.out.println(meterType);
        }

        if(choice==1)
        {
            meterType="1Phase";
            Scanner scannerI = new Scanner(System.in);
            int ch=0;
//            System.out.println("Enter 1 for Domestic\nEnter 2 for Commercial");
//            ch=scannerI.nextInt();
//            scannerI.nextLine();
            if(Objects.equals(customerType, "Domestic"))
            {
                ch=1;

            }
            else if(Objects.equals(customerType, "Commercial"))
            {
                ch=2;
            }
            else
            {
                ch=-1;
            }
            if(ch==1) {

              //  Scanner scannerIn = new Scanner(System.in);
                int choice1 = 0;
//                System.out.println("Enter 1 to change Regular Units\nEnter 2 to change TaxPercentage\nEnter 3 to change FixedCharge\n");
//                choice1 = scannerI.nextInt();
//                scannerI.nextLine();
                if(regUnitPrice!=-1)
                {
                    choice1=1;
                } else if (taxPercentage!=-1.0) {
                    choice1=2;

                } else if (fixedCharge!=-1) {
                    choice1=3;
                }
                else
                {
                    choice1=4;
                    System.out.println("Invalid Choice units");
                    JOptionPane.showMessageDialog(null, "Invalid Operation");
                }



                if (choice1 == 1) {
                    peakUnitPrice=-1;
                    //regUnitPrice=5;
                    taxPercentage=17;
                    fixedCharge=150;

//                    int data=0;
//                    System.out.println("Enter data");
//                    data=scannerInput.nextInt();
//
//                    regUnitPrice = data;
                    System.out.println("regUnitPrice  "+regUnitPrice+" \n");
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[0]=line1;
                    System.out.println("Line[0]: "+lines[0]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);
                    myWriter.write(line1);
                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
                } else if (choice1 == 2) {
                    peakUnitPrice=-1;
                    regUnitPrice=5;
                   // taxPercentage=17;
                    fixedCharge=150;
                    float data=0;
//                    System.out.println("Enter data");
//                    data=scannerInput.nextFloat();
//                    taxPercentage = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[0]=line1;
                    System.out.println("Line[1]: "+lines[0]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                    FileOperations.readFile(fileName);
                } else if (choice1 == 3) {
                    int data=0;
                    peakUnitPrice=-1;
                    regUnitPrice=5;
                    taxPercentage=17;
                   // fixedCharge=150;
//                    System.out.println("Enter data");
//                    data=scannerInput.nextInt();
//                    fixedCharge = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[0]=line1;
                    System.out.println("Line[0]: "+lines[0]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
                } else {
                    System.out.println("Invalid Choice for Customer Type\n");
                    JOptionPane.showMessageDialog(null, "Invalid Operation");
                }

            }
            else if(ch==2) {
                int choice1 = 0;
//                System.out.println("Enter 1 to change Regular Units\nEnter 2 to change TaxPercentage\nEnter 3 to change FixedCharge\n");
//                choice1 = scannerI.nextInt();
//                scannerI.nextLine();
                if(regUnitPrice!=-1)
                {
                    choice1=1;
                } else if (taxPercentage!=-1.0) {
                    choice1=2;

                } else if (fixedCharge!=-1) {
                    choice1=3;
                }
                else
                {
                    System.out.println("Invalid Choice units");

                }

                if (choice1 == 1) {
                    peakUnitPrice=-1;
                  //  regUnitPrice = 15;
                    taxPercentage = 20;
                    fixedCharge = 250;
                    int data=0;
//                    System.out.println("Enter data");
//                    data=scannerInput.nextInt();
//
//                    regUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[1]=line1;
                    System.out.println("Line[0]: "+lines[1]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
                } else if (choice1 == 2) {
                    float data=0;
                    peakUnitPrice=-1;
                    regUnitPrice = 15;
                   // taxPercentage = 20;
                    fixedCharge = 250;
//                    System.out.println("Enter data");
//                    data=scannerInput.nextFloat();
//                    taxPercentage = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[1]=line1;
                    System.out.println("Line[0]: "+lines[1]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
                } else if (choice1 == 3) {
                    peakUnitPrice=-1;
                    regUnitPrice = 15;
                    taxPercentage = 20;
                   // fixedCharge = 250;
                    int data=0;
//                    System.out.println("Enter data");
//                    data=scannerInput.nextInt();
//                    fixedCharge = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[1]=line1;
                    System.out.println("Line[0]: "+lines[1]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
//                } else {
                    System.out.println("Invalid Choice\n");
                }

                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            }
            else
            {
                System.out.println("Wrong Input\n");
            }

        }

        else if(choice==2) {

            meterType = "3Phase";

            Scanner scannerI = new Scanner(System.in);
            int ch = 0;
//            System.out.println("Enter 1 for Domestic\nEnter 2 for Commercial");
//            ch = scannerI.nextInt();
//            scannerI.nextLine();
            if(Objects.equals(customerType, "Domestic"))
            {
                ch=1;

            }
            else if(Objects.equals(customerType, "Commercial"))
            {
                ch=2;
            }
            else
            {
                ch=-1;
            }
            if (ch == 1) {


                int choice1 = 0;
//                System.out.println("Enter 1 to change Regular Units\nEnter 2 to change TaxPercentage\nEnter 3 to change FixedCharge\n");
//                choice1 = scannerI.nextInt();
//                scannerI.nextLine();
                if(regUnitPrice!=-1)
                {
                    choice1=1;
                } else if (taxPercentage!=-1.0) {
                    choice1=2;

                } else if (fixedCharge!=-1) {
                    choice1=3;
                } else if (peakUnitPrice!=-1) {
                    choice1=4;

                } else
                {
                    System.out.println("Invalid Choice units");
                }



                if (choice1 == 1) {

                   // regUnitPrice = 8;
                    peakUnitPrice = 12;
                    taxPercentage = 17;
                    fixedCharge = 150;
                    int data = 0;
//                    System.out.println("Enter data");
//                    data = scannerInput.nextInt();
//
//                    regUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[2]=line1;
                    System.out.println("Line[3]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    System.out.println("regUnitPrice  "+regUnitPrice+" \n");
                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 2) {
                    regUnitPrice = 8;
                    peakUnitPrice = 12;
                   // taxPercentage = 17;
                    fixedCharge = 150;
                    float data = 0;
//                    System.out.println("Enter data");
//                    data = scannerInput.nextFloat();
//                    taxPercentage = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[2]=line1;
                    System.out.println("Line[3]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 3) {
                    regUnitPrice = 8;
                    peakUnitPrice = 12;
                    taxPercentage = 17;
                  //  fixedCharge = 150;
                    int data = 0;
//                    System.out.println("Enter data");
//                    data = scannerInput.nextInt();
//                    fixedCharge = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[2]=line1;
                    System.out.println("Line[3]: "+lines[3]+"\n");
//                    writeFile("TariffTaxInfo.txt",lines,0);
//
//                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 4) {
                    regUnitPrice = 8;
                   // peakUnitPrice = 12;
                    taxPercentage = 17;
                    fixedCharge = 150;
                    int data = 0;
//                    System.out.println("Enter data");
//                    data = scannerInput.nextInt();
//                    peakUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[2]=line1;
                    System.out.println("Line[3]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else {
                    System.out.println("Invalid Choice\n");
                }






                myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                System.out.println("Data is:" + meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge);
            }
            else if (ch == 2) {
                int choice1 = 0;

                System.out.println("Enter 1 to change Regular Units\nEnter 2 to change TaxPercentage\nEnter 3 to change FixedCharge\nEnter 4 to change peakUnits");
                choice1 = scannerI.nextInt();
                scannerI.nextLine();
                if(regUnitPrice!=-1)
                {
                    choice1=1;
                } else if (taxPercentage!=-1.0) {
                    choice1=2;

                } else if (fixedCharge!=-1) {
                    choice1=3;
                }
                else
                {
                    System.out.println("Invalid Choice units");
                }
                regUnitPrice = 18;
                peakUnitPrice = 25;
                taxPercentage = 20;
                fixedCharge = 250;
                if (choice1 == 1) {
                    int data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextInt();

                    regUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[3]=line1;
                    System.out.println("Line[4]: "+lines[4]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 2) {
                    float data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextFloat();
                    taxPercentage = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[3]=line1;
                    System.out.println("Line[4]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 3) {
                    int data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextInt();
                    fixedCharge = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[3]=line1;
                    System.out.println("Line[4]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 4) {
                    int data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextInt();
                    peakUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[3]=line1;
                    System.out.println("Line[4]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else {
                    System.out.println("Invalid Choice\n");
                }

                myWriter.close();
                System.out.println("Successfully wrote to the file.");

            }
            else
            {
                System.out.println("Invalid Choice\n");
            }
        }


        else
        {
            System.out.println("Wrong Input\n");
        }


        scannerInput.close();

    }
    public void editTerrifFile(String fileName)
    {
        String line="";
        int counter=0;
        System.out.println("filename:"+fileName+"\n");

//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
//        {
//            //bw.write(CNIC+","+currDate+","+expiryDate+System.lineSeparator());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            Scanner sc = new Scanner(br);
            System.out.println("sc"+sc+"\n");

            while((line=br.readLine())!=null)
            {
               // System.out.println("Counter:"+counter+"\n");
                counter++;

            }
            if(counter==4)
            {
               // System.out.println("Lines are "+counter);

            FileOperations.readFile(fileName);
           // processData();

            }
            else
            {
                System.out.println("Lines have to be 4 but they are "+counter+"\nFirst fill it or remove it!!!");
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean TariffTaxUpdate(String name,String password) {
        String fileName="TarrifTaxInfo.txt";
        String line = "";

        boolean userFound = false;
        String empFileName = "EmployeesData.txt";


        File inputFile = new File(empFileName);

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        ) {


            while ((line = reader.readLine()) != null) {


                String[] userData = line.split(",", 2);


                if (userData.length == 2 && name.equals(userData[0])) {
                    if (password.equals(userData[1])) {
                        userFound = true;
                        return true;
                    }
                }

            }

            if (!userFound) {
                System.out.println("User not found or old password incorrect.");
                return false;
            } else {
                System.out.println("Employee found\n");
                return true;
                //editTerrifFile(fileName);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public static void TariffTaxSystem(String fileName) throws IOException {
      //      System.out.println("In terrif tax system\n");
        String meterType="";
        int choice=0;
        int regUnitPrice=0;
        int peakUnitPrice=0;
        float taxPercentage=0;
        int fixedCharge=0;

        FileWriter myWriter = new FileWriter(fileName);


       // System.out.println("Enter the Meter Type \nClick(1) for 1-Phase\nClick(2) for 3-phase\n");



            meterType="1Phase";
            regUnitPrice=5;
            taxPercentage=17;
            fixedCharge=150;
            myWriter.write(meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge+System.lineSeparator());
          //  System.out.println("Data is:"+meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge);
            regUnitPrice=15;
            taxPercentage=20;
            fixedCharge=250;
           // System.out.println("Data is:"+meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge);
            myWriter.write(meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge+System.lineSeparator());

         //   System.out.println("Successfully wrote to the file.");


            meterType="3Phase";
            regUnitPrice=8;
            peakUnitPrice=12;
            taxPercentage=17;
            fixedCharge=150;
            myWriter.write(meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge+System.lineSeparator());
        //    System.out.println("Data is:"+meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge);

            regUnitPrice=18;
            peakUnitPrice=25;
            taxPercentage=20;
            fixedCharge=250;
            myWriter.write(meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge+System.lineSeparator());
          //  System.out.println("Data is:"+meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge);
            myWriter.close();

            System.out.println("Successfully wrote to the file.");

            String fileName1="TariffTaxInfo.txt";
            System.out.println("\nTerrif\n");
            System.out.println( meterType+" "+regUnitPrice+" "+peakUnitPrice+" "+ taxPercentage+" "+fixedCharge);

            // String meterType="";
            //int choice=0;
            //  int regUnitPrice=0;
            //  int peakUnitPrice=0;
            //  float taxPercentage=0;
            //  int fixedCharge=0;
            int counter=0;
            String line1="";

            Scanner scannerInput = new Scanner(System.in);
            //FileWriter myWriter = new FileWriter(fileName1, true);
            Scanner scanner = new Scanner(new FileReader(fileName1));
            while (scanner.hasNextLine()) {

                counter++;
                System.out.println("Counter"+counter);
                scanner.nextLine();
            }
            scanner.close();
            scanner = new Scanner(new FileReader(fileName1));
            String [] lines=new String[counter];
            counter=0;
            while (scanner.hasNextLine()) {
                line1=scanner.nextLine();
                System.out.println("Line\t"+line1+"\n");
                lines[counter++]=line1;
                // scanner.nextLine();
            }

            System.out.println("Final Data is :\n");
            for(int i=0;i<counter;i++)
            {
                System.out.println(lines[i]+"\n");
            }
            tf.showAllTerrifRecord(lines);




    }

}
