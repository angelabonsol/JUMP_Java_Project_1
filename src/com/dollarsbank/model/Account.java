package com.dollarsbank.model;

import com.dollarsbank.model.Customer;

public class Account {
	
	public static enum AccountType{
		CHECKING, SAVINGS, CREDIT
	}

	private int id, balance;

	private AccountType type;
	private Customer customer; 

}
