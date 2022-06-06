
package se.informator.t2731.db;

public interface EnhancedPhoneBook extends PhoneBook{
	
	/**
	 * Removes an existing entry from the database if existing
	 * @param name the key to the entry
	 */
	public void removeEntry(String name);
	
	/**
	 * Updates an existing entry by changing number for the given name(key)
	 * @param name
	 * @param number
	 */
	public void updateEntry(String name, String number);

}
