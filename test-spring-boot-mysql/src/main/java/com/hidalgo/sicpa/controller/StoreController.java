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

import com.hidalgo.sicpa.entity.Store;
import com.hidalgo.sicpa.enumeration.StatusEnum;
import com.hidalgo.sicpa.exception.StoreException;
import com.hidalgo.sicpa.service.StoreService;

/**
 * Controller in order to exposing rest services for stores
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
@Controller
@RequestMapping(path = "/store")
public class StoreController {

	private static final Logger LOG = Logger.getLogger(StoreController.class);

	@Autowired
	private StoreService storeService;

	@RequestMapping(method = RequestMethod.POST, value = "/add/{name}/{ruc}/{city}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addNewStore(@PathVariable String name,
			@PathVariable("ruc") String ruc, @PathVariable("city") String city) {
		Store store = new Store();
		store.setName(name);
		store.setCity(city);
		store.setRuc(ruc);
		store.setStatus(StatusEnum.ACTIVE.getCode());
		try {
			storeService.saveStore(store);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to try to save the store");

		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{name}/{id}/{ruc}/{city}/{status}")
	@ResponseStatus(HttpStatus.OK)
	public void updateStore(@PathVariable String name,
			@PathVariable("id") Long id, @PathVariable("ruc") String ruc,
			@PathVariable("city") String city,
			@PathVariable("status") String status) {
		Store store = new Store();
		store.setId(id);
		store.setCity(city);
		store.setRuc(ruc);
		store.setName(name);
		store.setStatus(status);
		try {
			storeService.updateStore(store);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to try to update the store");

		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteStore(@PathVariable("id") Long id) {
		try {
			Store store = new Store();
			store.setId(id);
			store.setStatus(StatusEnum.INACTIVE.getCode());
			storeService.removeStore(store);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to try to delete the store");

		}
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Store> getAllStores() {
		Iterable<Store> stores = null;
		try {
			stores = storeService.findAll();
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all stores");

		}
		return stores;
	}

	@GetMapping(path = "/ruc/{ruc}")
	public @ResponseBody Iterable<Store> getAllStoresByRuc(
			@PathVariable("ruc") String ruc) {
		Iterable<Store> stores = null;
		try {
			stores = storeService.findByRuc(ruc);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all stores");

		}
		return stores;
	}

	@GetMapping(path = "/status/{status}")
	public @ResponseBody Iterable<Store> getAllStoresByStatus(
			@PathVariable("status") String status) {
		Iterable<Store> stores = null;
		try {
			stores = storeService.findByStatus(status);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all stores");

		}
		return stores;
	}

	@GetMapping(path = "/{id}")
	public @ResponseBody Store getStoreById(@PathVariable("id") Long id) {
		Store store = null;
		try {
			store = storeService.findById(id);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get the store");

		}
		return store;
	}

}
