import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Record {
    private static final String FILE_NAME = "employees.ser";
    private List<Employee> employee_list;

    public Record()
    {

        employee_list = new ArrayList<>();
        load_records();
    }

    public void add_employee(Employee employee)
    {
        employee_list.add(employee);
        save_records();
    }

    public void search_by_ssn(String ssn)
    {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employee_list)
        {
            if (emp.get_ssn().equals(ssn))
            {
                result.add(emp);
            }
        }
        display_results(result);
    }

    public void search_by_age(int age)
    {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employee_list)
        {
            if (emp.get_age() == age)
            {
                result.add(emp);
            }
        }
        display_results(result);
    }

    public void search_by_name(String first_name, String last_name)
    {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employee_list)
        {
            if (emp.get_first_name().equalsIgnoreCase(first_name) && emp.get_last_name().equalsIgnoreCase(last_name))
            {
                result.add(emp);
            }
        }
        display_results(result);
    }

    public void show_all_records()
    {
        display_results(employee_list);
    }

    private void display_results(List<Employee> result)
    {
        if (result.isEmpty())
        {
            System.out.println("No matching records found.");
        } else
        {
            for (Employee emp : result)
            {
                System.out.println(emp);
            }
        }
    }

    private void save_records() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
        {
            oos.writeObject(employee_list);
        } catch (IOException e)
        {
            System.err.println("Error saving records: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void load_records()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)))
        {
            employee_list = (List<Employee>) ois.readObject();
        } catch (FileNotFoundException e)
        {
            System.out.println("No existing records found. A new file will be created.");
        } catch (IOException | ClassNotFoundException e)
        {
            System.err.println("Error loading records: " + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        Record record = new Record();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do
        {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Search by SSN");
            System.out.println("3. Search by Age");
            System.out.println("4. Search by Name");
            System.out.println("5. Show All Records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice)
            {
                case "1":
                    System.out.print("Enter SSN: ");
                    String ssn = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter First Name: ");
                    String first_name = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String last_name = scanner.nextLine();
                    record.add_employee(new Employee(ssn, age, first_name, last_name));
                    break;

                case "2":
                    System.out.print("Enter SSN: ");
                    ssn = scanner.nextLine();
                    record.search_by_ssn(ssn);
                    break;

                case "3":
                    System.out.print("Enter Age: ");
                    age = Integer.parseInt(scanner.nextLine());
                    record.search_by_age(age);
                    break;

                case "4":
                    System.out.print("Enter First Name: ");
                    first_name = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    last_name = scanner.nextLine();
                    record.search_by_name(first_name, last_name);
                    break;

                case "5":
                    record.show_all_records();
                    break;

                case "6":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (!choice.equals("6"));

        scanner.close();
    }
}
