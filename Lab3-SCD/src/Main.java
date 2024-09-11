import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int menu(int choice)
    {


        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter 1 to Create File \nEnter 2 to Write file\nEnter 3 to Read file\nEnter 4 to exit\n");
        choice = scanner1.nextInt();
        scanner1.nextLine();


        return choice;
    }

    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");
        int choice=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to execute first code \nEnter 2 to execute second code \n");
        choice=sc.nextInt();
        if(choice==1){
            System.out.println("Welcome to the first code \n");
            Q1 q1 = new Q1();
            q1.readFile();
        }
        else if(choice==2){
            fileHanling file=new fileHanling();

            System.out.println("Welcome to the second code \n");
            choice=menu(choice);
            if(choice==1){
                String filename="";
                Scanner scanner=new Scanner(System.in);
                System.out.println("Enter the file name");
                filename=scanner.nextLine();
                 file.createFile(filename);




            }
            else if(choice==2){
                String fileName="";
                Scanner scanner2 = new Scanner(System.in);

                file.writeFileQ2();


            }
            else if(choice==3){
                String filename="";
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Enter the file name");
                filename=scanner3.nextLine();
                file.readFile(filename);



            }
            else if(choice==4){

            }
            else{
                System.out.println("Invalid choice");
            }

        }
        else {
            System.out.println("Invalid choice");
        }


    }
}