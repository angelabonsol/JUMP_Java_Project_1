package com.dollarsbank.exceptions;

public class AccountDoesNotExistException extends Exception{

	private static final long serialVersionUID = 1L;

	public AccountDoesNotExistException() {
		System.out.println("Account Does Not Exist. Try Again! \n");
	}

}
