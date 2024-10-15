import java.text.ParseException;
import java.util.*;
import java.io.IOException;


public class Main1 {

    public int Supermenu(int choice) throws IOException {
        System.out.println("============================================");
        System.out.println("|            WELCOME TO MAIN MENU          |");
        System.out.println("============================================");
        System.out.println("|  Press (1) to enter as Customer          |");
        System.out.println("|  Press (2) to enter as Employee          |");
        System.out.println("|  Press (3) to Exit                       |");
        System.out.println("============================================");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        sc.nextLine(); // Consumes the newline character

        return choice;
    }

    public int menu1() {
        System.out.println("============================================");
        System.out.println("|            CUSTOMER MENU                 |");
        System.out.println("============================================");
        System.out.println("|  Enter (1) to enter Customer Info        |");
        System.out.println("|  Enter (2) to view Bill                  |");
        System.out.println("|  Enter (3) to update Expiry              |");
        System.out.println("|  Enter -1 to Exit                        |");
        System.out.println("============================================");

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner1.nextInt();
        scanner1.nextLine(); // Consumes the newline character

        return choice;
    }

    public int menu2() {
        System.out.println("============================================");
        System.out.println("|            EMPLOYEE MENU                 |");
        System.out.println("============================================");
        System.out.println("|  Enter (1) to Change Password            |");
        System.out.println("|  Enter (2) to Update Tariff Info         |");
        System.out.println("|  Enter (3) to Meter Operations           |");
        System.out.println("|  Enter (4) to View Paid/Unpaid Bills     |");
        System.out.println("|  Enter (5) to View Expiry Date           |");
        System.out.println("|  Enter (6) reset Terrif data             |");
        System.out.println("|  Enter (7) View any particular Bill      |");
        System.out.println("|  Enter (8) Add Employee                  |");
        System.out.println("|  Enter -1 to Exit                        |");
        System.out.println("============================================");

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner1.nextInt();
        scanner1.nextLine(); // Consumes the newline character

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
        Main1 mainObj = new Main1();
        // Creating objects
        FileOperations fileOperations = new FileOperations(null);
        CustomerOperations customerOperations = new CustomerOperations(null);
        fileOperations= new FileOperations(customerOperations);
        TeriffInfo teriffInfo = new TeriffInfo();
        MeterOperations meterOperations = new MeterOperations(null);
        customerOperations=new CustomerOperations(meterOperations);
        meterOperations=new MeterOperations(customerOperations);
        BillingOperations billingOperations=new BillingOperations(meterOperations);

        EmployeeOperations employeeOperations = new EmployeeOperations();
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
                   // customerOperations.customerInfo();
                }
                break;
                case 2: {
                    showBill.showBill();
                }
                break;
                case 3: {
                  //  employeeOperations.updateExpiry();
                }
                break;
                case -1:
                {
                    return;
                }
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
                   // teriffInfo.TariffTaxUpdate("TariffTaxInfo.txt");
                }
                break;
                case 3: {
                    meterOperations.meterOperations();
                }
                break;
                case 4: {
                    employeeOperations.paidUnpaidreport();
                }
                break;
                case 5: {
                    employeeOperations.viewExpiringCNIC();
                }
                break;
                case 6:
                {
                    TeriffInfo.TariffTaxSystem("TeriffTaxInfo.txt");
                }
                break;
                case 7:
                {
                    showBill.showBill();
                }
                break;
                case 8:
                {
                   // employeeOperations.addEmployee("EmployeesData.txt");
                }
                break;
                case -1:
                {
                    return;
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