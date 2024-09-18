import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ShowBill {
    ShowBill() {
    }

    public int billingSystem(String fileName) throws IOException {
        System.out.println("\nIn Billing System\n");
        MeterOperations meter = new MeterOperations();
        BillingOperations billingOperations = new BillingOperations(meter);
        int id = 0;
        LocalDate currentDate = LocalDate.now();
        Month currentMonthName = currentDate.getMonth();
        int currMeterReadingReg = 0;
        int currMeterReadingPeak = 0;
        String readingEntryDate = "";
        double costOfElectricity = 0.0;
        float salesTaxAmount = 0;
        double fixedCharge = 0.0;
        double totalBillingCharge = 0.0;
        String dueDate = "";
        boolean billPaidStatus = false;
        String billPaymentDate = "";
        String line = "";
        String meterType = "";
        String cusType = "";
        int cusRegUnitConsumed = 0;
        int cusPeakUnitConsumed = 0;
        int currentRegUnits = 0;
        int currentPeakUnits = 0;
        int currentReadingRegular = 0;
        int currentReadingPeak = 0;
        double tax = 0;


        File file = new File("CustomerInfo.txt");
        Scanner scanner = new Scanner(file);
        FileWriter myWriter = new FileWriter(fileName, true);


        // Iterate over each line in the file
        while (scanner.hasNextLine()) {


            line = scanner.nextLine();

            System.out.println("\nLine \t" + line);

            String[] userData = line.split(",");
            id = Integer.parseInt(userData[0]);
            meterType = userData[5];
            cusType = userData[4];
            cusRegUnitConsumed = Integer.parseInt(userData[7]);
            cusPeakUnitConsumed = Integer.parseInt(userData[8]);

            System.out.println("\nYou are entering data for id: " + id + "\n");

            System.out.println("\nid: " + id + "metertype: " + meterType + "cusType: " + cusType + "cusRegUnitConsumed: " + cusRegUnitConsumed + "cusPeakUnitConsumed: " + cusPeakUnitConsumed);

            if (Objects.equals(meterType, "1-phase")) {

                Scanner scanner1 = new Scanner(System.in);


                System.out.println("\nPhase-1\n");

                System.out.print("Enter Current Meter Reading (Regular): ");
                currentReadingRegular = scanner1.nextInt();
                scanner1.nextLine();


                if (currentReadingRegular < 0) {
                    System.out.println("Meter reading cannot be negative!");
                } else {
                    System.out.println("Regular Meter Reading: " + currentReadingRegular);
                }


                currentRegUnits = cusRegUnitConsumed - currentReadingRegular;
                costOfElectricity = billingOperations.getElectricityCost(cusType, meterType, currentRegUnits, currentPeakUnits);
                salesTaxAmount = billingOperations.getSalesTax(cusType, meterType);
                fixedCharge = billingOperations.getFixCharges(cusType, meterType);
                tax = costOfElectricity * (salesTaxAmount / 100);
                costOfElectricity = costOfElectricity + tax;
                totalBillingCharge = costOfElectricity + fixedCharge;
                billingOperations.updateRegUnits(id, currentReadingRegular);


            } else if (Objects.equals(meterType, "3-phase")) {

                Scanner scanner1 = new Scanner(System.in);

                System.out.println("\nPhase-3\n");

                System.out.print("Enter Current Meter Reading (Regular): ");
                currentReadingRegular = scanner1.nextInt();
                scanner1.nextLine();


                System.out.print("Enter Current Meter Reading (Peak): ");
                currentReadingPeak = scanner1.nextInt();
                scanner1.nextLine();


                if (currentReadingRegular < 0 || currentReadingPeak < 0) {
                    System.out.println("Meter readings cannot be negative!");
                } else {
                    System.out.println("Regular Meter Reading: " + currentReadingRegular);
                    System.out.println("Peak Meter Reading: " + currentReadingPeak);
                }


                currentRegUnits = (cusRegUnitConsumed - currentReadingRegular);
                costOfElectricity = billingOperations.getElectricityCost(cusType, meterType, currentRegUnits, currentPeakUnits);
                salesTaxAmount = billingOperations.getSalesTax(cusType, meterType);
                fixedCharge = billingOperations.getFixCharges(cusType, meterType);
                tax = costOfElectricity * (salesTaxAmount / 100);
                costOfElectricity = costOfElectricity + tax;
                totalBillingCharge = costOfElectricity + fixedCharge;


            } else {
                System.out.println("Wrong Phase:");
            }

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter Reading Entry Date(DD/MM/YYYY): ");
            readingEntryDate = scanner1.nextLine();
            System.out.println("Enter Billing Status(ture/false): ");
            billPaidStatus = scanner1.nextBoolean();

            dueDate = billingOperations.getDueDate(readingEntryDate);


            line = id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
            System.out.println("Line:" + line);
            myWriter.write(line + System.lineSeparator());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");


        }

        scanner.close();


        return 0;
    }


    public int billingSystem1(String fileName,int Cusid,String cusMeterType) throws IOException {
        System.out.println("\nIn Billing System2\n");
        System.out.println(fileName+" "+Cusid+" "+cusMeterType+" \n");
        MeterOperations meter = new MeterOperations();
        BillingOperations billingOperations = new BillingOperations(meter);
        int id = 0;
        LocalDate currentDate = LocalDate.now();
        Month currentMonthName = currentDate.getMonth();
        int currMeterReadingReg = 0;
        int currMeterReadingPeak = 0;
        String readingEntryDate = "";
        double costOfElectricity = 0.0;
        float salesTaxAmount = 0;
        double fixedCharge = 0.0;
        double totalBillingCharge = 0.0;
        String dueDate = "";
        boolean billPaidStatus = false;
        String billPaymentDate = "";
        String line = "";
        String meterType = "";
        String cusType = "";
        int cusRegUnitConsumed = 0;
        int cusPeakUnitConsumed = 0;
        int currentRegUnits = 0;
        int currentPeakUnits = 0;
        int currentReadingRegular = 0;
        int currentReadingPeak = 0;
        double tax = 0;


        File file = new File("CustomerInfo.txt");
        Scanner scanner = new Scanner(file);
        FileWriter myWriter = new FileWriter(fileName, true);


        // Iterate over each line in the file
        while (scanner.hasNextLine()) {


            line = scanner.nextLine();

            System.out.println("\nLine \t" + line);

            String[] userData = line.split(",");
            id = Integer.parseInt(userData[0]);
            meterType = userData[5];
            cusType = userData[4];
            cusRegUnitConsumed = Integer.parseInt(userData[7]);
            cusPeakUnitConsumed = Integer.parseInt(userData[8]);
            System.out.println("Cusid "+Cusid+" id "+id+" meterType "+meterType+" cusMeterType "+cusMeterType+" \n");
            if (Cusid == id&& Objects.equals(meterType, cusMeterType)) {
                System.out.println("Id of Customer to updated matched\n");



                System.out.println("\nYou are entering data for id: " + id + "\n");

                System.out.println("\nid: " + id + "metertype: " + meterType + "cusType: " + cusType + "cusRegUnitConsumed: " + cusRegUnitConsumed + "cusPeakUnitConsumed: " + cusPeakUnitConsumed);

                if (Objects.equals(meterType, "1-phase")) {

                    Scanner scanner1 = new Scanner(System.in);


                    System.out.println("\nPhase-1\n");

                    System.out.print("Enter Current Meter Reading (Regular): ");
                    currentReadingRegular = scanner1.nextInt();
                    scanner1.nextLine();


                    if (currentReadingRegular < 0) {
                        System.out.println("Meter reading cannot be negative!");
                    } else {
                        System.out.println("Regular Meter Reading: " + currentReadingRegular);
                    }


                    currentRegUnits = cusRegUnitConsumed - currentReadingRegular;
                    costOfElectricity = billingOperations.getElectricityCost(cusType, meterType, currentRegUnits, currentPeakUnits);
                    salesTaxAmount = billingOperations.getSalesTax(cusType, meterType);
                    fixedCharge = billingOperations.getFixCharges(cusType, meterType);
                    tax = costOfElectricity * (salesTaxAmount / 100);
                    costOfElectricity = costOfElectricity + tax;
                    totalBillingCharge = costOfElectricity + fixedCharge;
                    billingOperations.updateRegUnits(id, currentReadingRegular);


                } else if (Objects.equals(meterType, "3-phase")) {

                    Scanner scanner1 = new Scanner(System.in);

                    System.out.println("\nPhase-3\n");

                    System.out.print("Enter Current Meter Reading (Regular): ");
                    currentReadingRegular = scanner1.nextInt();
                    scanner1.nextLine();


                    System.out.print("Enter Current Meter Reading (Peak): ");
                    currentReadingPeak = scanner1.nextInt();
                    scanner1.nextLine();


                    if (currentReadingRegular < 0 || currentReadingPeak < 0) {
                        System.out.println("Meter readings cannot be negative!");
                    } else {
                        System.out.println("Regular Meter Reading: " + currentReadingRegular);
                        System.out.println("Peak Meter Reading: " + currentReadingPeak);
                    }


                    currentRegUnits = (cusRegUnitConsumed - currentReadingRegular);
                    costOfElectricity = billingOperations.getElectricityCost(cusType, meterType, currentRegUnits, currentPeakUnits);
                    salesTaxAmount = billingOperations.getSalesTax(cusType, meterType);
                    fixedCharge = billingOperations.getFixCharges(cusType, meterType);
                    tax = costOfElectricity * (salesTaxAmount / 100);
                    costOfElectricity = costOfElectricity + tax;
                    totalBillingCharge = costOfElectricity + fixedCharge;


                } else {
                    System.out.println("Wrong Phase:");
                }

                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter Reading Entry Date(DD/MM/YYYY): ");
                readingEntryDate = scanner1.nextLine();
                System.out.println("Enter Billing Status(ture/false): ");
                billPaidStatus = scanner1.nextBoolean();
                System.out.println("Before\n");
                dueDate = billingOperations.getDueDate(readingEntryDate);
                System.out.println("After\n");

                line = id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
                System.out.println("Line:" + line);
                myWriter.write(line + System.lineSeparator());
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

           // break;
            }
        }

        scanner.close();


        return 0;
    }


    public String readBillingFile(int Id, String meterType) throws FileNotFoundException {
        String line = "";
        String[] userData;
        int peakUnits = 0;
        ArrayList<String> record = new ArrayList<>();
        try {

            File myObj = new File("BillingInfo.txt");

            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {


                String data = myReader.nextLine();
                userData = data.split(",");
                System.out.println("Data is:\n");
                peakUnits = Integer.parseInt(userData[3]);
                for (int i = 0; i < userData.length; i++) {
                    System.out.println("userData[" + i + "]=" + userData[i]);
                }

                if (userData[0].equals(String.valueOf(Id))) {
                    if (peakUnits == 0 && Objects.equals(meterType, "1-phase")) {
                        System.out.println("Record found for Phase-1 meter\n");
                        return data;


                    } else if (peakUnits != 0 && Objects.equals(meterType, "3-phase")) {
                        System.out.println("Record found for Phase-3 meter\n");
                        return data;


                    }


                }


//                record.add(data);
//                System.out.println(data);
            }


            myReader.close();
            System.out.println("No record found\n");
//            if(meterType=="1-phase")
//            {
//                if(cusType=="Commercial")
//                {
//                    return record.get(0);
//                }
//                else
//                {
//                    return record.get(1);
//
//                }
//
//            }
//            else if(meterType=="3-phase")
//            {
//                if(cusType=="Commercial")
//                {
//                    return record.get(2);
//
//                }
//                else
//                {
//                    return record.get(3);
//
//                }
//            }
//            else
//            {
//                System.out.println("Wrong Phase No!!!");
//            }


        } catch (FileNotFoundException e) {


            System.out.println("An error occurred.");
            e.printStackTrace();


        }

        return null;
    }

    public void showBill() {
        int id = 0;
        long CNIC = 0;
        String meterType = "";
        int currMeterReading = 0;
        String[] userData;
        String[] taxData;
        int fileId = 0;
        long fileCNIC = 0;
        String fileMeterType = "";
        String fileCusType = "";
        float electricityCost = 0;
        float tax = 0;
        double fixedCharges = 0.0;
        boolean billStatus = false;
        String dueDate = "";
        String filPhoneNo = "";
        String fileAddress = "";


        System.out.println("Enter your Customer ID:\n");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Enter 13-digit number without dashes:\n");
        CNIC = Long.parseLong(scanner.nextLine());

        System.out.println("Enter meter type:\n");
        meterType = scanner.nextLine();

        System.out.println("Enter current meter reading:\n");
        currMeterReading = Integer.parseInt(scanner.nextLine());

        try {

            File myObj = new File("CustomerInfo.txt");
            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                userData = line.split(",");
                fileCusType = userData[4];
                fileId = Integer.parseInt(userData[0]);
                fileCNIC = Long.parseLong(userData[1]);
                fileMeterType = userData[5];
                System.out.println("Data is\n");
                for (int i = 0; i < userData.length; i++) {
                    System.out.println("userData[" + i + "]=" + userData[i]);
                }

                System.out.println(fileId + fileCNIC + fileMeterType + "\n");
                if ((id == fileId || CNIC == fileCNIC) || meterType.equals(fileMeterType)) {
                    fileCusType = userData[4];
                    fileId = Integer.parseInt(userData[0]);
                    fileCNIC = Long.parseLong(userData[1]);
                    fileMeterType = userData[5];
                    fileAddress = userData[2];
                    fileAddress = userData[3];
                    System.out.println("User Found\n");
                    //System.out.println(line);
                    line = readBillingFile(id, fileMeterType);
                    System.out.println("Back in Show Bill\n");
                    // System.out.println(line);
                    assert line != null;
                    taxData = line.split(",");
                    System.out.println("Tax Data:");
                    for (int i = 0; i < taxData.length; i++) {
                        System.out.println("taxData[" + i + "]=" + taxData[i]);
                    }
                    System.out.println("\n1\n");
                    electricityCost = Float.parseFloat(taxData[5]);
                    System.out.println("2\n");

                    tax = Float.parseFloat(taxData[6]);
                    System.out.println("3\n");

                    fixedCharges = Double.parseDouble(taxData[7]);
                    System.out.println("4\n");

                    billStatus = Boolean.parseBoolean(taxData[10]);

                    System.out.println("5\n");

                    dueDate = taxData[9];
                    System.out.println("6\n");

                    //   line = id + "," +currentMonthName + "," + currentReadingRegular
                    //   + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," +dueDate + "," +billPaidStatus + "," +dueDate;// Write the line to the file
                    System.out.println("Bill:\n");
                    System.out.println("ID: " + id + " CNIC: " + CNIC + " Address: " + fileAddress + " User Type: " + fileCusType + " Meter Type: " + fileMeterType + " Current Meter Reading: " + currMeterReading + " Electricity Cost: " + electricityCost + " Tax: " + tax + " Fixed-Charges: " + fixedCharges + " Due Date: " + dueDate + " Bill Status: " + billStatus);


                }


//                for(int i=0;i<userData.length;i++)
//                {
//                    System.out.println("userData["+i+"] "+userData[i]+" ");
//                }

            }


            myReader.close();


        } catch (FileNotFoundException e) {


            System.out.println("An error occurred.");
            e.printStackTrace();


        }


    }


    public boolean customerCheck( int id ,long CNIC, String meterType) throws FileNotFoundException {


        int currMeterReading = 0;
        String[] userData;
        String[] taxData;
        int fileId = 0;
        long fileCNIC = 0;
        String fileMeterType = "";
        String fileCusType = "";
        float electricityCost = 0;
        float tax = 0;
        double fixedCharges = 0.0;
        boolean billStatus = false;
        String dueDate = "";
        String filPhoneNo = "";
        String fileAddress = "";


        try {

            File myObj = new File("CustomerInfo.txt");
            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                userData = line.split(",");
                fileCusType = userData[4];
                fileId = Integer.parseInt(userData[0]);
                fileCNIC = Long.parseLong(userData[1]);
                fileMeterType = userData[5];
                System.out.println("Data is\n");
                for (int i = 0; i < userData.length; i++) {
                    System.out.println("userData[" + i + "]=" + userData[i]);
                }

                System.out.println(fileId + fileCNIC + fileMeterType + "\n");
                if ((id == fileId || CNIC == fileCNIC) || meterType.equals(fileMeterType)) {
                    fileCusType = userData[4];
                    fileId = Integer.parseInt(userData[0]);
                    fileCNIC = Long.parseLong(userData[1]);
                    fileMeterType = userData[5];
                    fileAddress = userData[2];
                    fileAddress = userData[3];
                    System.out.println("User Found\n");
                    return true;

                }

            }


            myReader.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}