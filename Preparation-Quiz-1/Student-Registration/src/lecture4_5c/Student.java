/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture4_5c;

import java.util.ArrayList;

/**
 *
 * @author Rana Waqas
 */
public class Student extends Person{
    private String rollNumber;
    private float cgpa;
    private int semester;
    private ArrayList<Course> courses;
    
    public Student()
    {
        super();
    }
    public Student(String name,int age, String rollNumber, 
            float cgpa, int semester, ArrayList<Course> courses)
    {
        super(name, age);
        this.rollNumber = rollNumber;
        this.semester = semester;
        this.cgpa = cgpa;
        this.courses = courses;
    }
    public void setCourses(ArrayList<Course> courses)
    {
        this.courses = courses;
    }
    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    @Override
    public String toString()
    {
        return "Roll number : "+rollNumber+super.toString()+"\nCGPA : "+cgpa+"\nSemester : "+semester+"\n";
    }
    
    public void register(Course c){
        courses.add(c);
    }
    
}
