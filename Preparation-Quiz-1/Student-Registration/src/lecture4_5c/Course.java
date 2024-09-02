/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture4_5c;

/**
 *
 * @author Rana Waqas
 */
public class Course {
    private String courseID;
    private int creditHours;
    private String courseName;
    private int capacity;
    private boolean isCore;

    public Course() {
    }

    public Course(String courseID, int creditHours, String courseName, int capacity, boolean isCore) {
        this.courseID = courseID;
        this.creditHours = creditHours;
        this.courseName = courseName;
        this.capacity = capacity;
        this.isCore = isCore;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isIsCore() {
        return isCore;
    }

    public void setIsCore(boolean isCore) {
        this.isCore = isCore;
    }

    @Override
    public String toString() {
        return "courseID=" + courseID + "\ncreditHours=" + creditHours + "\ncourseName=" + courseName + "\ncapacity=" + capacity + "\nisCore=" + isCore +"\n";
    }
    
    
    
}
