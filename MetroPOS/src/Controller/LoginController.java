package Controller;

import Model.LoggedEmp;
import Model.LoginDAO;

import java.sql.SQLException;

public class LoginController {
   public LoginDAO loginDAO=new LoginDAO();
   public LoggedEmp loggedEmp=LoggedEmp.getInstance();
    public LoginController() {
    }

    public boolean redirect_validateUser(String name,String password,String designation) throws SQLException {
        return loginDAO.validateUser(name,password,designation);

    }
    public void redirect_set_credientials(String name,String password,String designation,String branch){
        System.out.println("Credentials to be set!\t"+name+" "+password+" "+designation+" "+branch+"\n");
       loggedEmp.setUserName(name);
       loggedEmp.setPassword(password);
       loggedEmp.setDesignation(designation);
       loggedEmp.setBranch(branch);
        System.out.println("Credentials set!\n");
        System.out.println("Credentials setted are!\t"+loggedEmp.getBranch()+" "+password+" "+designation+" "+branch+"\n");

    }

}
