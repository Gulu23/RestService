package com.satya.ws.db.dao;

import com.satya.ws.db.entity.Employee;
import com.satya.ws.db.util.EntityManagerUtil;

public class EmployeeDAOImpl  extends EntityManagerUtil implements EmployeeDAO {
public Employee get(Integer empId){
        
      //  EntityManager entityManager = null;
        Employee employee=null;
        
        try{
            //entityManager = EntityManagerUtil.getEntityManager();
        	
            employee = (Employee)em.find(Employee.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return employee;
    }
    
    
    public void insert(Employee employee){
        
      //  EntityManager entityManager = null;
        
        try {
            
            //entityManager= EntityManagerUtil.getEntityManager();
        	em.getTransaction().begin();
        	em.persist(employee);
        	em.getTransaction().commit();
            
        }catch (Exception e){
            e.printStackTrace();
        }        
    }
    
    
  public void update(Employee employee){
        
      //EntityManager entityManager = null;
        
        try {            
           // entityManager= EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(employee);
            em.getTransaction().commit();
            
        }catch (Exception e){
            e.printStackTrace();
        }        
    }
  
  
  public void delete(Integer empId){
        
     // EntityManager entityManager = null;
 
        
        try {
            
           // entityManager= EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            Employee emp = (Employee)em.find(Employee.class, empId);
            em.remove(emp);
            em.getTransaction().commit();
            
        }catch (Exception e){
            e.printStackTrace();
        }        
    }

}
