import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class MeterOperations extends JFrame{
   //private final BillingOperations billingSystem=new BillingOperations();
    private final ShowBill showBill=new ShowBill();
   private final CustomerOperations customerSystem;
    MeterOperations(CustomerOperations customerSystem)
    {
       this.customerSystem=customerSystem;

    }
<<<<<<< HEAD

=======
>>>>>>> 1e6e73842a9a5b62a4432e7fea8310d4a71d6b3b


    public void clearScreen() throws InterruptedException {


        Thread.sleep(1900);

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }
    public void  meterReading(int id,long CNIC,String meterType,int peakUnits,int regularUnits,String date,boolean statusDate) throws IOException {
        //showBill.billingSystem("BillingInfo.txt");
//        int id=0;
//        long CNIC=0;
//        String meterType = "";
//        System.out.println("Enter your Customer ID:\n");
//        Scanner scanner = new Scanner(System.in);
//        id = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Enter 13-digit number without dashes:\n");
//        CNIC = Long.parseLong(scanner.nextLine());
//        System.out.println("Enter meter type:\n");
//        meterType = scanner.nextLine();

        if(showBill.customerCheck(id, CNIC,meterType)) {
            System.out.println("In ifcv\n"+meterType);
            if(Objects.equals(meterType, "1-phase"))
            {
                dispose();
                if(true) {
                    int regUnits = regularUnits;
                    String entryDate = date;
                    boolean status = statusDate;

                    showBill.billingSystem1( id,meterType, regUnits, -1,entryDate,status);

                }
                else
                {
                    System.out.println("Not submitted\n");
                }




            }
            else if(Objects.equals(meterType,"3-phase"))
            {
                dispose();
                    int regUnits = regularUnits;
                    String entryDate = date;
                    boolean status = statusDate;
                    int currpeakUnits=peakUnits;

                    System.out.println("Before show Bill");
                    showBill.billingSystem1( id,meterType, regUnits, currpeakUnits,entryDate,status);



            }
            else
            {
                System.out.println("Wrong Meter\n");
            }
            //showBill.billingSystem1(id,meterType);
       }
        else {
            System.out.println("Customer does not exist");
        }


    }
public void  nadOperation(String CNIC)
    {
//        String dayOfWeek="";
//        String month="";
//        int year=0;
//        String yearString="";
//        String expiryDate="";
//
//        LocalDate currentDate = LocalDate.now();
//
//        dayOfWeek = currentDate.getDayOfWeek().toString();
//
//         month = currentDate.getMonth().toString();
//         year = currentDate.getYear() + 50;
//         yearString = String.valueOf(year);
//         expiryDate =  yearString+"/" + month +"/"+dayOfWeek ;

        int dayOfWeekNumber=0;
        int monthNumber=0;
        int year = 0;
        String expiryDate = "";
        String currDate="";


        LocalDate currentDate = LocalDate.now();


        dayOfWeekNumber = currentDate.getDayOfWeek().getValue();
        monthNumber = currentDate.getMonthValue();
        year = currentDate.getYear() + 50;


        currDate = (year-50) + "-" + monthNumber + "-" + dayOfWeekNumber ;
        expiryDate = year + "-" + monthNumber + "-" + dayOfWeekNumber;


        try (
            BufferedWriter bw = new BufferedWriter(new FileWriter("NADRADB.txt",true)))
        {
            bw.write(CNIC+","+currDate+","+expiryDate+System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<String> readFile(String fileName,ArrayList<String> dataList,String line) throws FileNotFoundException {
        System.out.println("WellCome to readFile function\n");
        File inputFile = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        try {

            while ((line = reader.readLine()) != null) {
                dataList.add(line); // Add each line to the ArrayList
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("Data in the list before modification");
//        for (String data : dataList) {
//            System.out.println(data);
//        }

        return dataList;




    }

    public void writeFile(String fileName,ArrayList<String>dataList)
    {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : dataList) {
                bw.write(line);
                bw.newLine(); // Adds a newline after each line of data
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void allocateMeter(String cnic) throws FileNotFoundException {

        System.out.println("WellCome to Meter Allocation department");



        String fileName="CustomerInfo.txt";
        String line="";String line1="";
        String customerCNIC="";
        boolean flag=false;
        String chek="";
        int meterCounter=0;
        int coutner=0;
        ArrayList<String> dataList = new ArrayList<>();



        Scanner scan = new Scanner(System.in);

//        System.out.println("Enter CNIC");
//        String cnic = scan.nextLine();

        File inputFile = new File(fileName);
        File tempFile = new File("temp_" + fileName);

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                Scanner scanner1 = new Scanner(System.in)
        )
        {
            dataList=readFile("CustomerInfo.txt",dataList,line);


            while ((line1 = reader.readLine()) != null) {

                System.out.println("\n\nin while\n\n ");

                System.out.println("Line:"+line1);
                String[] userData = line1.split(",");
                customerCNIC = userData[1];


                if (cnic.equals(customerCNIC)) {

                    coutner++;
                    System.out.println("CNIC by cus:"+cnic+"  Cnic by file "+customerCNIC+"\n");
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
            if(coutner<3)
            {
                System.out.println("In NandIf");
                new CustomerInfoInput();
                //customerSystem.customerInfo("CustomerInfo.txt");
                nadOperation(customerCNIC);

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not Allowed! Maximum 3 meters allowed per CNIC " );
               // System.out.println("\"Not Allowed! Maximum 3 meters allowed per CNIC\n");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void meterOperations() throws IOException, InterruptedException {


        System.out.println("Welcome to MeterOperations");

        String line = "";
        String name="";
        String password="";
        boolean userFound = false;
        String fileName="EmployeesData.txt";
        Scanner scanner1 = new Scanner(System.in);
        int choice=0;


        System.out.println("Enter the userName of the Employee:");
        name = scanner1.nextLine();
        System.out.println("Enter the password of the Employee:");
        password = scanner1.nextLine();



        File inputFile = new File(fileName);

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        )
        {


            while ((line = reader.readLine()) != null) {


                String[] userData = line.split(",", 2);


                if (userData.length == 2 && name.equals(userData[0])) {
                    if (password.equals(userData[1])) {
                      userFound=true;
                    }
                }

            }

            if (!userFound) {
                System.out.println("User not found or old password incorrect.");
            } else {
                System.out.println("Employee Found");
               // clearScreen();
                System.out.println("Press (1) to allocate Meter\nPress (2) to view add Meter reading\nPress (3) to exit");
                choice=scanner1.nextInt();
                switch (choice) {
                    case 1:
                      //  allocateMeter();
                    break;
                    case 2:
                     //   meterReading();
                    default:
                    break;

                }



            }
        }
    }
}