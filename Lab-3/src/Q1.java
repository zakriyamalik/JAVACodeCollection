import java.io.*;
import java.util.Scanner;

public class Q1 {
public void readFile() throws IOException {
    File file = new File("file.txt");
    FileReader input = new FileReader(file);
    Scanner scanner = new Scanner(input);
    String []fileData = new String[0];
    String line="";
    while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        fileData = line.split(" ");

    }

    InvertClass invert = new InvertClass();
    fileData=invert.invertor(fileData);
    for(int i=0;i<fileData.length;i++) {
        System.out.println( fileData[i]);
    }

    FileWriter obj = new FileWriter("file_processing.txt");
    for(int i=0;i<fileData.length;i++) {
        obj.write(fileData[i]+" ");
    }
    obj.close();
    input.close();
//    if( file.delete())
//    {
//        System.out.println("File deleted successfully");
//    }
//    else
//    {
//        System.out.println("File could not be deleted");
//    }



}
}
