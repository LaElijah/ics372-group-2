package edu.metrostate.oodi.brewandbyte.model;

public class Customer {
	private final String loyaltyStatus;
	private final String name;
	private final String phoneNumber;
	
	public Customer(String loyaltyStatus, String name, String phoneNumber) {
		this.loyaltyStatus = loyaltyStatus;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public boolean checkLoyalty() {
		throw new UnsupportedOperationException("not implemented");
	}
}
