import java.text.ParseException;
import java.util.*;
import java.io.IOException;


public class Main {


    public  int Supermenu(int choice)
    {
        System.out.println("\nIn superMenu\n");
        System.out.println("Press(1) to enter as Customer\nPress(2) to enter as an Employee\nPress(3) to exit");

        Scanner sc = new Scanner(System.in);
        choice=sc.nextInt();
        sc.nextLine();
       return choice;
    }
    public int menu1()
    {

        Scanner scanner1 = new Scanner(System.in);
        System.out.println(
                "Enter 1 to enter Customer Info\n" +
                        "Enter 2 to view bill\n" +
                        "Enter 3 to update Expiry\n"

        );
        int choice = scanner1.nextInt();
        scanner1.nextLine();
        return choice;
    }

    public int menu2()
    {

        Scanner scanner1 = new Scanner(System.in);
        System.out.println(
//                       "Enter 1 to Create File \n" +
//                        "Enter 2 to Write file\n" +
//                        "Enter 3 to Read file\n" +

                        "Enter 1 to change Password\n" +
                        "Enter 2 to update Terrif info\n" +
      //                  "Enter 3 to add Terrif Info\n" +
                        "Enter 3 to proceed as an Employee for Meter operations\n" +
                        "Enter 4 to view Paid UnPaid bill\n" +
                        "Enter 5 to view Expiry Date\n"
                      //  +"Enter 6 to reset Tariff Tax"
        );
        int choice = scanner1.nextInt();
        scanner1.nextLine();
        return choice;
    }




//
//
//    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
//
//
//        System.out.printf("Hello and welcome!\n");
//        int choice=0;
//        String fileName;
//        Scanner scanner = new Scanner(System.in);
//        choice=menu(choice);
//
//
//        switch (choice)
//        {
//            case 1:
//            {
//                System.out.println("Enter the name of the file");
//                fileName=scanner.nextLine();
//                FileOperations.createFile(fileName);
//
//            }
//            break;
//            case 2:
//            {
//                System.out.println("Enter the name of the file");
//                fileName=scanner.next();
//                FileOperations.writeFile(fileName);
//            }
//            break;
//            case 3:
//            {
//                System.out.println("Enter the name of the file");
//                fileName=scanner.next();
//                FileOperations.readFile(fileName);
//            }
//            break;
//            case 4:
//            {
//                System.out.println("Enter the name of the file");
//                fileName=scanner.next();
//                CustomerOperations.changePassword(fileName);
//            }
//            break;
//            case 5:
//            {
////                System.out.println("Enter the name of the file");
////                fileName=scanner.next();
//                CustomerOperations.customerInfo("CustomerInfo.txt");
//            }
//            break;
//            case 6:
//            {
////                System.out.println("Enter the name of the file");
////                fileName=scanner.next();
//                //BillingSystem.billingSystem("BillingInfo.txt");
//                TeriffInfo.TariffTaxUpdate("TeriffTaxInfo.txt");
//            }
//            break;
//            case 7:
//            {
////                System.out.println("Enter the name of the file");
////                fileName=scanner.next();
//                  TeriffInfo.TariffTaxSystem("TeriffTaxInfo.txt");
//            }
//            break;
//            case 8:
//            {
//                MeterOperations.meterOperations();
//            }
//            break;
//            case 9:
//            {
//                ShowBill.showBill();
//                //ShowBill.readBillingFile(7078);
//            }
//            break;
//            case 10:
//            {
//                EmployeeOperations.paidUnpaidreport("EmployeesData.txt");
//
//            }
//            break;
//            case 11:
//            {
//                EmployeeOperations.viewExpiringCNIC("EmployeesData.txt");
//
//            }
//            break;
//            case 12:
//            {
//                EmployeeOperations.updateExpiry();
//
//            }
//            break;
//            default:
//                System.out.println("Enter correct name of the file");
//        }
//
//
//    }
//
//


    public static void main(String[] args) throws IOException, InterruptedException, ParseException {

        System.out.printf("\nالسلام على من اتَّتع الهذى\n\n\n");
        int choice = 0;
        Main mainObj = new Main();
        // Creating objects
        FileOperations fileOperations = new FileOperations();
        CustomerOperations customerOperations = new CustomerOperations();
        TeriffInfo teriffInfo = new TeriffInfo();
        MeterOperations meterOperations = new MeterOperations();
        BillingOperations billingOperations=new BillingOperations(meterOperations);

        EmployeeOperations employeeOperations = new EmployeeOperations(meterOperations);
        ShowBill showBill = new ShowBill();

        String fileName;
        Scanner scanner = new Scanner(System.in);
        choice = mainObj.Supermenu(choice);
        System.out.println("Choice is:"+choice+"\n");
        if (choice == 1)
        {
//
            choice=mainObj.menu1();
            switch (choice) {
                case 1: {
                    customerOperations.customerInfo("CustomerInfo.txt");
                }
                break;
                case 2: {
                    showBill.showBill();
                }
                break;
                case 3: {
                    employeeOperations.updateExpiry();
                }
                break;
                default:
                    System.out.println("Invalid choice");

            }

        }
        else if (choice == 2)
        {

            choice=mainObj.menu2();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the name of the file");
                    fileName = scanner.next();
                    customerOperations.changePassword(fileName);
                }
                break;
                case 2: {
                    teriffInfo.TariffTaxUpdate("TariffTaxInfo.txt");
                }
                break;
                case 3: {
                    meterOperations.meterOperations();
                }
                break;
                case 4: {
                    employeeOperations.paidUnpaidreport("EmployeesData.txt");
                }
                break;
                case 5: {
                    employeeOperations.viewExpiringCNIC("EmployeesData.txt");
                }
                break;
                case 6:
                {
                    TeriffInfo.TariffTaxSystem("TeriffTaxInfo.txt");
                }
                default:
                    System.out.println("Invalid choice");

            }


        }
        if(choice==3)
        {
            return;
        }

//
//        switch (choice) {
//            case 1: {
//                System.out.println("Enter the name of the file");
//                fileName = scanner.nextLine();
//                fileOperations.createFile(fileName);
//            }
//            break;
//            case 2: {
//                System.out.println("Enter the name of the file");
//                fileName = scanner.next();
//                fileOperations.writeFile(fileName);
//            }
//            break;
//            case 3: {
//                System.out.println("Enter the name of the file");
//                fileName = scanner.next();
//                fileOperations.readFile(fileName);
//            }
//            break;
//            case 4: {
//                System.out.println("Enter the name of the file");
//                fileName = scanner.next();
//                customerOperations.changePassword(fileName);
//            }
//            break;
//            case 5: {
//                customerOperations.customerInfo("CustomerInfo.txt");
//            }
//            break;
//            case 6: {
//                teriffInfo.TariffTaxUpdate("TeriffTaxInfo.txt");
//            }
//            break;
//            case 7: {
//                teriffInfo.TariffTaxSystem("TeriffTaxInfo.txt");
//            }
//            break;
//            case 8: {
//                meterOperations.meterOperations();
//            }
//            break;
//            case 9: {
//                showBill.showBill();
//            }
//            break;
//            case 10: {
//                employeeOperations.paidUnpaidreport("EmployeesData.txt");
//            }
//            break;
//            case 11: {
//                employeeOperations.viewExpiringCNIC("EmployeesData.txt");
//            }
//            break;
//            case 12: {
//                employeeOperations.updateExpiry();
//            }
//            break;
//            default:
//                System.out.println("Enter correct name of the file");
//        }
//

    }

}