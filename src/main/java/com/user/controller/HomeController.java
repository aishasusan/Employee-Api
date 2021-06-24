package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.Employee;
import com.user.service.Services;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping("/employee")
public class HomeController {

	@Autowired
	Services service;

	@Autowired
	public HomeController(Services service) {
		this.service = service;

	}

	@GetMapping("/home")
	@ApiOperation(value = "welcome user")
	public String getMessage() {
		return "Spring Boot Rest for Employee OPerations";
	}

	@PutMapping("/Employee/{id}")
	public ResponseEntity<?> update(@PathVariable() Integer id, Employee emp) {
		return new ResponseEntity<Employee>(service.updateEmployee(id, emp), HttpStatus.OK);
	}

	@DeleteMapping("/Employee/{id}")
	public ResponseEntity<String> delete(@PathVariable() Integer id) {
		service.deleteEmployee(id);
		return new ResponseEntity<String>("Successfully Deleted  the Employee" + id, HttpStatus.OK);

	}

	@GetMapping("/Employee/{id}")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		return new ResponseEntity<List<Employee>>(service.getallEmployee(), HttpStatus.OK);

	}

	@PostMapping("/Employee/register")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
		service.addEmployee(emp);
		return new ResponseEntity<String>("Created", HttpStatus.CREATED);

	}
}
