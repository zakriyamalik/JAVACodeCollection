import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.time.Month;
import java.time.LocalDate;
import java.util.*;



public class BillingSystem {
    public static String getDueDate(String readingEntryDate)
    {
        int day=0;
        String[] dateEntries;
        dateEntries=readingEntryDate.split("/",3);
        day=Integer.parseInt(dateEntries[0]);
        day=day+7;

        return dateEntries[0];
    }

    public static float getFixCharges(String cusType,String meterType)
    {
        String fileName="TariffTaxInfo.txt";
        String line=null;
        String[] tariffData=null;
        float fixCharges=0;

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            if (Objects.equals(meterType, "1-phase")) {

                if (Objects.equals(cusType, "Domestic")) {

                    line=lines.get(0);
                    tariffData=line.split(",",5);
                    fixCharges=Float.parseFloat(tariffData[5]);

                }

                else if (Objects.equals(cusType, "Commercial")) {
                    line=lines.get(0);
                    tariffData=line.split(",",5);
                    fixCharges=Float.parseFloat(tariffData[5]);

                }

                else {
                    System.out.println("Wrong Customer Type");
                }
            }


            else if (Objects.equals(meterType, "3-phase")) {

                if (Objects.equals(cusType, "Domestic")) {
                    line=lines.get(0);
                    tariffData=line.split(",",5);
                    fixCharges=Float.parseFloat(tariffData[5]);

                }

                else if (Objects.equals(cusType, "Commercial")) {
                    line=lines.get(0);
                    tariffData=line.split(",",5);
                    fixCharges=Float.parseFloat(tariffData[5]);

                }

                else {
                    System.out.println("Wrong Customer Type");
                }

            }


            else
            {
                System.out.println("Wrong Phase");
            }
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


        return fixCharges;
    }



    public static float getSalesTax(String cusType,String meterType)
    {
        String fileName="TariffTaxInfo.txt";
        String line=null;
        String[] tariffData=null;
        float salesTax=0;


        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            if (Objects.equals(meterType, "1-phase")) {

                if (Objects.equals(cusType, "Domestic")) {
                    line=lines.get(0);
                    tariffData=line.split(",",5);
                    salesTax=Float.parseFloat(tariffData[4]);

                }

                else if (Objects.equals(cusType, "Commercial")) {
                    line=lines.get(1);
                    tariffData=line.split(",",5);
                    salesTax=Float.parseFloat(tariffData[4]);

                }

                else {
                    System.out.println("Wrong Customer Type");
                }
            }


            else if (Objects.equals(meterType, "3-phase")) {

                if (Objects.equals(cusType, "Domestic")) {
                    line=lines.get(2);
                    tariffData=line.split(",",5);
                    salesTax=Float.parseFloat(tariffData[4]);

                }

                else if (Objects.equals(cusType, "Commercial")) {
                    line=lines.get(3);
                    tariffData=line.split(",",5);
                    salesTax=Float.parseFloat(tariffData[4]);

                }

                else {
                    System.out.println("Wrong Customer Type");
                }

            }


            else
            {
                System.out.println("Wrong Phase");
            }
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


        return salesTax;
    }
    public static int getElectricityCost(String cusType, String meterType, Integer RegUnits, Integer PeakUnits) {

        RegUnits = (RegUnits == null) ? 0 : RegUnits;
        PeakUnits = (PeakUnits == null) ? 0 : PeakUnits;

        return calculateCost(cusType, meterType, RegUnits, PeakUnits);
    }


    public static int calculateCost(String cusType, String meterType,int Regunits,int PeakUnits) {
        int electricityCost = 0;
        String line = "";
        int unitPrice = 0;
        int peakUnitPrice = 0;
        String fileName = "TariffTaxInfo.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            if (Objects.equals(meterType, "1-phase")) {

                if (Objects.equals(cusType, "Domestic")) {
                    unitPrice = 5;
                    electricityCost=unitPrice*Regunits;

                }

                else if (Objects.equals(cusType, "Commercial")) {
                    unitPrice = 15;
                    electricityCost=unitPrice*Regunits;
                }

                else {
                    System.out.println("Wrong Customer Type");
                }
            }


            else if (Objects.equals(meterType, "3-phase")) {

                if (Objects.equals(cusType, "Domestic")) {
                    unitPrice=8;
                    peakUnitPrice=12;
                    electricityCost=((unitPrice*Regunits)+(peakUnitPrice*PeakUnits));

                }

                else if (Objects.equals(cusType, "Commercial")) {
                    unitPrice = 18;
                    peakUnitPrice = 25;
                    electricityCost=((unitPrice*Regunits)+(peakUnitPrice*PeakUnits));

                }

                else {
                    System.out.println("Wrong Customer Type");
                }

            }


            else
            {
                System.out.println("Wrong Phase");
            }
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


        return electricityCost;


    }
        public static int billingSystem(String fileName) throws IOException
    {
        int id=0;
        LocalDate currentDate = LocalDate.now();
        Month currentMonthName = currentDate.getMonth();
        int currMeterReadingReg=0;
        int currMeterReadingPeak=0;
        String readingEntryDate="";
        double costOfElectricity=0.0;
        float salesTaxAmount=0;
        double fixedCharge=0.0;
        double totalBillingCharge=0.0;
        String dueDate="";
        boolean billPaidStatus=false;
        String billPaymentDate="";
        String line="";
        String meterType="";
        String cusType="";
        int cusRegUnitConsumed=0;
        int cusPeakUnitConsumed=0;
        int currentRegUnits=0;
        int currentPeakUnits=0;
        double tax=0;





        File file = new File("CustomerInfo.txt");
        Scanner scanner = new Scanner(file);
        FileWriter myWriter = new FileWriter(fileName, true);


        // Iterate over each line in the file
        while (scanner.hasNextLine()) {


            line = scanner.nextLine();
            String[] userData = line.split(",", 9);
            id=Integer.parseInt(userData[0]);
            meterType=userData[5];
            cusType=userData[3];
            cusRegUnitConsumed=Integer.parseInt(userData[8]);
            cusPeakUnitConsumed=Integer.parseInt(userData[9]);



            if(Objects.equals(meterType, "1-phase"))
            {
                System.out.print("Enter Current Meter Reading (Regular): ");
                int currentReadingRegular = scanner.nextInt();
                scanner.nextLine();

                // Validate input
                if (currentReadingRegular < 0) {
                    System.out.println("Meter reading cannot be negative!");
                } else {
                    System.out.println("Regular Meter Reading: " + currentReadingRegular);
                }
                currentRegUnits=cusRegUnitConsumed-currentReadingRegular;
                costOfElectricity=getElectricityCost(cusType,meterType,currentRegUnits,currentPeakUnits);
                salesTaxAmount=getSalesTax(cusType,meterType);
                fixedCharge=getFixCharges(cusType,meterType);
                tax = costOfElectricity*(salesTaxAmount/100);
                costOfElectricity=costOfElectricity+tax;
                totalBillingCharge=costOfElectricity+fixedCharge;
            } else if (Objects.equals(meterType, "3-phase")) {
                // Get current regular reading
                System.out.print("Enter Current Meter Reading (Regular): ");
                int currentReadingRegular = scanner.nextInt();
                scanner.nextLine();

                // Get current peak reading (for 3-phase)
                System.out.print("Enter Current Meter Reading (Peak): ");
                int currentReadingPeak = scanner.nextInt();
                scanner.nextLine();

                // Validate input
                if (currentReadingRegular < 0 || currentReadingPeak < 0) {
                    System.out.println("Meter readings cannot be negative!");
                } else {
                    System.out.println("Regular Meter Reading: " + currentReadingRegular);
                    System.out.println("Peak Meter Reading: " + currentReadingPeak);
                }
                currentRegUnits=(cusRegUnitConsumed-currentReadingRegular);
                costOfElectricity=getElectricityCost(cusType,meterType,currentRegUnits,currentPeakUnits);
                salesTaxAmount=getSalesTax(cusType,meterType);
                fixedCharge=getFixCharges(cusType,meterType);
                tax = costOfElectricity*(salesTaxAmount/100);
                costOfElectricity=costOfElectricity+tax;
                totalBillingCharge=costOfElectricity+fixedCharge;
            }
            else
            {
                System.out.println("Wrong Phase:");
            }
            System.out.println("Enter Reading Entry Date(DD/MM/YYYY): ");
            readingEntryDate = scanner.nextLine();
            dueDate=getDueDate(readingEntryDate);







            line = id + "," +currentMonthName + "," + currMeterReadingReg + "," + currMeterReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," +dueDate + "," +billPaidStatus + "," +billPaymentDate;// Write the line to the file
          //  myWriter.write(line+System.lineSeparator());
            // Close the writer after writing is done
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        }

        scanner.close();

        return 0;
    }
}
