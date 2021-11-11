package com.dollarsbank.exceptions;

public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException() {
		System.out.println("Invalid Credentials. Try Again! \n");
	}

}
