package com.management.app.exception;

public class UserAlreadyExistException extends RuntimeException{
	
	public UserAlreadyExistException(String s){
		super(s);
	}
	
}
