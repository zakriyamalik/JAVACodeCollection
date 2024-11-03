package Serialization;

import java.util.*;

public class Record {
    List<Employee> dataList;
    Record (List<Employee> dataList)
    {
        this.dataList=dataList;
    }
    void showOneRecords()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter First Name");
        String Fname=scanner.nextLine();
        System.out.println("Enter Last Name");
        String Lname=scanner.nextLine();
        boolean flage=false;

        for(Employee em:dataList)
        {
            if(Objects.equals(em.firstName, Fname) && Objects.equals(em.lastName, Lname))
            {
                System.out.println(em.toString());
                flage=true;
            }
        }
        if(!flage)
        {
            System.out.println("No record found");
        }


    }
    void showAllRecords()
    {
        for (Employee em: dataList)
        {
            System.out.println(em.toString());
        }
    }

}
