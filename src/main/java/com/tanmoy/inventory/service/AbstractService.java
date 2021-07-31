package com.tanmoy.inventory.service;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;


/**
 * AbstractService class can be used globally for all the service class of
 * domain classes.
 * 
 * @author tanmoy.tushar
 * @since 2021-07-03
 * @param <T> pass domain class here
 */
public abstract class AbstractService<T> {
	protected final static Logger log = Logger.getLogger(AbstractService.class.getName());

	public int getInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public abstract T findById(int id);

	public abstract List<T> findAll();

	public abstract boolean save(@Valid T obj);

	public abstract boolean update(@Valid T obj);

	public abstract boolean deleteById(int id);

}
