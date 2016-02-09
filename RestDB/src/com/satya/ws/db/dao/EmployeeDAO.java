package com.satya.ws.db.dao;

import com.satya.ws.db.entity.Employee;

public interface EmployeeDAO {
	public Employee get(Integer empId);
	 public void insert(Employee employee);
	 public void update(Employee employee);
	 public void delete(Integer empId);
}
