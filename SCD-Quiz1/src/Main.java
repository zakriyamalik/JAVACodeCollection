import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Test ts = new Test();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Enter 1 to insert\nEnter 2 to show\nEnter 3 to exit");
            choice = sc.nextInt();
            if (choice == 1) {
                ts.add();
            } else if (choice == 2) {
                ts.showall();
            }

            else if(choice==3)
            {
                break;
            } else if (choice==4) {
                ts.search();
            }
            else if(choice==5)
            {
                ts.remove();
            }
        } while (choice != 3);

    }
}

