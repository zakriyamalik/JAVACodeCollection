import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.time.Month;
import java.time.*;
import java.util.*;



public class BillingOperations {
   private final MeterOperations mt;
    BillingOperations(MeterOperations mt)
    {
        this.mt=mt;
    }
    public void viewBill(String fileName) throws FileNotFoundException {
        String line = "";
        String name = "";
        String password = "";
        boolean userFound = false;
        String empFileName = "EmployeesData.txt";
        Scanner scanner1 = new Scanner(System.in);
        int fileId = 0;
        int id=0;
        ArrayList<String> dataList = new ArrayList<>();



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
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Enter User ID:\n");
                id=scanner2.nextInt(); 
                scanner2.nextLine();

                dataList= mt.readFile("BillingInfo.txt",dataList,line);
                for (String s : dataList) {
                    
                    assert false;
                    String[] userData = s.split(",");
                    fileId = Integer.parseInt(userData[0]);
                    if (id == fileId) {
                        System.out.println("Id found\n");
                        System.out.println(s+"\n");
                    }
                    else
                    {
                        System.out.println("ID not found\n");
                    }
                }


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void updateRegUnits(int id,int units) throws FileNotFoundException {

        System.out.println("WellCome to updateRegUnits\n");



        String fileName="CustomerInfo.txt";
        String line="";String line1="";
        int customerId=0;
        boolean flag=false;
        String chek="";
        int meterCounter=0;
        int coutner=0;
        ArrayList<String> dataList = new ArrayList<>();



        Scanner scan = new Scanner(System.in);



        File inputFile = new File(fileName);

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        )
        {
            dataList= mt.readFile("CustomerInfo.txt",dataList,line);


            while ((line1 = reader.readLine()) != null) {

                System.out.println("\n\nin while\n\n ");

                System.out.println("Line1:"+line1);
                String[] userData = line1.split(",");
                customerId = Integer.parseInt(userData[0]);



                if (id==customerId) {


                    System.out.println("In famouse If User data\n" + userData[7]);

                    System.out.println("In famouse else\n" + units);
                    userData[7] = String.valueOf(units);
                    line1 = String.join(",", userData);
                    System.out.println("Line2:"+line1+"\nCounter"+coutner);
                    dataList.set(coutner,line1);


                    System.out.println("Data in the list after modification");
                    for (String data : dataList) {
                        System.out.println(data);
                    }

                    mt.writeFile("CustomerInfo.txt",dataList);
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
//                    writer.write(line + System.lineSeparator());
                }
                else
                {
                    System.out.println("\nNo user found\n");
                }


            coutner++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public  String getDueDate(String readingEntryDate)
    {
        System.out.println("\nPhase-1\n");
        System.out.println(readingEntryDate);
        String[] dateEntries = readingEntryDate.split("/", 3);
        int day = Integer.parseInt(dateEntries[0]);
        int month = Integer.parseInt(dateEntries[1]);
        int year = Integer.parseInt(dateEntries[2]);
        String stDay="";
        String stYear="";
        String stMonth="";
        String dueDate="";
        YearMonth yearMonth = YearMonth.of(year, month);
        int maxDaysInMonth = yearMonth.lengthOfMonth();


        day += 7;


        if (day > maxDaysInMonth) {
            day = day - maxDaysInMonth;
            month++;

            if (month > 12) {
                month = 1;
                year++;
            }
        }


        stDay = String.valueOf(day);
        stYear = String.valueOf(year);
        stMonth = String.valueOf(month);
        dueDate=stDay+"/"+stYear+"/"+stMonth;


        return dueDate;
    }

    public  float getFixCharges(String cusType,String meterType)
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
                    fixCharges=Float.parseFloat(tariffData[4]);

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



    public float getSalesTax(String cusType,String meterType)
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
    public int getElectricityCost(String cusType, String meterType, Integer RegUnits, Integer PeakUnits) {

        RegUnits = (RegUnits == null) ? 0 : RegUnits;
        PeakUnits = (PeakUnits == null) ? 0 : PeakUnits;

        return calculateCost(cusType, meterType, RegUnits, PeakUnits);
    }


    public int calculateCost(String cusType, String meterType,int Regunits,int PeakUnits) {


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

}
