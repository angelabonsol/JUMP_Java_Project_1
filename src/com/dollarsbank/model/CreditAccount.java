package com.dollarsbank.model;

public class CreditAccount extends Account{
	
	private double limit;

	public CreditAccount() {
		super();
	}

	public CreditAccount(int id, double balance, double limit, AccountType type, String customerId) {
		super(id, balance, type, customerId);
		this.limit = limit;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "CreditAccount [limit=" + limit + ", getId()=" + getId() + ", getBalance()=" + getBalance()
				+ ", getType()=" + getType() + ", getCustomerId()=" + getCustomerId() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	
}
