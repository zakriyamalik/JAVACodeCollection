import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Employee {
    private String firstName;
    private String lastName;
    private String cnic;

    Employee()
    {
        firstName = "";
        lastName = "";
        cnic = "";

    }
    Employee(String firstName, String lastName, String cnic)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnic = cnic;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;

    }
    public void setLastName(String lastName) {
        this.lastName = lastName;

    }
    public String getCnic() {
        return cnic;

    }
    public void setCnic(String cnic) {
        this.cnic = cnic;

    }





    public static void main(String[] args) {
        int choice=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter (1) to calculate for Monthly Salary \n(2) to calculate for Hourly Salary\n");
        choice = sc.nextInt();
        if(choice == 1)
        {
            MonthlySalary ms = new MonthlySalary();
            ms.getInput();
        }
        else if(choice == 2)
        {

            HourlySalary hrs = new HourlySalary();
            hrs.getInput();

        }
        else
        {
            System.out.print("Invalid Choice!!!\n");
        }
//        Employee e=new Employee("Ali","Hamza","22-333-44");
//        System.out.println(e.print());

    }
}
