package com.dollarsbank.model;

public class Account {
	
	public static enum AccountType{
		CHECKING, SAVINGS, CREDIT
	}

	private String customerId;
	private int id; 
	private double balance;

	private AccountType type;
	
	public Account() {
		this(1, 500, AccountType.SAVINGS, "user1");
	}
	
	//For first time customers
	public Account(int id, double balance, String customerId) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = AccountType.SAVINGS;
		this.customerId = customerId;
	}
	
	public Account(int id, double balance, AccountType type,  String customerId) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "[id= " + id + ", balance= " + balance + ", type= " + type + "]";
	}
	
	public String fileFormat() {
		return id + "  " + balance + "  " + type.toString() + "  " + customerId;
	}
	
}
