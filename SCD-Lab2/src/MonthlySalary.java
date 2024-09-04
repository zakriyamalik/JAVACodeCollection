import java.util.Scanner;
public class MonthlySalary extends Employee {

    private int mSalary;
    MonthlySalary()
    {
        super();
    }
    MonthlySalary(String firstName, String lastName, String cnic, int mSalary)
    {
        super(firstName, lastName, cnic);
        this.mSalary = mSalary;
    }

    public int getmSalary() {
        return mSalary;
    }
    public void setmSalary(int mSalary) {
        this.mSalary = mSalary;
    }
    public int calculateSalary()
    {
        int hrs=0;
        int HourlyWage=0;
        int days=0;
        int daysSalary=0;
        int months=0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Hours Worked per Day: ");
        hrs = sc.nextInt();

        System.out.print("Enter number of Days Worked per Day: ");
        days = sc.nextInt();

        System.out.print("Enter Hourly Wage: ");
        HourlyWage = sc.nextInt();

        months=days/30;

        daysSalary=hrs*days;
        mSalary=HourlyWage*(daysSalary);
        return mSalary;

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
        this.setmSalary(salary);
        this.print();


    }
    public String print()
    {

        return System.out.printf("First Name: "+getFirstName()+" Last Name: "+getLastName()+" CNIC: "+ getCnic()+" Monthly Salary: "+getmSalary()).toString();
    }

}
