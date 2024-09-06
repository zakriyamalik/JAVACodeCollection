import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//import ;

public class Main {
    public static int changePassword(String fileName) {
        String name = "";
        String password = "";
        String line = "";
        String[] userData;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the userName of the Employee");
        name = scanner.next();
        System.out.println("Enter the password of the Employee");
        password = scanner.next();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            // System.out.println("Line: " + line);
            userData = line.split(",", 2);
            if (name.equals(userData[0])&&password.equals(userData[1])) {

            } else {
                System.out.println("\nIn Else statement Name:" + name + " userData: " + userData[0] + "\n");
                continue;
            }

            scanner.close();

        }
        return 1;
    }
    public static int menu(int choice)
    {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter 1 to Create File \nEnter 2 to Write file\nEnter 3 to Read file\nEnter 4 to change Password");
        choice = scanner1.nextInt();
        scanner1.nextLine();

        //scanner1.close();

        return choice;
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
        Scanner scanner = new Scanner(System.in);
        String name="";
        String password="";
        System.out.println("Enter the userName of the Employee");
        name=scanner.next();
       boolean check= checkUserName(filename,name);
       if(check)
       {
           System.out.println("Enter the password of the Employee");
           password=scanner.next();
           try {
               FileWriter myWriter = new FileWriter(filename,true);

               myWriter.write(name+","+password+System.lineSeparator());
               myWriter.close();
               System.out.println("Successfully wrote to the file.");
           } catch (IOException e) {
               System.out.println("An error occurred.");
               e.printStackTrace();
           }
       }
       else
       {
           System.out.println("User Name already exists");

       }
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
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
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
            default:
                System.out.println("Enter correct name of the file");
        }


    }
}