import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final boolean ASC = true;

    public static void main(String[] args) throws FileNotFoundException {
        int choice1 = 0;

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter 1 to run Q1\nEnter 2 to run Q2\n");
        choice1 = sc2.nextInt();
        if (choice1 == 1) {
            int choice = 0;
            System.out.println("\nEnter (1) for Integer type LinkedList\nEnter (2) for String type LinkedList\nEnter (1) for Character type LinkedList\n");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    List<Integer> inlist = new LinkedList<>();
                    List<Integer> inDellist = new LinkedList<>();
                    int number = 0;
                    System.out.println("Enter total numbers of input");
                    Scanner sc1 = new Scanner(System.in);
                    number = sc1.nextInt();
                    sc1.nextLine();
                    for (int i = 0; i < number; i++) {
                        System.out.println("Enter " + (i + 1) + "input\n");
                        inlist.add(sc1.nextInt());


                    }
                    System.out.println("Data is \n");
                    for (int i = 0; i < number; i++) {
                        System.out.println(inlist.get(i) + " ");
                    }

                    System.out.println("Enter total numbers of indeces to remove");
                    sc1 = new Scanner(System.in);
                    number = sc1.nextInt();
                    int[] arr = new int[number];
                    for (int i = 0; i < number; i++) {
                        //  System.out.print("Random number from the array = " );
                        int len = inlist.size();

                        Random randomGenerator = new Random();
                        int random = randomGenerator.nextInt(len);
                        // int random=inlist.get(new Random().nextInt(inlist.size()));
                        // System.out.println(random);
                        inDellist.add(inlist.get(random));
                        inlist.remove(random);

                    }
                    System.out.println("Updated array is \n");
                    for (int j = 0; j < inlist.size(); j++) {
                        System.out.println(inlist.get(j) + " ");
                    }
                    System.out.println("\n");

                    System.out.println("Deleted data is \n");
                    for (int j = 0; j < inDellist.size(); j++) {

                        System.out.println(inDellist.get(j) + " ");
                    }
                    System.out.println("\n");


                }
                break;
                case 2: {
                    List<String> stlist = new LinkedList<>();
                    List<String> delStlist = new LinkedList<>();
                    int number = 0;
                    System.out.println("Enter total numbers of input");
                    Scanner sc1 = new Scanner(System.in);
                    number = sc1.nextInt();
                    sc1.nextLine();
                    for (int i = 0; i < number; i++) {
                        System.out.println("Enter " + (i + 1) + "input\n");
                        stlist.add(sc1.nextLine());


                    }
                    System.out.println("Data is \n");
                    for (int i = 0; i < number; i++) {
                        System.out.println(stlist.get(i) + " ");
                    }

                    System.out.println("Enter total numbers of indeces to remove");
                    sc1 = new Scanner(System.in);
                    number = sc1.nextInt();
                    int[] arr = new int[number];
                    for (int i = 0; i < number; i++) {
                        //  System.out.print("Random number from the array = " );
                        int len = stlist.size();

                        Random randomGenerator = new Random();
                        int random = randomGenerator.nextInt(len);
                        // int random=stlist.get(new Random().nextInt(stlist.size()));
                        // System.out.println(random);
                        delStlist.add(stlist.get(random));
                        stlist.remove(random);

                    }
                    System.out.println("Updated array is \n");
                    for (int j = 0; j < stlist.size(); j++) {
                        System.out.println(stlist.get(j) + " ");
                    }
                    System.out.println("\n");

                    System.out.println("Deleted data is \n");
                    for (int j = 0; j < delStlist.size(); j++) {

                        System.out.println(delStlist.get(j) + " ");
                    }
                    System.out.println("\n");


                }
                break;
                case 3: {
                    List<Character> chlist = new LinkedList<>();
                    List<Character> delChlist = new LinkedList<>();

                    int number = 0;
                    System.out.println("Enter total numbers of input");
                    Scanner sc1 = new Scanner(System.in);
                    number = sc1.nextInt();
                    sc1.nextLine();
                    for (int i = 0; i < number; i++) {
                        System.out.println("Enter " + (i + 1) + " input\n");
                        chlist.add(sc1.next().charAt(0));


                    }
                    System.out.println("Data is \n");
                    for (int i = 0; i < number; i++) {
                        System.out.println(chlist.get(i) + " ");
                    }

                    System.out.println("Enter total numbers of indeces to remove");
                    sc1 = new Scanner(System.in);
                    number = sc1.nextInt();

                    for (int i = 0; i < number; i++) {
                        //  System.out.print("Random number from the array = " );
                        int len = chlist.size();

                        Random randomGenerator = new Random();
                        int random = randomGenerator.nextInt(len);
                        // int random=chlist.get(new Random().nextInt(chlist.size()));
                        // System.out.println(random);
                        delChlist.add(chlist.get(random));
                        chlist.remove(random);

                    }
                    System.out.println("Updated array is \n");
                    for (int j = 0; j < chlist.size(); j++) {
                        System.out.println(chlist.get(j) + " ");
                    }
                    System.out.println("\n");

                    System.out.println("Deleted data is \n");
                    for (int j = 0; j < delChlist.size(); j++) {

                        System.out.println(delChlist.get(j) + " ");
                    }
                    System.out.println("\n");


                }
                break;
                default:
                    System.out.println("Invalid choice\n");
            }


        } else if (choice1 == 2) {
            Q2 q2 = new Q2();
            String word = "";
            ArrayList<Integer> count = new ArrayList<>();
            ArrayList<String> files = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();

            int counter = 0;
            int choice = 0;
            int res = 0;
            String fileName = "";
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter the number of files to enter\n");
            choice = sc1.nextInt();
            sc1.nextLine();
            for (int i = 0; i < choice; i++) {
                System.out.println("Enter the word to find\n");
                word = sc1.nextLine();
                word = word + "\0";
               // System.out.println("Word is:" + word);
                System.out.println("Enter file name");
                fileName = sc1.nextLine();
                res = q2.checkFilePresent("./" + fileName, fileName, word);
                if (res != -1) {
                    map.put(fileName, res);

                    System.out.println("The number of times word found is " + res);
                } else {
                    System.out.println("The number of times word found is " + 0);
                }
            }
            q2.showData(map);




        }
    }
}


