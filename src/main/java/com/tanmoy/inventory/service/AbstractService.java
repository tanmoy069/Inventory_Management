package com.tanmoy.inventory.service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;

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
	public final String DATE_PATTERN_1 = "yyyy-MM-dd";
	public final DateTimeFormatter DF = DateTimeFormatter.ofPattern(DATE_PATTERN_1);		

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
	 * Use this to get double value from string
	 * 
	 * @param String
	 * @return double of string value
	 */
	public Double getDouble(String str) {
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			return 0.0;
		}
	}
	
	/**
	 * Use this to get boolean value from string
	 * 
	 * @param String
	 * @return integer of string value
	 */
	public boolean getBoolean(String str) {
		try {
			return Integer.parseInt(str) == 1 ? true : false;
		} catch (Exception e) {
			return false;
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
			return new SimpleDateFormat(DATE_PATTERN_1).parse(date);
		} catch (Exception e) {
			log.info("Failed to parse date : " + date);
			return null;
		}
	}
	
	/**
	 * Check requested by user is authenticated or not.
	 *  
	 * @return if authenticated then true else false
	 */
	public boolean isAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
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
