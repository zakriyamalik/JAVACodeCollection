import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;


public class Main {



    public static int menu(int choice)
    {


        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter 1 to Create File \nEnter 2 to Write file\nEnter 3 to Read file\nEnter 4 to change Password\nEnter 5 to enter Customer Info\nEnter 6 to update Terrif info\nEnter 7 to add Terrif Info\nEnter 8 to proceed as an Employee for Meter operations");
        choice = scanner1.nextInt();
        scanner1.nextLine();


        return choice;
    }



    public static int changePassword(String fileName) throws IOException {


        System.out.println("In changePassword function\n");


        File inputFile = new File(fileName);
        File tempFile = new File("temp_" + fileName);


        try (
             BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
             Scanner scanner1 = new Scanner(System.in)
        )
        {

            String name = "";
            String password = "";
            String newPassword = "";
            String line;
            boolean userFound = false;


            System.out.println("Enter the userName of the Employee:");
            name = scanner1.nextLine();
            System.out.println("Enter the password of the Employee:");
            password = scanner1.nextLine();


            while ((line = reader.readLine()) != null) {


                String[] userData = line.split(",", 2);


                if (userData.length == 2 && name.equals(userData[0])) {
                    if (password.equals(userData[1])) {
                        System.out.println("Enter New password of the Employee:");
                        newPassword = scanner1.nextLine();
                        line = name + "," + newPassword;
                        userFound = true;
                    }
                }


                writer.write(line + System.lineSeparator());


            }

            if (!userFound) {
                System.out.println("User not found or old password incorrect.");
            } else {
                System.out.println("Password updated successfully.");
            }


        }


        if (!inputFile.delete()) {
            System.out.println("Could not delete the original file.");
            return 1;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename the temporary file.");
            return 1;
        }


        return 0;


    }

    public static boolean checkUserName( String fileName,String name) throws FileNotFoundException {


        String line="";
        char character='\u0000';
        String []userName;


        File file = new File(fileName);
        Scanner scanner = new Scanner(file);


        // Iterate over each line in the file
        while (scanner.hasNextLine()) {


             line = scanner.nextLine();
           // System.out.println("Line: " + line);
            userName=line.split(",",2);


            if(name.equals(userName[0])) {
                System.out.println("\nIn If statement Name:"+name+" userName: "+userName[0]+"\n");
                return false;
            }
            else
            {
                System.out.println("\nIn Else statement Name:"+name+" userName: "+userName[0]+"\n");
                continue;
            }

//            // Iterate over each character in the line
//            for (int index = 0; index < line.length(); index++) {
//                 character = line.charAt(index);
//                if(character==',')
//                {
//                    break;
//                }
//                System.out.println("Index " + index + ": " + character);
//            }
//
//            System.out.println();  // New line for clarity after each row
        }

        scanner.close();
        return true;
    }

    public static void createFile(String filename)
    {

        try {


            File file = new File( filename);
            if (file.createNewFile()) {
                System.out.println("File Created");
            }
            else
            {
                System.out.println("File already exists");
            }


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
    public static void writeFile(String filename) throws FileNotFoundException {


        if(Objects.equals(filename, "EmployeesData.txt")) {


            Scanner scanner = new Scanner(System.in);
            String name = "";
            String password = "";
            System.out.println("Enter the userName of the Employee");
            name = scanner.next();
            boolean check = checkUserName(filename, name);


            if (check) {
                System.out.println("Enter the password of the Employee");
                password = scanner.next();
                try {
                    FileWriter myWriter = new FileWriter(filename, true);

                    myWriter.write(name + "," + password + System.lineSeparator());
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
            else {

                System.out.println("User Name already exists");

            }
        }

//        else if (Objects.equals(filename, "UsersData.txt")) {
//
//
//
//
//        }


//        System.out.println("Enter the password of the Employee");
//        password=scanner.next();


    }
    public static void readFile(String filename)
    {

        try {

            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }


            myReader.close();


        }

        catch (FileNotFoundException e) {


            System.out.println("An error occurred.");
            e.printStackTrace();


        }

    }

    public static int generateCustomerId()
    {

        Random random = new Random();
        // Generate a number between 1000 and 9999 (inclusive)
        return 1000 + random.nextInt(9000);

    }


    public static int customerInfo(String fileName) throws FileNotFoundException {


        int id=generateCustomerId();
        long cnic=0;
        String address="";
        long phoneNo=0;
        String name="";
        String cusType="";
        String meterType="";
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String formattedDate = currentDate.format(formatter);
        int choice=0;
        int regUnitConsumed=0;
        int peakUnitConsumed=0;
        String userInput = "";


        System.out.println("Enter 13-digit number without dashes:\n");
        Scanner scanner = new Scanner(System.in);
        cnic=Long.parseLong(scanner.nextLine());
        System.out.println("Enter Name:\n");
        address=scanner.nextLine();
        System.out.println("Enter address:\n");
        address=scanner.nextLine();
        System.out.println("Enter Phone no:\n");
        phoneNo=scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter customer type:\n");
        System.out.println("Press (1) for Commercial\nPress (2) Domestic");
        choice=scanner.nextInt();
        if(choice==1)
        {
            cusType="Commercial";
        }
        else if(choice==2)
        {
            cusType="Domestic";
        }
        else {
            System.out.println("Invalid choice");
        }
        cusType=scanner.nextLine();
        System.out.println("Enter meter type:\n");
        System.out.println("Press (1) for 1-Phase\nPress (2) 3-Phase");
        choice=scanner.nextInt();
        if(choice==1)
        {
            meterType="1-phase";
        }
        else if(choice==2)
        {
            meterType="3-phase";
        }
        else {
            System.out.println("Invalid choice");
        }
        meterType=scanner.nextLine();



        try {


            FileWriter myWriter = new FileWriter(fileName, true);
            if(Objects.equals(meterType, "3-phase"))
            {
                System.out.println("Enter Regular Units Consumed:\n");
                regUnitConsumed=scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Peak Units Consumed:\n");
                peakUnitConsumed=scanner.nextInt();
                scanner.nextLine();
                myWriter.write(id + "," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed + System.lineSeparator());

            }
            else
            {

                System.out.println("Enter Regular Units Consumed:\n");
                regUnitConsumed=scanner.nextInt();
                scanner.nextLine();
                peakUnitConsumed=-1;
                myWriter.write(id + "," + cnic + "," + address + "," + phoneNo + "," + cusType + "," + meterType + "," + formattedDate + "," + regUnitConsumed + "," + peakUnitConsumed + System.lineSeparator());

            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        }

        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return 0;
    }







    public static void main(String[] args) throws IOException, InterruptedException {


        System.out.printf("Hello and welcome!\n");
        int choice=0;
        String fileName;
        Scanner scanner = new Scanner(System.in);
        choice=menu(choice);


        switch (choice)
        {
            case 1:
            {
                System.out.println("Enter the name of the file");
                fileName=scanner.nextLine();
                createFile(fileName);

            }
            break;
            case 2:
            {
                System.out.println("Enter the name of the file");
                fileName=scanner.next();
                writeFile(fileName);
            }
            break;
            case 3:
            {
                System.out.println("Enter the name of the file");
                fileName=scanner.next();
                readFile(fileName);
            }
            break;
            case 4:
            {
                System.out.println("Enter the name of the file");
                fileName=scanner.next();
                changePassword(fileName);
            }
            break;
            case 5:
            {
//                System.out.println("Enter the name of the file");
//                fileName=scanner.next();
                customerInfo("CustomerInfo.txt");
            }
            break;
            case 6:
            {
//                System.out.println("Enter the name of the file");
//                fileName=scanner.next();
                //BillingSystem.billingSystem("BillingInfo.txt");
                TeriffInfo.TariffTaxUpdate("TeriffTaxInfo.txt");
            }
            break;
            case 7:
            {
//                System.out.println("Enter the name of the file");
//                fileName=scanner.next();
                  TeriffInfo.TariffTaxSystem("TeriffTaxInfo.txt");
            }
            break;
            case 8:
            {
                MeterOperations.meterOperations();
            }
            break;
            default:
                System.out.println("Enter correct name of the file");
        }


    }
}