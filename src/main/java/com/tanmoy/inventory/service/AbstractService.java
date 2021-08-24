package com.tanmoy.inventory.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
	public final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");		

	/**
	 * Use this to get integer value from string
	 * 
	 * @param String
	 * @return integer of string value
	 */
	public int getInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * To parse string from date use this method.
	 * 
	 * @param date
	 * @return
	 */
	public Date getDate(String date) {
		try {
			return new SimpleDateFormat(DF.toString()).parse(date);
		} catch (ParseException e) {
			log.info("Failed to parse date : " + date);
			return null;
		}
	}

	/**
	 * To get T object by object's primary id
	 * 
	 * @param id
	 * @return T object
	 */
	public abstract T findById(int id);

	/**
	 * To get all items of T domain
	 * 
	 * @return all items of T object
	 */
	public abstract List<T> findAll();

	/**
	 * To Save T object. Validation has been added, so no need to check validation
	 * in sub classes. It will automatically validate first before save object.
	 * 
	 * @param T
	 * @return if successfully saved then true else false;
	 */
	public abstract boolean save(@Valid T obj);

	/**
	 * To Update T object. Validation has been added, so no need to check validation
	 * in sub classes. It will automatically validate first before update object.
	 * 
	 * @param T
	 * @return if successfully updated then true else false;
	 */
	public abstract boolean update(@Valid T obj);

	/**
	 * To delete T object
	 * 
	 * @param obj
	 * @return if successfully deleted then true else false;
	 */
	public abstract boolean deleteById(int id);

}
