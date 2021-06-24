package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.EmployeeRepository;
import com.user.model.Employee;

@Service
public class ServiceImpl implements Services{

	
	@Autowired
	EmployeeRepository empRepo;
	
	public Boolean addEmployee(Employee emp) {
		empRepo.save(emp);
		return true;
	}

	public List<Employee> getallEmployee() {
		
		return empRepo.findAll();
	}

	public void deleteEmployee(Integer id) {
		empRepo.deleteById(id);
	}
	
	public Employee updateEmployee( Integer id, Employee emp) {
		empRepo.save(emp);
		return empRepo.findById(id).get();
	}
}
