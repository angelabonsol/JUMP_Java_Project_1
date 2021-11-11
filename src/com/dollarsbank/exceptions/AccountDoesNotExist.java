package com.dollarsbank.exceptions;

public class AccountDoesNotExist extends Exception{

	private static final long serialVersionUID = 1L;

	public AccountDoesNotExist() {
		System.out.println("Account Does Not Exist. Try Again! \n");
	}

}
