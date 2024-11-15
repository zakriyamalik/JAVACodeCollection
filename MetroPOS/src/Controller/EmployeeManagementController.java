package Controller;

import Model.EmployeeDao;

public class EmployeeManagementController {
    EmployeeDao employeeDao=new EmployeeDao();
    public EmployeeManagementController() {
    }
    public void redirect_employee_insertion(String name,String empNo,String email,String branchCode,String salary,String designation)
    {
        employeeDao.insertEmployee(name,empNo,email,branchCode,salary,designation);
    }
}
