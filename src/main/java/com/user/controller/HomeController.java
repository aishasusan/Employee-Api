package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.dao.EmployeeRepository;
import com.user.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping("/employee")
public class HomeController {

	@Autowired
	 private EmployeeRepository empRepo;
	
	@GetMapping("/home")
	@ApiOperation(value="welcome user")
	public String getMessage()
	{
		return "Spring Boot Rest for Employee OPerations";
	}
	
	@PutMapping
	@ApiOperation(value="to input values")
	public Employee addNewProduct(@RequestBody Employee emp)
	{
		return empRepo.save(emp);
		
	}
	
	@GetMapping("/{no}")
	@ApiOperation(value="input operations")
	public Employee findEmployeeById(@PathVariable Integer no) {
		Optional<Employee> isEmployeePresent = empRepo.findById(no);
		if(isEmployeePresent.isPresent()) {
			return isEmployeePresent.get();
		}
		else
			System.out.println("Employee not found");
		return null;
	}
	
	@GetMapping("/all")
	@ApiOperation(value="to get all employees")
	public List<Employee> findAllEmployee()
	{
		return empRepo.findAll();
	}
	
	@DeleteMapping
	@ApiOperation(value="to delete from")
	public void delteEmployeeById(@RequestParam("id") Integer id) {
		empRepo.deleteById(id);
	}
	
	@PostMapping
	@ApiOperation(value="update changes")
	public Employee updateEmployeeList(@RequestBody Employee emp) {
		if(empRepo.findById(emp.getEmployeeId()).isPresent()) {
			empRepo.deleteById(emp.getEmployeeId());
			return empRepo.save(emp);
		}
		return null;
	}
}
