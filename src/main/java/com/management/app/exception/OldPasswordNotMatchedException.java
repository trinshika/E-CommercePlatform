package com.management.app.exception;

public class OldPasswordNotMatchedException extends RuntimeException{

	public OldPasswordNotMatchedException(String s) {
		super(s);
	}
}
