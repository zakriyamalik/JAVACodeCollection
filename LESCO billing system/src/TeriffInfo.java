import java.io.*;
import java.util.Scanner;

public class TeriffInfo {
    TeriffInfo()
    {

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

    }
    public void processData(String fileName) throws IOException {


        String meterType="";
        int choice=0;
        int regUnitPrice=0;
        int peakUnitPrice=0;
        float taxPercentage=0;
        int fixedCharge=0;
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


        System.out.println("Enter the Meter Type \nClick(1) for 1-Phase\nClick(2) for 3-phase\n");
        choice=scannerInput.nextInt();
        scannerInput.nextLine();

        // Start

        if(choice==1)
        {
            meterType="1Phase";
            Scanner scannerI = new Scanner(System.in);
            int ch=0;
            System.out.println("Enter 1 for Domestic\nEnter 2 for Commercial");
            ch=scannerI.nextInt();
            scannerI.nextLine();
            if(ch==1) {
                peakUnitPrice=-1;
                regUnitPrice=5;
                taxPercentage=17;
                fixedCharge=150;
              //  Scanner scannerIn = new Scanner(System.in);
                int choice1 = 0;
                System.out.println("Enter 1 to change Regular Units\nEnter 2 to change TaxPercentage\nEnter 3 to change FixedCharge\n");
                choice1 = scannerI.nextInt();
                scannerI.nextLine();
                if (choice1 == 1) {
                    int data=0;
                    System.out.println("Enter data");
                    data=scannerInput.nextInt();

                    regUnitPrice = data;
                    System.out.println("regUnitPrice  "+regUnitPrice+" \n");
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[0]=line1;
                    System.out.println("Line[0]: "+lines[0]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);
                    //myWriter.write(line1);
                    //myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
                } else if (choice1 == 2) {
                    float data=0;
                    System.out.println("Enter data");
                    data=scannerInput.nextFloat();
                    taxPercentage = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[0]=line1;
                    System.out.println("Line[1]: "+lines[0]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                    FileOperations.readFile(fileName);
                } else if (choice1 == 3) {
                    int data=0;
                    System.out.println("Enter data");
                    data=scannerInput.nextInt();
                    fixedCharge = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[0]=line1;
                    System.out.println("Line[0]: "+lines[0]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
                } else {
                    System.out.println("Invalid Choice\n");
                }

            }
            else if(ch==2) {
                int choice1 = 0;
                peakUnitPrice=-1;
                regUnitPrice = 15;
                taxPercentage = 20;
                fixedCharge = 250;
                System.out.println("Enter 1 to change Regular Units\nEnter 2 to change TaxPercentage\nEnter 3 to change FixedCharge\n");
                choice1 = scannerI.nextInt();
                scannerI.nextLine();
                if (choice1 == 1) {
                    int data=0;
                    System.out.println("Enter data");
                    data=scannerInput.nextInt();

                    regUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[1]=line1;
                    System.out.println("Line[0]: "+lines[1]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
                } else if (choice1 == 2) {
                    float data=0;
                    System.out.println("Enter data");
                    data=scannerInput.nextFloat();
                    taxPercentage = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[1]=line1;
                    System.out.println("Line[0]: "+lines[1]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
                } else if (choice1 == 3) {
                    int data=0;
                    System.out.println("Enter data");
                    data=scannerInput.nextInt();
                    fixedCharge = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[1]=line1;
                    System.out.println("Line[0]: "+lines[1]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
                    FileOperations.readFile(fileName);
                } else {
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
            System.out.println("Enter 1 for Domestic\nEnter 2 for Commercial");
            ch = scannerI.nextInt();
            scannerI.nextLine();
            if (ch == 1) {
                int choice1 = 0;
                regUnitPrice = 8;
                peakUnitPrice = 12;
                taxPercentage = 17;
                fixedCharge = 150;


                System.out.println("Enter 1 to change Regular Units\nEnter 2 to change TaxPercentage\nEnter 3 to change FixedCharge\nEnter 4 to change peakUnits");
                choice1 = scannerI.nextInt();
                scannerI.nextLine();
                if (choice1 == 1) {
                    int data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextInt();

                    regUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[3]=line1;
                    System.out.println("Line[3]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    System.out.println("regUnitPrice  "+regUnitPrice+" \n");
                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 2) {
                    float data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextFloat();
                    taxPercentage = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[3]=line1;
                    System.out.println("Line[3]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 3) {
                    int data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextInt();
                    fixedCharge = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[3]=line1;
                    System.out.println("Line[3]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 4) {
                    int data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextInt();
                    peakUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[3]=line1;
                    System.out.println("Line[3]: "+lines[3]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else {
                    System.out.println("Invalid Choice\n");
                }


//                myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );
//                System.out.println("Data is:" + meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge);
            }
            else if (ch == 2) {
                int choice1 = 0;
                regUnitPrice = 18;
                peakUnitPrice = 25;
                taxPercentage = 20;
                fixedCharge = 250;
                System.out.println("Enter 1 to change Regular Units\nEnter 2 to change TaxPercentage\nEnter 3 to change FixedCharge\nEnter 4 to change peakUnits");
                choice1 = scannerI.nextInt();
                scannerI.nextLine();
                if (choice1 == 1) {
                    int data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextInt();

                    regUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[4]=line1;
                    System.out.println("Line[4]: "+lines[4]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 2) {
                    float data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextFloat();
                    taxPercentage = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[4]=line1;
                    System.out.println("Line[4]: "+lines[4]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 3) {
                    int data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextInt();
                    fixedCharge = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[4]=line1;
                    System.out.println("Line[4]: "+lines[4]+"\n");
                    writeFile("TariffTaxInfo.txt",lines,0);

                    myWriter.write(meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge );

                } else if (choice1 == 4) {
                    int data = 0;
                    System.out.println("Enter data");
                    data = scannerInput.nextInt();
                    peakUnitPrice = data;
                    line1=meterType + "," + regUnitPrice + "," + peakUnitPrice + "," + taxPercentage + "," + fixedCharge ;
                    lines[4]=line1;
                    System.out.println("Line[4]: "+lines[4]+"\n");
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
            processData(fileName);

            }
            else
            {
                System.out.println("Lines have to be 4 but they are "+counter+"\nFirst fill it!!!");
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void TariffTaxUpdate(String fileName) {
        String line = "";
        String name = "";
        String password = "";
        boolean userFound = false;
        String empFileName = "EmployeesData.txt";
        Scanner scanner1 = new Scanner(System.in);
        int choice = 0;


        System.out.println("Enter the userName of the Employee:");
        name = scanner1.nextLine();
        System.out.println("Enter the password of the Employee:");
        password = scanner1.nextLine();


        File inputFile = new File(empFileName);

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        ) {


            while ((line = reader.readLine()) != null) {


                String[] userData = line.split(",", 2);


                if (userData.length == 2 && name.equals(userData[0])) {
                    if (password.equals(userData[1])) {
                        userFound = true;
                    }
                }

            }

            if (!userFound) {
                System.out.println("User not found or old password incorrect.");
            } else {
                System.out.println("Employee found\n");
                editTerrifFile(fileName);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public static void TariffTaxSystem(String fileName) throws IOException {

        String meterType="";
        int choice=0;
        int regUnitPrice=0;
        int peakUnitPrice=0;
        float taxPercentage=0;
        int fixedCharge=0;


        Scanner scannerInput = new Scanner(System.in);
        FileWriter myWriter = new FileWriter(fileName, true);


        System.out.println("Enter the Meter Type \nClick(1) for 1-Phase\nClick(2) for 3-phase\n");
        choice=scannerInput.nextInt();
        scannerInput.nextLine();


        if(choice==1)
        {
            meterType="1Phase";
            regUnitPrice=5;
            taxPercentage=17;
            fixedCharge=150;
            myWriter.write(meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge+System.lineSeparator());
            System.out.println("Data is:"+meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge);
            regUnitPrice=15;
            taxPercentage=20;
            fixedCharge=250;
            System.out.println("Data is:"+meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge);
            myWriter.write(meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge+System.lineSeparator());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        }


        else if(choice==2)
        {
            meterType="3Phase";
            regUnitPrice=8;
            peakUnitPrice=12;
            taxPercentage=17;
            fixedCharge=150;
            myWriter.write(meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge+System.lineSeparator());
            System.out.println("Data is:"+meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge);

            regUnitPrice=18;
            peakUnitPrice=25;
            taxPercentage=20;
            fixedCharge=250;
            myWriter.write(meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge+System.lineSeparator());
            System.out.println("Data is:"+meterType+","+regUnitPrice+","+peakUnitPrice+","+taxPercentage+","+fixedCharge);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }


        else
        {
            System.out.println("Wrong Input\n");
        }


        scannerInput.close();

    }

}
