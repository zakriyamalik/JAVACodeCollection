import java.io.*;
import java.util.Scanner;

public class TeriffInfo {

    public static void editTerrifFile(String fileName)
    {
        String line="";
        int counter=0;
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            //bw.write(CNIC+","+currDate+","+expiryDate+System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            Scanner sc = new Scanner(br);
            while(sc.hasNextLine())
            {

                counter++;

            }
            if(counter==4)
            {

            }
            else
            {
                System.out.println("Lines have to be 4 but they are"+counter);
            }



        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static void TariffTaxUpdate(String fileName) {
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
