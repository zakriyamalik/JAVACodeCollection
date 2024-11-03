package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Scanner inputScanner=new Scanner(System.in);
    static Record record=null;

    public void choice()
    {

        System.out.println("Press (1) to show one record\nPress (2) to show All records");
        int choice=inputScanner.nextInt();
        inputScanner.close();
        if (choice==1)
        {
            record.showOneRecords();
        }
        else if(choice==2)
        {
            record.showAllRecords();
        }
        else {
            System.out.println("Wrong choice\n");
        }

    }
    public static void main(String[] args) throws FileNotFoundException {

        Main main=new Main();
        Employee employee=new Employee(1,22,"M","Zakriya");
        List<Employee> dataList=new ArrayList<>();
        dataList.add(employee);
        try(FileOutputStream fos=new FileOutputStream("newData.ser");
            ObjectOutputStream oos=new ObjectOutputStream(fos)
        )
        {
            oos.writeObject(dataList);
            System.out.println("Data is been written in the file\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        try (
                FileInputStream fis=new FileInputStream("newData.ser");
                ObjectInputStream ois=new ObjectInputStream(fis);
            ) {
            dataList= (List<Employee>) ois.readObject();
            //record=new Record(dataList);
            System.out.println(dataList.toString());
            main.choice();


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}