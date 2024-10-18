import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class FileOperations {
    private boolean flage;
    private String filename;

    public boolean isFlage() {
        return flage;
    }

    public void setFlage(boolean flage) {
        this.flage = flage;
    }

//    public String getFilename() {
//        return filename;
//    }
//
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }

    public CustomerOperations getCustomerOperations() {
        return customerOperations;
    }

    public void setCustomerOperations(CustomerOperations customerOperations) {
        this.customerOperations = customerOperations;
    }

    public CustomerOperations customerOperations ;
    FileOperations(CustomerOperations customerOperations) {
        this.customerOperations = customerOperations;
    }
    public static boolean checkCnic(String cnic) {
        boolean flage=false;
        if(cnic.length()==13)
        {
            flage=true;
        }
        else
        {
            flage=false;
        }
        return flage;
    }
    public void createFile(String filename)
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
    public void writeFile(String filename) throws FileNotFoundException {


        if(Objects.equals(filename, "EmployeesData.txt")) {


            Scanner scanner = new Scanner(System.in);
            String name = "";
            String password = "";
            System.out.println("Enter the userName of the Employee");
            name = scanner.next();
            boolean check = customerOperations.checkUserName(filename, name);


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

}
