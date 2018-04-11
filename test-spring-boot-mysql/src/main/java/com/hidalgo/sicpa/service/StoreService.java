package com.hidalgo.sicpa.service;

import java.io.Serializable;

import com.hidalgo.sicpa.entity.Store;
import com.hidalgo.sicpa.exception.StoreException;

/**
 * Services for store 
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
public interface StoreService extends Serializable {

	public void saveStore(Store store) throws StoreException;

	public void removeStore(Store store) throws StoreException;

	public void updateStore(Store store) throws StoreException;

	public Iterable<Store> findAll() throws StoreException;

	public Iterable<Store> findByRuc(String ruc) throws StoreException;

	public Iterable<Store> findByStatus(String status) throws StoreException;

	public Store findById(Long id) throws StoreException;

}
