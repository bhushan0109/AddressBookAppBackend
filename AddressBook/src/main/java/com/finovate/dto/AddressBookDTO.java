package com.finovate.dto;

import javax.validation.constraints.Pattern;

public class AddressBookDTO {
	
	@Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Invalid firstName")
	public String firstName;
	
	@Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Invalid lastName")
	public String lastName;

	public AddressBookDTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "AddressBookDTO [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}