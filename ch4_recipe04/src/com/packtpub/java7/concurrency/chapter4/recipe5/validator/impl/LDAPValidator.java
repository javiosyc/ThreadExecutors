package com.packtpub.java7.concurrency.chapter4.recipe5.validator.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.packtpub.java7.concurrency.chapter4.recipe5.validator.UserValidator;

/**
 * This class implement a simulation of a user validation system. It suspend the Thread
 * a random period of time and then returns a random boolean value. We consider that it
 * returns the true value when the user is validated and the false value when it's not
 *
 */
public class LDAPValidator implements UserValidator{
	
	/**
	 * The name of the validation system
	 */
	private final String name = "LDAP";
	
	/**
	 * Constructor of the class
	 * @param name The name of the user validation system
	 */
	public LDAPValidator() {
		
	}
	
	/**
	 * Method that validates a user
	 * @param name Name of the user
	 * @param password Password of the user
	 * @return true if the user is validated and false if not
	 */
	public boolean validate(String name, String password) {
		try {
			doQuery();
		} catch (InterruptedException e) {
			return false;
		}
		
		// Return a random boolean value
		Random random=new Random();
		return random.nextBoolean();
	}
	
	private void doQuery() throws InterruptedException {
		
		// Sleep the thread during a random period of time
		Long duration=(long)(Math.random()*10);
		System.out.printf("Validator %s: Validating a user during %d seconds\n",this.name,duration);
		TimeUnit.SECONDS.sleep(duration);
	
	}

	/**
	 * Return the name of the validation system
	 * @return The name of the validation system
	 */
	public String getName(){
		return name;
	}

}
