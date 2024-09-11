import java.util.Scanner;

public class HourlySalary extends Employee {
    private int hSalary;
    public HourlySalary()
    {
        super();
    }
    public HourlySalary(int hSalary,String firstName, String lastName,String cnic) {
        super(firstName, lastName, cnic);
        this.hSalary = hSalary;
    }

    public void sethSalary(int hSalary) {
        this.hSalary = hSalary;
    }
    public int gethSalary() {
        return hSalary;
    }
    public int calculateSalary()
    {
        int hrs=0;
        int HourlyWage=0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Hours Worked: ");
        hrs = sc.nextInt();
        System.out.print("Enter Hourly Wage: ");
        HourlyWage = sc.nextInt();
        hSalary=hrs*HourlyWage;
        return hSalary;
    }
    public void getInput()
    {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String firstName = sc.next();
        System.out.print("Enter Last Name: ");
        String lastName = sc.next();
        System.out.print("Enter CNIC: ");
        String cnic = sc.next();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCnic(cnic);

       int salary= this.calculateSalary();
       this.sethSalary(salary);
        this.print();


    }
    public String print()
    {

        return System.out.printf("First Name: "+getFirstName()+" Last Name: "+getLastName()+" CNIC: "+getCnic()+" Hourly Salary: "+ gethSalary()+"\n").toString();
    }


}
