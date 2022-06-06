package se.informator.t2731.db;

import java.util.Set;

public interface PhoneBook {
	
	/**
	 * Saves a key/value pair in a data structure
	 * @param name holding the key
	 * @param number holding the value
	 *
	 */
	public void addNameAndNumber(String name, String number);
	
	/**
	 * Finds a number(value) matching a name(key()
	 * @param name the key
	 * @return String holding the matching number if any
	 * if no matching name is found an empty String is returned 
	 */
	public String findNumber(String name);
	
	/**
	 *   Returns all names in the mapped data structure
	 *   @return Set holding all names (keys)
	 */	
	public Set<String> getAllNames();
	
	/**
	 * Clean up method for storage resource that is opened by constructor
	 */
	public void shutDown();
}
