import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Product p = new Product(12, 1400, "Sunslik","Shampoo Product");
//
//        try(FileOutputStream fos = new FileOutputStream("data.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(p);
//            System.out.println("Object has been written in the file");
//        }catch (IOException e)
//        {
//            System.out.println(e.getMessage());
        //}

//        try(FileInputStream fis = new FileInputStream("data.ser");
//            ObjectInputStream ois = new ObjectInputStream(fis)){
//            Product p1 = (Product)ois.readObject();
//            System.out.println(p1.toString());
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }


        // WRITING LIST INTO FILE
//        List<Product> data = new ArrayList<>();
//        data.add(new Product(12, 1400, "Sunslik","Shampoo Product"));
//        data.add(new Product(14, 100, "Sugar","Sugar product"));
//        data.add(new Product(16, 1500, "Phone Case","Mobile Case Product"));
//
//
//        try(FileOutputStream fos = new FileOutputStream("data.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(data);
//            System.out.println("List has been written in the file");
//        }catch (IOException e)
//        {
//            System.out.println(e.getMessage());
//        }

//        List<Product> data = null;
//        // READING LIST FROM FILE
//        try(FileInputStream fis = new FileInputStream("data.ser");
//            ObjectInputStream ois = new ObjectInputStream(fis)){
//            data = (List<Product>) ois.readObject();
//            for (Product p: data)
//            {
//                System.out.println(p.toString());
//            }
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        if(data!=null)
//        {
//            data.add(new Product(17, 18800, "Turkish Iphone","Phone"));
//        }
//
//        try(FileOutputStream fos = new FileOutputStream("data.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(data);
//            System.out.println("updated list has been written in the file");
//        }catch (IOException e)
//        {
//            System.out.println(e.getMessage());
//        }

//        HashMap<String, Product> hm_data = new HashMap<>();
//        Product p = new Product(12, 1400, "Sunslik","Shampoo Product");
//        hm_data.put("key_1", p);
//
//        try(FileOutputStream fos = new FileOutputStream("data.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(hm_data);
//            System.out.println("HashMap has been written in the file");
//        }catch (IOException e)
//        {
//            System.out.println(e.getMessage());
//        }

        try(FileInputStream fis = new FileInputStream("data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            HashMap<String, Product> hm_data1 = (HashMap<String, Product>) ois.readObject();
            System.out.println(hm_data1.get("key_1"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}