//import java.util.LinkedList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
//// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
//// then press Enter. You can now see whitespace characters in your code.
//public class Main {
//    public static void main(String[] args) {
//        // Press Alt+Enter with your caret at the highlighted text to see how
//        // IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//       int choice=0;
//        System.out.println("\nEnter (1) for Integer type LinkedList\nEnter (2) for String type LinkedList\nEnter (1) for Character type LinkedList\n");
//        Scanner sc=new Scanner(System.in);
//        choice=sc.nextInt();
//        sc.nextLine();
//       switch (choice)
//       {
//           case 1:
//           {
//               List<Integer>inlist=new LinkedList<>();
//               List<Integer>inDellist=new LinkedList<>();
//               int number=0;
//               System.out.println("Enter total numbers of input");
//               Scanner sc1=new Scanner(System.in);
//               number=sc1.nextInt();
//               sc1.nextLine();
//               for(int i=0;i<number;i++)
//               {
//                   System.out.println("Enter "+(i+1)+"input\n");
//                   inlist.add(sc1.nextInt());
//
//
//               }
//               System.out.println("Data is \n");
//               for(int i=0;i<number;i++)
//               {
//                   System.out.println(inlist.get(i)+" ");
//               }
//
//               System.out.println("Enter total numbers of indeces to remove");
//               sc1=new Scanner(System.in);
//               number=sc1.nextInt();
//               int []arr=new int[number];
//               for(int i=0;i<number;i++)
//               {
//                   //  System.out.print("Random number from the array = " );
//                   int len=inlist.size();
//
//                   Random randomGenerator=new Random();
//                   int random = randomGenerator.nextInt(len);
//                   // int random=inlist.get(new Random().nextInt(inlist.size()));
//                   // System.out.println(random);
//                   inDellist.add(inlist.get(random));
//                   inlist.remove(random);
//
//               }
//               System.out.println("Updated array is \n");
//               for(int j=0;j<inlist.size();j++)
//               {
//                   System.out.println(inlist.get(j)+" ");
//               }
//               System.out.println("\n");
//
//               System.out.println("Deleted data is \n");
//               for(int j=0;j<inDellist.size();j++)
//               {
//
//                   System.out.println(inDellist.get(j)+" ");
//               }
//               System.out.println("\n");
//
//
//
//           }
//           break;
//           case 2:
//           {
//               List<String>stlist=new LinkedList<>();
//               List<String>delStlist=new LinkedList<>();
//               int number=0;
//               System.out.println("Enter total numbers of input");
//               Scanner sc1=new Scanner(System.in);
//               number=sc1.nextInt();
//               sc1.nextLine();
//               for(int i=0;i<number;i++)
//               {
//                   System.out.println("Enter "+(i+1)+"input\n");
//                   stlist.add(sc1.nextLine());
//
//
//               }
//               System.out.println("Data is \n");
//               for(int i=0;i<number;i++)
//               {
//                   System.out.println(stlist.get(i)+" ");
//               }
//
//               System.out.println("Enter total numbers of indeces to remove");
//               sc1=new Scanner(System.in);
//               number=sc1.nextInt();
//               int []arr=new int[number];
//               for(int i=0;i<number;i++)
//               {
//                   //  System.out.print("Random number from the array = " );
//                   int len=stlist.size();
//
//                   Random randomGenerator=new Random();
//                   int random = randomGenerator.nextInt(len);
//                   // int random=stlist.get(new Random().nextInt(stlist.size()));
//                   // System.out.println(random);
//                   delStlist.add(stlist.get(random));
//                   stlist.remove(random);
//
//               }
//               System.out.println("Updated array is \n");
//               for(int j=0;j<stlist.size();j++)
//               {
//                   System.out.println(stlist.get(j)+" ");
//               }
//               System.out.println("\n");
//
//               System.out.println("Deleted data is \n");
//               for(int j=0;j<delStlist.size();j++)
//               {
//
//                   System.out.println(delStlist.get(j)+" ");
//               }
//               System.out.println("\n");
//
//
//           }
//           break;
//           case 3:
//           {
//               List<Character>chlist=new LinkedList<>();
//               List<Character>delChlist=new LinkedList<>();
//
//               int number=0;
//               System.out.println("Enter total numbers of input");
//               Scanner sc1=new Scanner(System.in);
//               number=sc1.nextInt();
//               sc1.nextLine();
//               for(int i=0;i<number;i++)
//               {
//                   System.out.println("Enter "+(i+1)+" input\n");
//                   chlist.add(sc1.next().charAt(0));
//
//
//               }
//               System.out.println("Data is \n");
//               for(int i=0;i<number;i++)
//               {
//                   System.out.println(chlist.get(i)+" ");
//               }
//
//               System.out.println("Enter total numbers of indeces to remove");
//               sc1=new Scanner(System.in);
//               number=sc1.nextInt();
//
//               for(int i=0;i<number;i++)
//               {
//                 //  System.out.print("Random number from the array = " );
//                   int len=chlist.size();
//
//                   Random randomGenerator=new Random();
//                   int random = randomGenerator.nextInt(len);
//                   // int random=chlist.get(new Random().nextInt(chlist.size()));
//                  // System.out.println(random);
//                   delChlist.add(chlist.get(random));
//                   chlist.remove(random);
//
//               }
//               System.out.println("Updated array is \n");
//               for(int j=0;j<chlist.size();j++)
//               {
//                   System.out.println(chlist.get(j)+" ");
//               }
//               System.out.println("\n");
//
//               System.out.println("Deleted data is \n");
//               for(int j=0;j<delChlist.size();j++)
//               {
//
//                   System.out.println(delChlist.get(j)+" ");
//               }
//               System.out.println("\n");
//
//
//           }
//           break;
//           default:
//               System.out.println("Invalid choice\n");
//       }
//    }
//}




import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Q2 {
    int checkFilePresent(String path, String filename, String word) throws FileNotFoundException {
        parseFile(path, filename);

        File f = new File(path);
        Scanner sc1 = new Scanner(System.in);
        ArrayList<String> arr=new ArrayList<>();
        ArrayList<Character> newarr=new ArrayList<>();

        int count=0;
        if(f.exists()){
            System.out.println("success");
            File obj=new File(filename);
            Scanner sc=new Scanner(obj);
            while (sc.hasNextLine()) {
                String line=sc.nextLine();
                for(int i=0;i<line.length();i++){
                    newarr.add(line.charAt(i));
                }

               // arr.add(sc.nextLine());
            }

          //  data[count]='\0';
         //   System.out.println(data);
            sc.close();
//            System.out.println("Updated data is :\n");
//            for(int i=0;i<newarr.size();i++){
//                System.out.println(newarr.get(i));
//            }

            int j=0;
            int counter=1;
            int bigCounter=0;
            int k=0;
            for(int i=0;i< newarr.size();i++){
           //     System.out.println(newarr.get(i)+" "+word.charAt(0)+"\n");
              if(newarr.get(i).equals(word.charAt(0))){
               //   System.out.println("first letter\n");

                  j=i+1;
                  k=1;
               //   System.out.println("Out saide while\t"+newarr.get(j)+" "+word.charAt(k)+"\n");

                  while(newarr.get(j)==(word.charAt(k)))
                  {
               //       System.out.println("In side while\t"+newarr.get(j)+" "+word.charAt(k)+"\n");
                        j++;
                        k++;

                      counter++;
                  }



//                  System.out.println(newarr.get(i)+"\n");
//                  System.out.println(word+"\n");
              }
              if(word.length()-1==counter)
              {
                  System.out.println("Word Matched");
                  bigCounter++;
              }
              counter=1;

            }
            return bigCounter;
        }
        else{
            System.out.println("fail");
        }
        return -1;

    }

    void showData(Map<String, Integer> map) {
        System.out.println("Counter is:");
        for (String key : map.keySet()) {
            // Print the key and the corresponding value
            System.out.println(key + " : " + map.get(key));
        }
        Map<String, Integer> sortedByValue = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> entry : list) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        System.out.println("Sorted Counter is:");
        for (String key : sortedByValue.keySet()) {
            System.out.println(key + " : " + sortedByValue.get(key));
        }
    }

    void parseFile(String path, String fileName) throws FileNotFoundException {

        List<String> lines = new ArrayList<>();
        List<String> userData = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String line = "";
        File obj = new File(fileName);
        Scanner sc = new Scanner(obj);
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            // System.out.println("Line: " + line + "\n");
            String[] parts = line.split(" ");
            //   System.out.println("parts are\n");
            for (int i = 0; i < parts.length; i++) {
                //   System.out.println(parts[i]);
                userData.add(parts[i]);
            }

            lines.add(line);
        }
        sc.close();
        // System.out.println("User data is:");


        for (int j = 0; j < userData.size(); j++) {

            map.put(userData.get(j), 1);


        }

//        System.out.println("Counter is:");
//        for (String key : map.keySet()) {
//            // Print the key and the corresponding value
//            System.out.println(key + " : " + map.get(key));
//        }
        for (String key : map.keySet()) {
            int counter = 0;

            // Loop through userData to find occurrences of the key
            for (int j = 0; j < userData.size(); j++) {
                if (key.equals(userData.get(j))) {
              //      System.out.println("\n\nIncrement\n");
                 //   System.out.println("Key is " + key + " : " + "Map is " + map.get(key) + "\n\n");
                    counter++; // Increment counter if match is found
                    map.put(key, counter);
                } else {
               //     System.out.println("\n\nDecrement\n");
                }
            }

        }
        System.out.println("Counter is:");
        for (String key1 : map.keySet()) {
            // Print the key and the corresponding value
            System.out.println(key1 + " : " + map.get(key1));
        }
    }
}