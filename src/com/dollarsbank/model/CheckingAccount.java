package com.dollarsbank.model;

public class CheckingAccount extends Account {

	private int debitNum;
	
	public CheckingAccount() {
		super();
	}

	public CheckingAccount(int id, int debitNum, int balance, AccountType type, String customerId) {
		super(id, balance, type, customerId);
		this.debitNum = debitNum;

	}

	public int getDebitNum() {
		return debitNum;
	}

	public void setDebitNum(int debitNum) {
		this.debitNum = debitNum;
	}
	
	@Override
	public String toString() {
		return "CheckingAccount [debitNum=" + debitNum + ", getId()=" + getId() + ", getBalance()=" + getBalance()
				+ ", getType()=" + getType() + ", getCustomerId()=" + getCustomerId() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
