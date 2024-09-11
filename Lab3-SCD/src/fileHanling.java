import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class fileHanling {
    fileHanling()
    {

    }
    public void writeFile(String file) throws FileNotFoundException {
        File fileError = new File(file);
        if(!fileError.exists())
        {
            System.out.println("File  does not exists");
        }
        else {

            int coutner = 0;
            String Name = "";
            String Marks = "";
            Scanner scannerNew = new Scanner(System.in);
            System.out.println("Enter the number of subject");
            coutner = scannerNew.nextInt();
            scannerNew.nextLine();

            for (int i = 0; i < coutner; i++) {
                System.out.println("Enter Name of Subject");
                Name = scannerNew.nextLine();
                System.out.println("Enter Marks of Subject");
                Marks = scannerNew.nextLine();
                try {
                    FileWriter myWriter = new FileWriter(file, true);


                    myWriter.write(Name + "," + Marks + System.lineSeparator());
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.getMessage();
                }

            }
        }







        }
    public File createFile(String filename) {


        File file = null;
        try {


            file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File Created");
            } else {
                System.out.println("File already exists");
            }


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return file;
    }
    public void writeFileQ2() throws FileNotFoundException {

        String Newfilename="";
        String Newfilename1="";
        Scanner scanner = new Scanner(System.in);
        int choice=0;
       System.out.println("Press 1 : Enter Roll number of the student.\nPress 2 :  to input data\n");
       choice=scanner.nextInt();
       scanner.nextLine();
       if(choice==1)
       {
           System.out.println("Enter Roll number : ");
           Newfilename = scanner.nextLine();
           Newfilename=Newfilename.concat(".txt");
           System.out.println("New File Name: "+Newfilename+"\n");
           File file = new File(Newfilename);
           createFile(Newfilename);
       } else if (choice == 2) {
           File file=null;

           System.out.println("Enter File Name : ");
           Newfilename1 = scanner.nextLine();
           //file=createFile(Newfilename1);
           writeFile(Newfilename1);


       }


    }

    public void readFile(String filename)
    {

        try {

            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }


            myReader.close();


        }

        catch (FileNotFoundException e) {


            System.out.println("An error occurred.");
            e.printStackTrace();


        }

    }

}
