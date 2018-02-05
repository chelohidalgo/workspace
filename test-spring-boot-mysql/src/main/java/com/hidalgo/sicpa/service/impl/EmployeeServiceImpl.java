package com.hidalgo.sicpa.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hidalgo.sicpa.entity.Employee;
import com.hidalgo.sicpa.entity.Store;
import com.hidalgo.sicpa.exception.StoreException;
import com.hidalgo.sicpa.repository.EmployeeRepository;
import com.hidalgo.sicpa.service.EmployeeService;

/**
 * Implementation of services for employee
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = Logger
			.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) throws StoreException {
		try {
			employeeRepository.save(employee);
		} catch (DataIntegrityViolationException e) {
			LOG.error("Error: There is an employee with the same id");
			throw new StoreException(
					"Error: There is an employee with the same id");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to save employee");
		}
	}

	@Override
	public void removeEmployee(Employee employee) throws StoreException {
		Employee employeeAux = null;
		try {
			employeeAux = employeeRepository.findById(employee.getId());
			if (employeeAux != null) {
				employeeAux.setCity(employee.getCity());
				employeeAux.setMail(employee.getMail());
				employeeAux.setName(employee.getName());
				employeeAux.setStatus(employee.getStatus());
				employeeAux.setStore(employee.getStore());
				employeeRepository.save(employeeAux);
			} else {
				LOG.info("Employee not founded");
				throw new StoreException("Employee not founded, try again");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to remove employee");
		}
	}

	@Override
	public void updateEmployee(Employee employee) throws StoreException {
		Employee employeeAux = null;
		try {
			employeeAux = employeeRepository.findOne(employee.getIdEmployee());
			if (employeeAux != null) {
				employeeAux.setId(employee.getId());
				employeeAux.setCity(employee.getCity());
				employeeAux.setMail(employee.getMail());
				employeeAux.setName(employee.getName());
				employeeAux.setStatus(employee.getStatus());
				employeeAux.setStore(employee.getStore());
				employeeRepository.save(employeeAux);
			} else {
				LOG.info("Employee not founded");
				throw new StoreException("Employee not founded, try again...");
			}
		} catch (DataIntegrityViolationException e) {
			LOG.error("Error: There is an employee with the same id");
			throw new StoreException(
					"Error: There is an employee with the same id");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to update employee");
		}
	}

	@Override
	public Iterable<Employee> findAll() throws StoreException {
		try {
			return employeeRepository.findAll();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to save employees");
		}
	}

	@Override
	public Employee findById(Long id) throws StoreException {
		try {
			return employeeRepository.findOne(id);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find employee id "
							+ id);
		}
	}

	@Override
	public Iterable<Employee> findByStore(Store store) throws StoreException {
		try {
			return employeeRepository.findByStore(store);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find employees by store");
		}
	}

	@Override
	public Iterable<Employee> findByMail(String mail) throws StoreException {
		try {
			return employeeRepository.findByMail(mail);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find employees by mail");
		}
	}

	@Override
	public Iterable<Employee> findByStatus(String status) throws StoreException {
		try {
			return employeeRepository.findByStatus(status);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find employees by status");
		}
	}

}
