package Serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    int ssn, age;
    String firstName, lastName;

    public Employee(int ssn, int age, String firstName, String lastName) {
        this.ssn = ssn;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ssn=" + ssn +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
}