import javax.swing.*;

public class Q1
{
    public static int []fab (int total)
    {
        System.out.println("Control in Fab function ");

        int t1=0;
        int t2=1;
        int [] array=new int[total];
        for(int i=0;i<total;i++)
        {
            array[i]=t1;
            int sum=t1+t2;
            t1=t2;
            t2=sum;

        }

        return array;
    }
    public static void main(String[] args) {
                String Total="";
        int total=0;

        Total = JOptionPane.showInputDialog(null, "Enter the number of terms you want to enter for fabbonacci series between 5-20:", "Input", JOptionPane.QUESTION_MESSAGE);

        total= Integer.parseInt(Total);

        if(!(total>=5&&total<=20))
        {
            System.out.println("Wrong input!! Enter Again. ");
            do {
                Total = JOptionPane.showInputDialog(null, "Enter the number of terms you want to enter for fabbonacci series between 5-20:", "Input", JOptionPane.QUESTION_MESSAGE);

                total= Integer.parseInt(Total);
            }
            while(total<=5||total>=20);
        }
        int [] array1=new int[total];
         array1=fab(total);

        for(int i=0;i<total;i++)
        {

            System.out.println("Series is [ "+(i+1)+" ]"+ array1[i]);

        }


    }
}
