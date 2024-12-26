import java.io.Serializable;

public class Employee implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String ssn;
    private int age;
    private String first_name;
    private String last_name;

    public Employee(String ssn, int age, String first_name, String last_name)
    {
        this.ssn = ssn;
        this.age = age;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String get_ssn()
    {
        return ssn;
    }

    public int get_age()
    {
        return age;
    }

    public String get_first_name()
    {
        return first_name;
    }

    public String get_last_name()
    {
        return last_name;
    }

    @Override
    public String toString()
    {
        return "SSN: " + ssn + ", Age: " + age + ", Name: " + first_name + " " + last_name;
    }
}
