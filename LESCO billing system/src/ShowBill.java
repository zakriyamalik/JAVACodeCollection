import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ShowBill {
    public static String readBillingFile(int Id,String meterType) throws FileNotFoundException
    {
        String line="";
        String []userData;
        int peakUnits=0;
        ArrayList<String> record=new ArrayList<>();
        try {

            File myObj = new File("BillingInfo.txt");

            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {


                String data = myReader.nextLine();
                userData = data.split(",");
                System.out.println("Data is:\n");
                peakUnits= Integer.parseInt(userData[4]);
                for(int i=0;i<userData.length;i++)
                {
                    System.out.println("userData["+i+"]="+userData[i]);
                }

                if(userData[0].equals(String.valueOf(Id)) )
                {
                    if(peakUnits==0 && Objects.equals(meterType, "1-phase"))
                    {
                        System.out.println("Record found for Phase-1 meter\n");
                        return data;


                    }
                    else if(peakUnits!=0 && Objects.equals(meterType, "3-phase"))
                    {
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


        }

        catch (FileNotFoundException e) {


            System.out.println("An error occurred.");
            e.printStackTrace();


        }

        return null;
    }
    public static void showBill()
    {
        int id=0;
        long CNIC=0;
        String meterType="";
        int currMeterReading=0;
        String []userData;
        String []taxData;
        int fileId=0;
        long fileCNIC=0;
        String fileMeterType="";
        String fileCusType="";
        int electricityCost=0;
        float tax=0;
        int fixedCharges=0;
        boolean billStatus=false;
        String dueDate="";
        String filPhoneNo="";
        String fileAddress="";




//        System.out.println("Enter your Customer ID:\n");
//        Scanner scanner = new Scanner(System.in);
//        id=scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Enter 13-digit number without dashes:\n");
//        CNIC=Long.parseLong(scanner.nextLine());
//
//        System.out.println("Enter meter type:\n");
//        meterType=scanner.nextLine();
//
//        System.out.println("Enter current meter reading:\n");
//        currMeterReading=Integer.parseInt(scanner.nextLine());

        try {

            File myObj = new File("CustomerInfo.txt");
            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                userData=line.split(",");
                fileCusType=userData[4];
                fileId=Integer.parseInt(userData[0]);
                fileCNIC=Long.parseLong(userData[1]);
                fileMeterType=userData[5];
                System.out.println("Data is\n");
                for(int i=0;i<userData.length;i++)
                {
                    System.out.println("userData["+i+"]="+userData[i]);
                }

                System.out.println(fileId+fileCNIC+fileMeterType+"\n");
                if((id==fileId||CNIC==fileCNIC)|| meterType.equals(fileMeterType))
                {
                    fileCusType=userData[4];
                    fileId=Integer.parseInt(userData[0]);
                    fileCNIC=Long.parseLong(userData[1]);
                    fileMeterType=userData[5];
                    fileAddress=userData[2];
                    fileAddress=userData[3];
                    System.out.println("User Found\n");
                    System.out.println(line);
                    line=readBillingFile(id,fileMeterType);
                    System.out.println(line);
                    assert line != null;
                    taxData=line.split(",");
//                    int electricityCost=0;
//                    float tax=0;
//                    int fixedCharges=0;
                    electricityCost=Integer.parseInt(taxData[5]);
                    tax=Float.parseFloat(taxData[6]);
                    fixedCharges=Integer.parseInt(taxData[7]);
                    billStatus= Boolean.parseBoolean(taxData[10]);
                    dueDate=taxData[9];
                 //   line = id + "," +currentMonthName + "," + currentReadingRegular
                //   + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," +dueDate + "," +billPaidStatus + "," +dueDate;// Write the line to the file






                }


                for(int i=0;i<userData.length;i++)
                {
                    System.out.println("userData["+i+"] "+userData[i]+" ");
                }

            }


            myReader.close();


        }

        catch (FileNotFoundException e) {


            System.out.println("An error occurred.");
            e.printStackTrace();


        }





    }
}
