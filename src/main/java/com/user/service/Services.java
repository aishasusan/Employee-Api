package com.user.service;

import java.util.List;

import com.user.model.Employee;

public interface Services {

	
	public Boolean addEmployee(Employee emp);
	
	public List<Employee> getallEmployee();
	
	public void deleteEmployee(Integer id);
	
	public Employee updateEmployee( Integer id, Employee emp);

	
}
