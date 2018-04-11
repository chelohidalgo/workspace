package com.hidalgo.sicpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.hidalgo.sicpa.entity.Employee;
import com.hidalgo.sicpa.entity.Store;
import com.hidalgo.sicpa.exception.RepositoryException;

/**
 * Allow to make CRUD operations for employees over the database
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	public Employee findById(Long id) throws RepositoryException;

	public Employee findByName(String name) throws RepositoryException;

	public Iterable<Employee> findByStore(Store store)
			throws RepositoryException;

	public Iterable<Employee> findByMail(String mail)
			throws RepositoryException;

	public Iterable<Employee> findByStatus(String status)
			throws RepositoryException;

}
