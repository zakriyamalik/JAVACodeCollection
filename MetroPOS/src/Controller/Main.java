package Controller;
import Model.*;
import View.*;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws RuntimeException {
      
        try {
            DBInitializer in=new DBInitializer();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //new splashView();

        

        // new CreateBranchView();
//new BranchManagementView();
//new UpdateScreenView();
//BranchDAO.insert_data_into_db();
//BranchManagementModel bmm=BranchManagementModel.getInstance();
//bmm.update_Branch_data_into_db(124,"Dha lahore","Faisilabad","Active","Mall road muree","03338222333");
//new SearchScreenView();


//        //Inventory func calls
//        InventoryDAO.insertDataIntoInventoryDb("shampoo",12,"Cosmetic"
//                ,1200,1300,1);

new ManageInventoryView();


//        VendorDAO.insertVendor("Ali","03338189990","03338164142","ali@gmail.com"
  //      ,"GUjranwala","Lahore","Punjab","Pakistan");
        //Order Functionallity Call order
       // DataEntryOperatorDAO.insertdataintoOrderTable(2,"Oil",4,1,"Ali");

 //   new ManageOrderView();

    //new AddCategoryView();
    }
}
