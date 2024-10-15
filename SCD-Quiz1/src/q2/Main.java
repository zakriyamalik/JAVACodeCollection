package q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Test ts = new Test();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Enter 1 to insert\nEnter 2 to show\nEnter 3 to exit");
            choice = sc.nextInt();
            if (choice == 1) {
                ts.addUser();
            } else if (choice == 2) {
                ts.showUser();
            }

            else if(choice==3)
            {
                break;
            }
        } while (choice != 3);

    }
}
