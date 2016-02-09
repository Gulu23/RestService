package com.satya.ws.db.test;

import com.satya.ws.db.dao.EmployeeDAO;
import com.satya.ws.db.dao.EmployeeDAOImpl;
import com.satya.ws.db.entity.Employee;

public class EmployeeService {
public static void main(String[] args) {
        
        EmployeeDAO empDAO = new EmployeeDAOImpl();
        
        Employee createEmp1 = new Employee(1, "Sachin","R&D");
        Employee createEmp2 = new Employee(2, "Rohit","R&D");
        empDAO.insert(createEmp1);//Create
        empDAO.insert(createEmp2);//Create
        
        Employee readEmp = empDAO.get(1);//Read        
        System.out.println(readEmp);
        
        Employee updateEmp = new Employee(1,"Sachin Tendulkar","R&D");        
        empDAO.update(updateEmp);//Update
        
        empDAO.delete(1); //Delete
}
}
