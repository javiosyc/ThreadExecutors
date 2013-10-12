package com.packtpub.java7.concurrency.chapter4.recipe5.validator;

public interface UserValidator {

	public boolean validate(String name, String password);
	public String getName();
}
