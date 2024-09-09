import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeOperations {
    public static void paidUnpaidreport(String inputFile) {
        System.out.println("Paid Unpaid Report");


        String name = "";
        String password = "";
        boolean status = false;
        String line;
        boolean userFound = false;
        ArrayList<String> unPaid=new ArrayList<>();
        ArrayList<String> paid=new ArrayList<>();
        ArrayList<String> totalBills=new ArrayList<>();


        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                Scanner scanner1 = new Scanner(System.in)
        ) {


            System.out.println("Enter the userName of the Employee:");
            name = scanner1.nextLine();
            System.out.println("Enter the password of the Employee:");
            password = scanner1.nextLine();


            while ((line = reader.readLine()) != null) {


                String[] userData = line.split(",", 2);


                if (userData.length == 2 && name.equals(userData[0])) {
                    if (password.equals(userData[1])) {
                        System.out.println("User Found\n");


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








                        userFound = true;
                    }
                }



            }
            if (!userFound) {
                System.out.println("User not found or Password incorrect.");
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
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewExpiringCNIC(String inputFile) throws ParseException {
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



        
        LocalDate currentDate = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        currDate = currentDate.toString();
        d1 = sdf.parse(currDate);


        LocalDate futureDate = currentDate.plusDays(30);
        datePlus30Days = futureDate.toString();
        d2 = sdf.parse(datePlus30Days);



        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                Scanner scanner1 = new Scanner(System.in)
        ) {


            System.out.println("Enter the userName of the Employee:");
            name = scanner1.nextLine();
            System.out.println("Enter the password of the Employee:");
            password = scanner1.nextLine();


            while ((line = reader.readLine()) != null) {

                String[] userData = line.split(",", 2);

                if (userData.length == 2 && name.equals(userData[0])) {
                    if (password.equals(userData[1])) {
                        System.out.println("User Found\n");

                        try (
                                BufferedReader readerBill = new BufferedReader(new FileReader("NADRADB.txt"));
                        ) {

                            while ((line = readerBill.readLine()) != null) {

                                String[] dbData = line.split(",");
//                                System.out.println("Data is :\n");
//                                for(int i=0; i<dbData.length; i++) {
//                                    System.out.println("dbData["+i+"] : "+dbData[i]);
//                                }
                                expiryDate=dbData[2];
                                d3=sdf.parse(expiryDate);
//
                                if (d2.compareTo(d3) > 0)
                                {
                                   // System.out.println(sdf.format(d2) + " (d1 + 30 days) is after " + expiryDate);
                                    System.out.println(line);
                                }


                            }

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        userFound = true;
                    }
                }

            }
            if (!userFound) {
                System.out.println("User not found or Password incorrect.");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
