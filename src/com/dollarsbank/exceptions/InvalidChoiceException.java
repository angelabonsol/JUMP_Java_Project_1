package com.dollarsbank.exceptions;

public class InvalidChoiceException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidChoiceException() {
		super("Invalid choice from the menu!");
	}
	
	public InvalidChoiceException(int startChoice, int endChoice) {
		super("Please choose from " + startChoice +  " to " + endChoice + " only.");
	}
}
