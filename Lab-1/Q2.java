import javax.swing.*;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        String totalStd="";
        int total=0;
        int tempStd;
        double sum=0;
        double avg=0;
        int counter=0;

        // Total Students
        totalStd = JOptionPane.showInputDialog(null, "Enter the number of Students :", "Input", JOptionPane.QUESTION_MESSAGE);
        total= Integer.parseInt( totalStd);
        double [] stdArray=new double[total];
        JOptionPane.showMessageDialog(null, total, "Input", JOptionPane.QUESTION_MESSAGE);


        // Getting input

        Scanner in =new Scanner(System.in);

        for(int i=0;i<total;i++){
            stdArray[i]  =in.nextDouble();
            sum+=stdArray[i];
        }


        // Marks of Students
        JOptionPane.showMessageDialog(null, "Marks of Students are ", "Input", JOptionPane.QUESTION_MESSAGE);
        for(int i=0;i<total;i++){
            JOptionPane.showMessageDialog(null, stdArray[i], "Input", JOptionPane.QUESTION_MESSAGE);
        }

        // Sum of Marks
        JOptionPane.showMessageDialog(null, "Sum of Marks of Students is ", "Input", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, sum, "Input", JOptionPane.QUESTION_MESSAGE);

        avg=sum/total;

        // Avg of Marks

        JOptionPane.showMessageDialog(null, "Avg of Marks of Students is ", "Input", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, avg, "Input", JOptionPane.QUESTION_MESSAGE);


        //Student Less then Avg Marks

        JOptionPane.showMessageDialog(null, "Students marks then average marks are ", "Input", JOptionPane.QUESTION_MESSAGE);
        for(int i=0;i<total;i++){
            if(stdArray[i]<avg){
                JOptionPane.showMessageDialog(null, stdArray[i], "Input", JOptionPane.QUESTION_MESSAGE);

            }
        }


        // Counter of students less then average marks

        JOptionPane.showMessageDialog(null, "Students less then average marks are ", "Input", JOptionPane.QUESTION_MESSAGE);
        for(int i=0;i<total;i++){
            if(stdArray[i]<avg){
              counter++;
            }
        }
        JOptionPane.showMessageDialog(null, counter, "Input", JOptionPane.QUESTION_MESSAGE);






    }
}
