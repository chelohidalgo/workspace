package com.hidalgo.sicpa.service;

import java.io.Serializable;

import com.hidalgo.sicpa.entity.Employee;
import com.hidalgo.sicpa.entity.Store;
import com.hidalgo.sicpa.exception.StoreException;

/**
 * Services for employee 
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
public interface EmployeeService extends Serializable {

	public void saveEmployee(Employee employee) throws StoreException;

	public void removeEmployee(Employee employee) throws StoreException;

	public void updateEmployee(Employee employee) throws StoreException;

	public Employee findById(Long id) throws StoreException;

	public Iterable<Employee> findAll() throws StoreException;

	public Iterable<Employee> findByStore(Store store) throws StoreException;

	public Iterable<Employee> findByMail(String mail) throws StoreException;

	public Iterable<Employee> findByStatus(String status) throws StoreException;

}
