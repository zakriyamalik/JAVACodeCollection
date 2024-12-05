package Model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import Connection.ConnectionConfigurator;
public class OrderDAO {
    public static void insertdataintoOrderTable(int p_id,String p_name,int p_quantity,int v_id,String v_name){
        String sql="INSERT INTO `Order`  (ProductID,PRoductName,ProductQuantity,VendorID,VendorName) Values(?,?,?,?,?)";
        try{
            Connection temp= ConnectionConfigurator.getConnection();
            PreparedStatement ps=temp.prepareStatement(sql);
            ps.setInt(1,p_id);
            ps.setString(2,p_name);
            ps.setInt(3,p_quantity);
            ps.setInt(4,v_id);
            ps.setString(5,v_name);
            int num=ps.executeUpdate();
            if(num>0){
                JOptionPane.showMessageDialog(null,"Data Inserted in DB");
            }
            else{
                System.out.println("Unable to insert data");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteDataFromOrderTable(int id){
        String sql="DELETE FROM `Order` WHERE ProductID="+id;
        Connection temp=null;
        try{
            temp= ConnectionConfigurator.getConnection();
            PreparedStatement ps=temp.prepareStatement(sql);
            int num=ps.executeUpdate();
            if(num>0){
                JOptionPane.showMessageDialog(null,"Data deleted from DB");
            }
            else{
                System.out.println("Unable to delete data");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(temp!=null){
                    temp.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public static LinkedList<Integer> readProductIDfromOrderDB(){
        LinkedList<Integer> p_id=new LinkedList<>();
        String sql="SELECT ProductID FROM `Order`";
        Connection temp=null;
        try{
            temp= ConnectionConfigurator.getConnection();
            Statement s= temp.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                p_id.add(rs.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return p_id;
    }
    public static LinkedList<String> readProductNameFromOrderDb(){
        LinkedList<String> p_name=new LinkedList<>();
        String sql="SELECT ProductName FROM `Order`";
        Connection temp=null;
        try{
            temp= ConnectionConfigurator.getConnection();
            Statement s=temp.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                p_name.add(rs.getString(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(temp!=null){
                    temp.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return p_name;
    }

    public static LinkedList<Integer> readProductQuantityFromOrderDB(){
        LinkedList<Integer> p_quantity=new LinkedList<>();
        String sql="SELECT ProductQuantity FROM `Order`";
        Connection temp=null;
        try{
            temp= ConnectionConfigurator.getConnection();
            Statement s= temp.createStatement();;
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                p_quantity.add(rs.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return p_quantity;
    }

    public static LinkedList<Integer> readVendorIDFromOrderDB(){
        LinkedList<Integer> v_id=new LinkedList<>();
        String sql="SELECT VendorID FROM `Order`";
        Connection temp=null;
        try{
            temp= ConnectionConfigurator.getConnection();
            Statement s= temp.createStatement();;
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                v_id.add(rs.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return v_id;
    }

    public static LinkedList<String> readVendorNameFromOrderDB(){
        LinkedList<String> v_name=new LinkedList<>();
        String sql="SELECT VendorName FROM `Order`";
        Connection temp=null;
        try{
            temp= ConnectionConfigurator.getConnection();
            Statement s= temp.createStatement();;
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                v_name.add(rs.getString(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return v_name;
    }

    public static Object[][] gatherOrderData(){
        LinkedList<Integer> p_id=readProductIDfromOrderDB();
        LinkedList<String> p_name=readProductNameFromOrderDb();
        LinkedList<Integer> p_quantity=readProductQuantityFromOrderDB();
        LinkedList<Integer> v_id=readVendorIDFromOrderDB();
        LinkedList<String> v_name=readVendorNameFromOrderDB();
        Object data[][]=new Object[p_id.size()][7];
        for (int i = 0; i < p_id.size(); i++) {
            data[i][0] = p_id.get(i);
            data[i][1] = p_name.get(i);
            data[i][2] = p_quantity.get(i);
            data[i][3] = v_id.get(i);
            data[i][4] = v_name .get(i);
            data[i][5] = "Delete";
            data[i][6] = "Update";
        }
        return data;
    }
    public static void updateDataIntoOrderTable(int productid,String productname,int productquantity,String vendorname){
        String sql="UPDATE `Order` SET ProductName=?, ProductQuantity=?,VendorName=? WHERE ProductID="+productid;
        Connection temp=null;
        try{
            temp= ConnectionConfigurator.getConnection();
            PreparedStatement ps=temp.prepareStatement(sql);
            ps.setString(1,productname);
            ps.setInt(2,productquantity);
            ps.setString(3,vendorname);
            int num=ps.executeUpdate();
            if(num>0){
                System.out.println("Data Updated in DB");
            }
            else {
                System.out.println("Cannot Update Data in DB");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(temp!=null){
                    temp.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
