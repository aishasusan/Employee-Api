package com.user.controller;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;
import com.user.model.Employee;
import com.user.service.Services;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HomeControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private Services service;

	@InjectMocks
	private HomeController controller;

	public static Employee getEmployee() {
		Employee emp = new Employee();

		emp.setDepartment("mechatronics");
		emp.setEmployeeName("Dean Winchester");

		return emp;
	}

	@Test
	public void postEmployeeTest() throws Exception {

		when(service.addEmployee(any())).thenReturn(true);
		mock.perform(MockMvcRequestBuilders.post("/employee/Employee/register").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getEmployee()))).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(MockMvcResultHandlers.print());

	}
	

	@Test
	public void putEmployeeTest() throws Exception {

		when(service.addEmployee(any())).thenReturn(true);
		mock.perform(MockMvcRequestBuilders.put("/employee/Employee/1").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getEmployee()))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}
	
	@Test
	public void getEmployeeTest() throws Exception {

		 List<Employee> employee = null;
		when(service.getallEmployee()).thenReturn(employee);
		mock.perform(MockMvcRequestBuilders.get("/employee/Employee/1").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getEmployee()))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}
	

	@Test
	public void deleteEmployeeTest() throws Exception {

		mock.perform(MockMvcRequestBuilders.delete("/employee/Employee/2").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getEmployee()))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}
	
	
	      
	
}
