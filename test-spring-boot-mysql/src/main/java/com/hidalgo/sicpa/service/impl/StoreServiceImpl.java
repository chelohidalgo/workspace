package com.hidalgo.sicpa.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hidalgo.sicpa.entity.Store;
import com.hidalgo.sicpa.exception.StoreException;
import com.hidalgo.sicpa.repository.StoreRepository;
import com.hidalgo.sicpa.service.StoreService;

/**
 * Implementation of services for store
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
@Service
public class StoreServiceImpl implements StoreService {

	private static final Logger LOG = Logger.getLogger(StoreServiceImpl.class);

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public void saveStore(Store store) throws StoreException {
		try {
			storeRepository.save(store);
		} catch (DataIntegrityViolationException e) {
			LOG.error("Error: There is a store with the same ruc");
			throw new StoreException(
					"Error: There is a store with the same ruc");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to save store");
		}
	}

	@Override
	public void removeStore(Store store) throws StoreException {
		Store storeAux = null;
		try {
			storeAux = storeRepository.findOne(store.getId());
			if (storeAux != null) {
				storeAux.setStatus(store.getStatus());
				storeRepository.save(storeAux);
			} else {
				LOG.info("Store not founded");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to remove store");
		}
	}

	@Override
	public void updateStore(Store store) throws StoreException {
		Store storeAux = null;
		try {
			storeAux = storeRepository.findOne(store.getId());
			if (storeAux != null) {
				storeAux.setCity(store.getCity());
				storeAux.setRuc(store.getRuc());
				storeAux.setName(store.getName());
				storeAux.setStatus(store.getStatus());
				storeRepository.save(storeAux);
			} else {
				LOG.info("Store not founded");
				throw new StoreException("Store not founded, try again...");
			}
		} catch (DataIntegrityViolationException e) {
			LOG.error("Error: There is a store with the same ruc");
			throw new StoreException(
					"Error: There is a store with the same ruc");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to update store");
		}
	}

	@Override
	public Iterable<Store> findAll() throws StoreException {
		try {
			return storeRepository.findAll();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find all stores");
		}
	}

	@Override
	public Store findById(Long id) throws StoreException {
		try {
			return storeRepository.findOne(id);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find the store id "
							+ id);
		}
	}

	@Override
	public Iterable<Store> findByRuc(String ruc) throws StoreException {
		try {
			return storeRepository.findByRuc(ruc);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find stores by Ruc ");
		}
	}

	@Override
	public Iterable<Store> findByStatus(String status) throws StoreException {
		try {
			return storeRepository.findByStatus(status);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find stores by status ");
		}
	}

}
