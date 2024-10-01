import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class contactBook {
   // List<contact> contactList=new ArrayList<>();
  contact []contactList=new contact[100];//=new contact();
    contact ct=new contact();

    private int counter=0;

    void add()
    {
         String name;
         String add;
         String phone;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Name");
        name=sc.nextLine();
        System.out.println("Enter Phone no");
        add=sc.nextLine();
        System.out.println("Enter Address:");
        phone=sc.nextLine();
//        ct.setName(name);
//        ct.setPhone(phone);
//        ct.setAdd(add);

        contactList[counter]=new contact();
        contactList[counter].setName(name);
        contactList[counter].setPhone(phone);
        contactList[counter].setAdd(add);
        counter++;


    }
    void remove()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name=sc.nextLine();
        for(int i=0;i<counter;i++)
        {
            if(Objects.equals(contactList[i].getName(), name))
            {
                for(int j=i;j<counter-1;j++)
                {
                    contactList[j]=contactList[j+1];
                }
                counter--;
            }
            else
            {
                continue;
            }
        }

    }
    void search()
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Enter 1 to S by Name\nEnter 2 to s by phone\nEnter 3 to exit");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Enter name");
                String name=sc.nextLine();
                for(int i=0;i<counter;i++)
                {
                    if(Objects.equals(contactList[i].getName(), name))
                    {
                        System.out.println(contactList[i].getAdd()+contactList[i].getName()+contactList[i].getPhone());

                    }
                    else
                    {
                        continue;
                    }
                }


            } else if (choice == 2) {
                System.out.println("Enter Phone");
                String name=sc.nextLine();
                for(int i=0;i<counter;i++)
                {
                    if(Objects.equals(contactList[i].getName(), name))
                    {
                        System.out.println(contactList[i].getAdd()+contactList[i].getName()+contactList[i].getPhone());

                    }
                    else
                    {
                        continue;
                    }
                }

            }
            else if(choice==3)
            {
                break;
            }
        } while (choice != 3);

    }
    void showall()
    {

        for(int i=0;i<counter;i++)
        {
            System.out.println(contactList[i].getAdd()+contactList[i].getName()+contactList[i].getPhone());
        }


    }
}
