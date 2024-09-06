import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//import ;

public class Main {
    public static int menu(int choice)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to Create File \nEnter 2 to Write file\nEnter 2 to Read file");
         choice = scanner.nextInt();
        return choice;
    }
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        int choice=0;
        choice=menu(choice);
        System.out.printf("Choice is :"+choice);


       

        try {
            File file = new File("EmployeesData.txt");
            if(file.createNewFile())
            {
                System.out.println("File Created");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("EmployeesData.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
}
}