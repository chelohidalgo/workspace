package com.hidalgo.sicpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.hidalgo.sicpa.entity.Store;
import com.hidalgo.sicpa.exception.RepositoryException;

/**
 * Allow to make CRUD operations for store over the database
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
public interface StoreRepository extends CrudRepository<Store, Long> {

	public Store findById(Long id) throws RepositoryException;

	public Iterable<Store> findByRuc(String ruc) throws RepositoryException;

	public Iterable<Store> findByStatus(String status)
			throws RepositoryException;

}
