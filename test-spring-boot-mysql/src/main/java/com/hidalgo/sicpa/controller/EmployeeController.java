package com.hidalgo.sicpa.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hidalgo.sicpa.entity.Employee;
import com.hidalgo.sicpa.entity.Store;
import com.hidalgo.sicpa.enumeration.StatusEnum;
import com.hidalgo.sicpa.exception.StoreException;
import com.hidalgo.sicpa.service.EmployeeService;

/**
 * Controller in order to exposing rest services for employees
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

	private static final Logger LOG = Logger
			.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.POST, value = "/add/{name}/{id}/{city}/{mail}/{idStore}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addNewEmployee(@PathVariable("name") String name,
			@PathVariable("id") Long id, @PathVariable("city") String city,
			@PathVariable("mail") String mail,
			@PathVariable("idStore") Long idStore) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setStatus(StatusEnum.ACTIVE.getCode());
		employee.setName(name);
		employee.setCity(city);
		employee.setMail(mail);
		Store store = new Store();
		store.setId(idStore);
		employee.setStore(store);
		try {
			employeeService.saveEmployee(employee);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to try to save employee");
			
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{idEmployee}/{id}/{name}/{city}/{email}/{status}/{idStore}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEmployee(@PathVariable("idEmployee") Long idEmployee,
			@PathVariable("id") Long id, @PathVariable("name") String name,
			@PathVariable("city") String city,
			@PathVariable("email") String email,
			@PathVariable("status") String status,
			@PathVariable("idStore") Long idStore) {
		Employee employee = new Employee();
		employee.setIdEmployee(idEmployee);
		employee.setId(id);
		employee.setMail(email);
		employee.setCity(city);
		employee.setName(name);
		employee.setStatus(status);
		Store store = new Store();
		store.setId(idStore);
		employee.setStore(store);
		try {
			employeeService.updateEmployee(employee);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to try to update employee");
			
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable("id") Long id) {
		try {
			Employee employee = new Employee();
			employee.setId(id);
			employee.setStatus(StatusEnum.INACTIVE.getCode());
			employeeService.removeEmployee(employee);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to try to delete employee");
			
		}
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		Iterable<Employee> employees = null;
		try {
			employees = employeeService.findAll();
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all employees");
			
		}
		return employees;
	}

	@GetMapping(path = "/id/{id}")
	public @ResponseBody Employee getEmployeeById(
			@PathVariable("id") Long id) {
		Employee employee = null;
		try {
			employee = employeeService.findById(id);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all employees");
			
		}
		return employee;
	}

	@GetMapping(path = "/store/{id}")
	public @ResponseBody Iterable<Employee> getAllEmployeesByStore(
			@PathVariable("id") Long id) {
		Iterable<Employee> employees = null;
		try {
			Store store = new Store();
			store.setId(id);
			employees = employeeService.findByStore(store);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all employees");
			
		}
		return employees;
	}

	@GetMapping(path = "/mail/{mail}")
	public @ResponseBody Iterable<Employee> getAllEmployeesByName(
			@PathVariable("mail") String mail) {
		Iterable<Employee> employees = null;
		try {
			employees = employeeService.findByMail(mail);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all employees");
			
		}
		return employees;
	}

	@GetMapping(path = "/status/{status}")
	public @ResponseBody Iterable<Employee> getAllEmployeesBystatus(
			@PathVariable("status") String status) {
		Iterable<Employee> employees = null;
		try {
			employees = employeeService.findByStatus(status);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all employees");
			
		}
		return employees;
	}

}
