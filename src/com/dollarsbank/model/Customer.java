package com.dollarsbank.model;

import java.util.List;

public class Customer {
	
	String name, address, userId, password; 
	int contactNum; 
	double balance;
	
	private List<Account> accounts;
	private List<String> transactions;
	
	public Customer() {
		new Customer();
	}
	
	public Customer(String name, String address, String userId, String password, int contactNum, double balance,
			List<Account> accounts) {
		super();
		this.name = name;
		this.address = address;
		this.userId = userId;
		this.password = password;
		this.contactNum = contactNum;
		this.balance = balance;
		this.accounts = accounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getContactNum() {
		return contactNum;
	}

	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<String> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", userId=" + userId + ", password=" + password
				+ ", contactNum=" + contactNum + ", balance=" + balance + ", accounts=" + accounts + "]";
	}
	

}
