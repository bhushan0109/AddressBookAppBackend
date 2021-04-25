package com.finovat.model;
import com.finovate.dto.AddressBookDTO;

import lombok.Data;
@Data
public class AddressBookData {

	private int addressBookId;
	private String firstName;
	private String lastName;

	public AddressBookData() {
	}

	public AddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		this.addressBookId = addressBookId;
		this.firstName = addressBookDTO.firstName;
		this.lastName = addressBookDTO.lastName;
	}

	@Override
	public String toString() {
		return "AddressBookData [addressBookId=" + addressBookId + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	
}