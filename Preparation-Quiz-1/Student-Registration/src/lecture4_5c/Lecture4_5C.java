/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture4_5c;
import lecture4_5c.Course;
import lecture4_5c.Student;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.*;

/**
 *
 * @author Rana Waqas
 */
public class Lecture4_5C {

    /**
     * @param args the command line arguments
     */
    
    private static void menu()
    {
        System.out.println("1. Student Entry\n2. Course Registration\n3. View Courses\n4. Offer Course");
        
    }
    private static void showCourseList(ArrayList<Course> offeredCourses)
    {
        for(Course c:offeredCourses)
        {
            System.out.println("CourseID: "+c.getCourseID()+" CourseName: "+c.getCourseName()+" CourseCapacity: "+
            c.getCapacity()+" CreditHrs: "+c.getCreditHours());
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Course> offeredCourses = new ArrayList<>();        
        ArrayList<Student> students = new ArrayList<>();

        int selection;
        Scanner input = new Scanner(System.in);
        while(true){
            menu();
            selection = input.nextInt();
            
            switch(selection)
            {
                case 1:
                    newStudent(students, studentCourses);
                    break;
                case 2:
                    
                    registerCourse(students, offeredCourses, studentCourses);
                case 3:
                    
                case 4:
                    offerNewCourse(offeredCourses);
                default:
                    System.out.println("Wrong selection");
            }
            
        }
        
    }
    
    public static void newStudent(ArrayList<Student> sList, 
            ArrayList<ArrayList<Course>> studentCourses)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Roll Number : ");
        String rollNum = input.nextLine();
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter age : ");
        int age = input.nextInt();
       
        ArrayList<Course> c = new ArrayList<>();
        Student s = new Student(name, age, rollNum, 0.0f, 1, c);
        sList.add(s);
        studentCourses.add(c);
    }
    
    public static void offerNewCourse(ArrayList<Course> offeredCourses)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course Id : ");
        String id = input.nextLine();
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter credit Hours : ");
        int cHours = input.nextInt();
        
        System.out.println("Is core (1/0) : ");
        boolean isCore = input.nextBoolean();
        
        offeredCourses.add(new Course(id, cHours, name, 50, isCore));        
    }

    public static void registerCourse(ArrayList<Student> sList,ArrayList<Course> offeredCourses,
                                      ArrayList<ArrayList<Course>> studentCourses)
    {
        boolean flage=false;
        int stdIndex=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Roll Number : ");
        String rollNum = input.nextLine();
        for(Student s:sList)
        {
            stdIndex++;
            if(Objects.equals(rollNum, s.getRollNumber()))
            {
                flage=true;
                break;
            }
        }
        if(flage)
        {
            showCourseList(offeredCourses);
            System.out.println("Enter CourseID : ");
            String courseID = input.nextLine();
            for(Course c:offeredCourses)
            {
                if(Objects.equals(courseID, c.getCourseID()))
                {
                    for(Student s:sList)
                    {
                        if(Objects.equals(rollNum, s.getRollNumber()))
                        {

                            s.register(c);

                            studentCourses[stdIndex][stdIndex].=

                        }
                        break;
                    }

                }
            }

        }

    }
    
}
