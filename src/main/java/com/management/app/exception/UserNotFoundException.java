package com.management.app.exception;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String s){
		super(s);
	}
	
}
